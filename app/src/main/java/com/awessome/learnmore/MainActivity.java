package com.awessome.learnmore;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.awessome.learnmore.api.ApiConstants;
import com.awessome.learnmore.api.ApiRequest;
import com.awessome.learnmore.constants.Constants;
import com.awessome.learnmore.fragments.CountriesFragment;
import com.awessome.learnmore.models.Country;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CountriesFragment.OnCountrySelected {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    getAllCountry();
  }

  @Override
  public void onCountrySelected(Country country) {
    Intent countryDetailIntent = new Intent(this, CountryDetailActivity.class);
    countryDetailIntent.putExtra(Constants.INTENT_EXTRA_COUNTRY, country);
    startActivity(countryDetailIntent);
  }

  private void setupFragment(ArrayList<Country> countries){
    CountriesFragment countriesFragment = CountriesFragment.newInstance(countries);
    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
    ft.replace(R.id.frame_main__countries_fragment_placeholder, countriesFragment).commit();
  }

  private void getAllCountry(){
    final SharedPreferences sp = getSharedPreferences(Constants.SHARED_PREFERENCES_COUNTRIES, MODE_PRIVATE);
    String countriesJson = sp.getString(Constants.SHARED_PREFERENCES_COUNTRIES, null);
    if(countriesJson == null){
      String url = ApiConstants.baseUrl + ApiConstants.allCountries;
      new ApiRequest().call(url, "GET", null, new ApiRequest.OnRequestComplete() {
        @Override
        public void onError(String error) {
          Log.w("error debug", error);
        }

        @Override
        public void onSuccess(String data) {
          ObjectMapper mapper = new ObjectMapper();
          try {
            final ArrayList<Country> countries = mapper.readValue(data, new TypeReference<ArrayList<Country>>(){});
            SharedPreferences.Editor editor = sp.edit();
            editor.putString(data, null);
            editor.apply();
            runOnUiThread(new Runnable() {
              @Override
              public void run() {
                setupFragment(countries);
              }
            });
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      });
    }
    else{
      ObjectMapper mapper = new ObjectMapper();
      try {
        ArrayList<Country> countries = mapper.readValue(countriesJson, new TypeReference<ArrayList<Country>>(){});
        setupFragment(countries);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}

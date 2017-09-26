package com.awessome.learnmore;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.awessome.learnmore.constants.Constants;
import com.awessome.learnmore.databinding.ActivityCountryDetailBinding;
import com.awessome.learnmore.models.Country;

public class CountryDetailActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);


    Country country = getIntent().getParcelableExtra(Constants.INTENT_EXTRA_COUNTRY);
    getSupportActionBar().setTitle(country.getName());
    ActivityCountryDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_country_detail);
    binding.setCountry(country);
  }
}

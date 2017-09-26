package com.awessome.learnmore.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.awessome.learnmore.R;
import com.awessome.learnmore.adapters.CountriesAdapter;
import com.awessome.learnmore.constants.Constants;
import com.awessome.learnmore.models.Country;

import java.util.ArrayList;

public class CountriesFragment extends Fragment{
  ArrayList<Country> mCountries = new ArrayList<>();
  OnCountrySelected mCallBack;

  public static CountriesFragment newInstance(ArrayList<Country> countries) {
    CountriesFragment fragment = new CountriesFragment();
    Bundle args = new Bundle();
    args.putParcelableArrayList(Constants.INTENT_EXTRA_COUNTRIES, countries);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      mCountries = getArguments().getParcelableArrayList(Constants.INTENT_EXTRA_COUNTRIES);
    }
  }

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    if (context instanceof OnCountrySelected) {
      mCallBack = (OnCountrySelected) context;
    } else {
      throw new RuntimeException(context.toString() + " must implement OnAttendanceCardSelected");
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.list_view_main__countries_list, container, false);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    ListView listViewCountries = getActivity().findViewById(R.id.list_view_fragment_countries__countries_listview);
    CountriesAdapter adapter = new CountriesAdapter(getContext(), R.layout.list_view_main__countries_list, mCountries);
    listViewCountries.setAdapter(adapter);
    listViewCountries.setOnItemClickListener(onCountryClickListener);
  }

  AdapterView.OnItemClickListener onCountryClickListener = new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
      mCallBack.onCountrySelected(mCountries.get(i));
    }
  };

  public interface OnCountrySelected {
    void onCountrySelected(Country country);
  }
}

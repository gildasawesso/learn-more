package com.awessome.learnmore.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.awessome.learnmore.R;
import com.awessome.learnmore.models.Country;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

public class CountriesAdapter extends ArrayAdapter {
  public CountriesAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List objects) {
    super(context, resource, objects);
  }

  @Override
  public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){
    View countryView = convertView;

    if(countryView == null){
      LayoutInflater inflater = LayoutInflater.from(getContext());
      countryView = inflater.inflate(R.layout.list_view_cell_main__country, parent, false);
    }

    TextView textViewCountryName = countryView.findViewById(R.id.text_view_fragment_countries__country_name);
    TextView textViewCountryArea = countryView.findViewById(R.id.text_view_fragment_countries__country_area);
    ImageView imageViewCountry = countryView.findViewById(R.id.image_view_fragment_countries__country_flag);

    Country country = (Country) getItem(position);

    textViewCountryName.setText(country.getName());
    textViewCountryArea.setText(String.valueOf(country.getArea()) + " km2");
    Glide.with(getContext())
            .load("http://www.countryflags.io/" + country.getAlpha2Code() +  "/flat/64.png")
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(true)
            .into(imageViewCountry);

    return countryView;
  }
}

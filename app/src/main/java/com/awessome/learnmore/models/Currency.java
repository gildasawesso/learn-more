package com.awessome.learnmore.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by gilda on 9/26/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Currency implements Parcelable {
  private String code;
  private String name;
  private String symbol;

  public Currency() {
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.code);
    dest.writeString(this.name);
    dest.writeString(this.symbol);
  }

  protected Currency(Parcel in) {
    this.code = in.readString();
    this.name = in.readString();
    this.symbol = in.readString();
  }

  public static final Parcelable.Creator<Currency> CREATOR = new Parcelable.Creator<Currency>() {
    @Override
    public Currency createFromParcel(Parcel source) {
      return new Currency(source);
    }

    @Override
    public Currency[] newArray(int size) {
      return new Currency[size];
    }
  };
}

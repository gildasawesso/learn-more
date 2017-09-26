package com.awessome.learnmore.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RegionalBloc implements Parcelable {
  private String acronym;
  private String name;
  private List<String> otherAcronyms;
  private List<String> otherNames;

  public RegionalBloc() {
  }

  public String getAcronym() {
    return acronym;
  }

  public void setAcronym(String acronym) {
    this.acronym = acronym;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<String> getOtherAcronyms() {
    return otherAcronyms;
  }

  public void setOtherAcronyms(List<String> otherAcronyms) {
    this.otherAcronyms = otherAcronyms;
  }

  public List<String> getOtherNames() {
    return otherNames;
  }

  public void setOtherNames(List<String> otherNames) {
    this.otherNames = otherNames;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.acronym);
    dest.writeString(this.name);
    dest.writeStringList(this.otherAcronyms);
    dest.writeStringList(this.otherNames);
  }

  protected RegionalBloc(Parcel in) {
    this.acronym = in.readString();
    this.name = in.readString();
    this.otherAcronyms = in.createStringArrayList();
    this.otherNames = in.createStringArrayList();
  }

  public static final Parcelable.Creator<RegionalBloc> CREATOR = new Parcelable.Creator<RegionalBloc>() {
    @Override
    public RegionalBloc createFromParcel(Parcel source) {
      return new RegionalBloc(source);
    }

    @Override
    public RegionalBloc[] newArray(int size) {
      return new RegionalBloc[size];
    }
  };
}

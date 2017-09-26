package com.awessome.learnmore.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Language implements Parcelable {
  private String iso6391;
  private String iso6392;
  private String name;
  private String nativeName;

  public Language() {
  }

  public String getIso6391() {
    return iso6391;
  }

  public void setIso6391(String iso6391) {
    this.iso6391 = iso6391;
  }

  public String getIso6392() {
    return iso6392;
  }

  public void setIso6392(String iso6392) {
    this.iso6392 = iso6392;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNativeName() {
    return nativeName;
  }

  public void setNativeName(String nativeName) {
    this.nativeName = nativeName;
  }


  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.iso6391);
    dest.writeString(this.iso6392);
    dest.writeString(this.name);
    dest.writeString(this.nativeName);
  }

  protected Language(Parcel in) {
    this.iso6391 = in.readString();
    this.iso6392 = in.readString();
    this.name = in.readString();
    this.nativeName = in.readString();
  }

  public static final Parcelable.Creator<Language> CREATOR = new Parcelable.Creator<Language>() {
    @Override
    public Language createFromParcel(Parcel source) {
      return new Language(source);
    }

    @Override
    public Language[] newArray(int size) {
      return new Language[size];
    }
  };
}

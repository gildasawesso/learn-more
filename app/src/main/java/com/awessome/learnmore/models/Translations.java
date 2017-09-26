package com.awessome.learnmore.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Translations implements Parcelable {
  private String de;
  private String es;
  private String fr;
  private String ja;
  private String it;
  private String br;
  private String pt;

  public String getDe() {
    return de;
  }

  public void setDe(String de) {
    this.de = de;
  }

  public String getEs() {
    return es;
  }

  public void setEs(String es) {
    this.es = es;
  }

  public String getFr() {
    return fr;
  }

  public void setFr(String fr) {
    this.fr = fr;
  }

  public String getJa() {
    return ja;
  }

  public void setJa(String ja) {
    this.ja = ja;
  }

  public String getIt() {
    return it;
  }

  public void setIt(String it) {
    this.it = it;
  }

  public String getBr() {
    return br;
  }

  public void setBr(String br) {
    this.br = br;
  }

  public String getPt() {
    return pt;
  }

  public void setPt(String pt) {
    this.pt = pt;
  }


  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.de);
    dest.writeString(this.es);
    dest.writeString(this.fr);
    dest.writeString(this.ja);
    dest.writeString(this.it);
    dest.writeString(this.br);
    dest.writeString(this.pt);
  }

  public Translations() {
  }

  protected Translations(Parcel in) {
    this.de = in.readString();
    this.es = in.readString();
    this.fr = in.readString();
    this.ja = in.readString();
    this.it = in.readString();
    this.br = in.readString();
    this.pt = in.readString();
  }

  public static final Parcelable.Creator<Translations> CREATOR = new Parcelable.Creator<Translations>() {
    @Override
    public Translations createFromParcel(Parcel source) {
      return new Translations(source);
    }

    @Override
    public Translations[] newArray(int size) {
      return new Translations[size];
    }
  };
}

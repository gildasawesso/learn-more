package com.awessome.learnmore.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country implements Parcelable {
  private String name;
  private List<String> topLevelDomain;
  private String alpha2Code;
  private String alpha3Code;
  private List<String> callingCodes;
  private String capital;
  private List<String> altSpellings;
  private String region;
  private String subregion;
  private String population;
  private List<Double> latlng;
  private String demonym;
  private String area;
  private Double gini;
  private List<String> timezones;
  private List<String> borders;
  private String nativeName;
  private String numericCode;
  private List<Currency> currencies;
  private List<Language> languages;
  private Translations translations;
  private String flag;
  private List<RegionalBloc> regionalBlocs;

  public Country() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<String> getTopLevelDomain() {
    return topLevelDomain;
  }

  public void setTopLevelDomain(List<String> topLevelDomain) {
    this.topLevelDomain = topLevelDomain;
  }

  public String getAlpha2Code() {
    return alpha2Code;
  }

  public void setAlpha2Code(String alpha2Code) {
    this.alpha2Code = alpha2Code;
  }

  public String getAlpha3Code() {
    return alpha3Code;
  }

  public void setAlpha3Code(String alpha3Code) {
    this.alpha3Code = alpha3Code;
  }

  public List<String> getCallingCodes() {
    return callingCodes;
  }

  public void setCallingCodes(List<String> callingCodes) {
    this.callingCodes = callingCodes;
  }

  public String getCapital() {
    return capital;
  }

  public void setCapital(String capital) {
    this.capital = capital;
  }

  public List<String> getAltSpellings() {
    return altSpellings;
  }

  public void setAltSpellings(List<String> altSpellings) {
    this.altSpellings = altSpellings;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getSubregion() {
    return subregion;
  }

  public void setSubregion(String subregion) {
    this.subregion = subregion;
  }

  public String getPopulation() {
    return population;
  }

  public void setPopulation(String population) {
    this.population = population;
  }

  public List<Double> getLatlng() {
    return latlng;
  }

  public void setLatlng(List<Double> latlng) {
    this.latlng = latlng;
  }

  public String getDemonym() {
    return demonym;
  }

  public void setDemonym(String demonym) {
    this.demonym = demonym;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public Double getGini() {
    return gini;
  }

  public void setGini(Double gini) {
    this.gini = gini;
  }

  public List<String> getTimezones() {
    return timezones;
  }

  public void setTimezones(List<String> timezones) {
    this.timezones = timezones;
  }

  public List<String> getBorders() {
    return borders;
  }

  public void setBorders(List<String> borders) {
    this.borders = borders;
  }

  public String getNativeName() {
    return nativeName;
  }

  public void setNativeName(String nativeName) {
    this.nativeName = nativeName;
  }

  public String getNumericCode() {
    return numericCode;
  }

  public void setNumericCode(String numericCode) {
    this.numericCode = numericCode;
  }

  public List<Currency> getCurrencies() {
    return currencies;
  }

  public void setCurrencies(List<Currency> currencies) {
    this.currencies = currencies;
  }

  public List<Language> getLanguages() {
    return languages;
  }

  public void setLanguages(List<Language> languages) {
    this.languages = languages;
  }

  public Translations getTranslations() {
    return translations;
  }

  public void setTranslations(Translations translations) {
    this.translations = translations;
  }

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public List<RegionalBloc> getRegionalBlocs() {
    return regionalBlocs;
  }

  public void setRegionalBlocs(List<RegionalBloc> regionalBlocs) {
    this.regionalBlocs = regionalBlocs;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.name);
    dest.writeStringList(this.topLevelDomain);
    dest.writeString(this.alpha2Code);
    dest.writeString(this.alpha3Code);
    dest.writeStringList(this.callingCodes);
    dest.writeString(this.capital);
    dest.writeStringList(this.altSpellings);
    dest.writeString(this.region);
    dest.writeString(this.subregion);
    dest.writeString(this.population);
    dest.writeList(this.latlng);
    dest.writeString(this.demonym);
    dest.writeString(this.area);
    dest.writeValue(this.gini);
    dest.writeStringList(this.timezones);
    dest.writeStringList(this.borders);
    dest.writeString(this.nativeName);
    dest.writeString(this.numericCode);
    dest.writeTypedList(this.currencies);
    dest.writeTypedList(this.languages);
    dest.writeParcelable(this.translations, flags);
    dest.writeString(this.flag);
    dest.writeTypedList(this.regionalBlocs);
  }

  protected Country(Parcel in) {
    this.name = in.readString();
    this.topLevelDomain = in.createStringArrayList();
    this.alpha2Code = in.readString();
    this.alpha3Code = in.readString();
    this.callingCodes = in.createStringArrayList();
    this.capital = in.readString();
    this.altSpellings = in.createStringArrayList();
    this.region = in.readString();
    this.subregion = in.readString();
    this.population = in.readString();
    this.latlng = new ArrayList<Double>();
    in.readList(this.latlng, Double.class.getClassLoader());
    this.demonym = in.readString();
    this.area = in.readString();
    this.gini = (Double) in.readValue(Double.class.getClassLoader());
    this.timezones = in.createStringArrayList();
    this.borders = in.createStringArrayList();
    this.nativeName = in.readString();
    this.numericCode = in.readString();
    this.currencies = in.createTypedArrayList(Currency.CREATOR);
    this.languages = in.createTypedArrayList(Language.CREATOR);
    this.translations = in.readParcelable(Translations.class.getClassLoader());
    this.flag = in.readString();
    this.regionalBlocs = in.createTypedArrayList(RegionalBloc.CREATOR);
  }

  public static final Parcelable.Creator<Country> CREATOR = new Parcelable.Creator<Country>() {
    @Override
    public Country createFromParcel(Parcel source) {
      return new Country(source);
    }

    @Override
    public Country[] newArray(int size) {
      return new Country[size];
    }
  };
}

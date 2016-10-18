package com.itechart.pkr.domain;

/**
 * Created by nipo on 11/10/15.
 */
public class Address extends DomainObject{

    private String country;
    private String city;
    private String street;
    private String house;
    private int flat;
    private String index;

    public Address(){

    }
    public Address(String country, String city, String street, String house, int flat, String index){

        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
        this.index = index;

    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }



    @Override
    public String toString() {
        return getClass().getSimpleName() +" {  Id: " +getId() + ", " +
                                                "Country: " + country + ", "+
                                                "City: " + city + ", " +
                                                "Street: " + street + ", "+
                                                "House: " + house +", " +
                                                "Flat: " + flat + ", " +
                                                "Zipcode: " + index + "."+ " }";
    }
}

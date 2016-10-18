package com.itechart.pkr.domain;

public class Phone extends DomainObject{

    private String countryCode;
    private String operatorsCode;
    private String phoneNumber;
    private PhoneType type;
    private String comment;


    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getOperatorsCode() {
        return operatorsCode;
    }

    public void setOperatorsCode(String operatorsCode) {
        this.operatorsCode = operatorsCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public PhoneType getType() {
        return type;
    }

    public void setType(PhoneType type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    @Override
    public String toString() {
        return getClass().getSimpleName() +" {   Id: " +getId() + ", " +
                                                "Country code: " + countryCode + ", "+
                                                "Operator's code: " + operatorsCode + ", " +
                                                "Phone number: " + phoneNumber + ", "+
                                                "Phone type: " + type +", " +
                                                "Comment: " + comment + "." + "}";
    }

}

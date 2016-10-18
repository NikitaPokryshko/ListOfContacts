package com.itechart.pkr.domain;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contact extends DomainObject{

    private String firstName;
    private String lastName;
    private String patronymic;
    private Date dateOfBirth;
    private GenderType gender; // male/female
    private String nationality;
    private MaritalStatus maritalStatus;// married/not married/divorced
    private String webSite;
    private String email;
    private String currentJob;
    private int photoId;
    private int addressId;

    private Photo photo;

    private Address address;

    private List<Phone> phones;
    private List<Attachment> attachments;
    //промежуточные поля для разделения дао (используются в сервисах для доступа к отношениям 1 к 1)


    public Contact(String firstName, String lastName, String patronymic, Date dateOfBirth, GenderType gender,
                   String nationality, MaritalStatus maritalStatus, String webSite, String email, String currentJob,
                   Photo photo, Address address, ArrayList<Phone> phones, ArrayList<Attachment> attachments) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.nationality = nationality;
        this.maritalStatus = maritalStatus;
        this.webSite = webSite;
        this.email = email;
        this.currentJob = currentJob;
        this.photo = photo;
        this.address = address;
        this.phones = phones;
        this.attachments = attachments;

    }

    public Contact(){

    }
//    public String getShortAddress(){
//        if (address.getCountry().isEmpty() & address.getCity().isEmpty()){
//            return "-";
//        }
//        else return address.getCountry() + ", " + address.getCity();
//    }

    public String getShortAddress(){
         return address.getCountry() + ", " + address.getCity();
    }

    public String getFullName(){
        return firstName + " " + lastName + " " + patronymic;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }


    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }


    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }


    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address addressId) {
        this.address = addressId;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurrentJob() {
        return currentJob;
    }

    public void setCurrentJob(String currentJob) {
        this.currentJob = currentJob;
    }

    @Override
    public String toString() {
            return getClass().getSimpleName() +" {  Id: " +getId() + ", " +
                    "first name: " + firstName + ", "+
                    "last name: " + lastName+ ", " +
                    "patronymic: " + patronymic + ", "+
                    "date of birth: " + dateOfBirth +", " +
                    "gender: " + gender + ", " +
                    "nationality: " + nationality + ", " +
                    "marital status: " + maritalStatus + ", " +
                    "web site: " + webSite + ", " +
                    "email: " + email + ", " +
                    "current job: " + currentJob + ", " +
                    "photo_id:" + photoId + ", " +
                    "address_id:" + addressId + ", " +
                    "photo: " + photo + ","+ "" +
                    "address: " + address + "."+
                    "phones: " + phones+ ", "+
                    "attachments: " + attachments+ "." + "}";
        }
}
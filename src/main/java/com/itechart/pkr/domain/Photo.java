package com.itechart.pkr.domain;

/**
 * Created by nipo on 11/10/15.
 */
public class Photo extends DomainObject {
    private String photoReference;

    public String getPhotoReference() {
        return photoReference;
    }

    public void setPhotoReference(String photoReference) {
        this.photoReference = photoReference;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +" {Id: " +getId() + ", " +
                                            "photo reference: " + photoReference + "."+ "}";
    }
}

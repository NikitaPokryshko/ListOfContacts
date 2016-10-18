package com.itechart.pkr.domain;


import java.util.Date;

/**
 * Created by nipo on 11/10/15.
 */
public class Attachment extends DomainObject{

    private String attachmentFileName;
    private String attachPath;
    private Date dateOfDownload;
    private String comment;
   /* private Contact contact;

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }*/


   public String getAttachPath() {
       return attachPath;
   }

    public void setAttachPath(String attachPath) {
        this.attachPath = attachPath;
    }


    public String getAttachmentFileName() {
        return attachmentFileName;
    }

    public void setAttachmentFileName(String attachmentFileName) {
        this.attachmentFileName = attachmentFileName;
    }

    public Date getDateOfDownload() {
        return dateOfDownload;
    }

    public void setDateOfDownload(Date dateOfDownload) {
        this.dateOfDownload = dateOfDownload;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


}

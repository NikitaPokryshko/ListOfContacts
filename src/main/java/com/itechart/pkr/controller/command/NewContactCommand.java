package com.itechart.pkr.controller.command;


import com.itechart.pkr.controller.View;

import javax.servlet.http.HttpServletRequest;

public class NewContactCommand implements ICommand {

  public View execute(HttpServletRequest request) {
//    String fName = parameter.getParameter("firstName");
//    String lName = parameter.getParameter("lastName");
//    String patro = parameter.getParameter("patronymic");
//    Date dateOfBith  = Date.valueOf(parameter.getParameter("dateOfBirth"));
//    GenderType gender = GenderType.valueOf(parameter.getParameter("gender"));
//    String nationality = parameter.getParameter("nationality");
//    MaritalStatus marital = MaritalStatus.valueOf(parameter.getParameter("marital"));
//    String website = parameter.getParameter("website");
//    String email = parameter.getParameter("email");
//    String currentJob = parameter.getParameter("currentJob");
//
//    String country = parameter.getParameter("country");
//    String city = parameter.getParameter("city");
//    String street = parameter.getParameter("street");
//    String house = parameter.getParameter("house");
//    int flat = Integer.parseInt(parameter.getParameter("flat"));
//    String zipcode = parameter.getParameter("zipcode");
//    Address address = new Address(country, city, street, house, flat, zipcode);
//
//    //ПРОБНЫЕ ДАННЫЕ ДЛЯ БД!!!!!!!!
//    Phone phone = new Phone();
//    phone.setCountryCode("375");
//    phone.setOperatorsCode("29");
//    phone.setPhoneNumber("3900553");
//    phone.setType(PhoneType.HOME);
//    phone.setComment("hui hui hui");
//
//    Attachment attachment = new Attachment();
//    attachment.setAttachmentFileName("audio file");
//    attachment.setDateOfDownload(Date.valueOf("2012-10-15"));
//    attachment.setComment("hui hui hui");
//
//    Photo photo = new Photo();
//    photo.setPhotoReference("vk.com/picture");
//
//    ArrayList<Phone> phones = new ArrayList<Phone>();
//    phones.add(phone);
//
//    ArrayList<Attachment> attachments = new ArrayList<Attachment>();
//    attachments.add(attachment);
//
//    Contact contact = new Contact(fName, lName, patro, dateOfBith, gender, nationality, marital, website, email, currentJob, photo, address, phones, attachments);
//
//      ContactService service = null;
//      try {
//          service = ContactService.getService();
//      } catch (SQLException e) {
//          e.printStackTrace();
//      }
//
//      Contact contactAfterService = null;
//      if (service != null) {
//          contactAfterService = service.contactAdd(contact);
//      }
//
//      parameter.setAttribute("contact", contactAfterService);
//    View view = new View("contact");
//    view.isRedirect();

    System.out.println("Hello from NEW CONTACT COMMAND");
    return new View("new_contact");
  }
}

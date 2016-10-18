package com.itechart.pkr.controller.command;


import com.itechart.pkr.domain.Contact;
import com.itechart.pkr.service.ContactService;
import com.itechart.pkr.controller.View;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class GetAllContactsCommand implements ICommand {

//  public View execute(HttpServletRequest request) {
//    try {
//      final ContactService contactService = ContactService.getService();
//      final List<Contact> contacts = contactService.loadAllContacts();
//
//        //цикл для тестирования системы
////        for (Contact co : contacts) {
////            System.out.println(co);
////        }
//      request.setAttribute("contacts", contacts);
//
//    } catch (SQLException e) {
//      e.printStackTrace();
//      //TODO логирование + страничку ошибки
//    }
//    return new View("contacts2");
//
//  }

  public View execute(HttpServletRequest request){
    int page = 1;
    int recordsPerPage = 10;

    if (request.getParameter("page") != null){
      page = Integer.parseInt(request.getParameter("page"));
    }
    try {

      final ContactService contactService = ContactService.getService();
      contactService.loadContactsDependingOnPage(page, recordsPerPage, request);

    } catch (SQLException e){
      e.printStackTrace();
    }

    return new View("contacts2");



  }
}

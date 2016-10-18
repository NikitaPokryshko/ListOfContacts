package com.itechart.pkr.controller.command;

import com.itechart.pkr.controller.View;
import com.itechart.pkr.domain.Contact;
import com.itechart.pkr.service.ContactService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeleteContactCommand implements ICommand {

  private void deleteContacts(String params[]){

   if(params != null && params.length != 0){
      try {

        final ContactService contactService = ContactService.getService();

        for (String contactId : params ) {
          Contact contactToRemove = contactService.contactLoad(Integer.parseInt(contactId));
          contactService.contactDelete(contactToRemove);
        }

      } catch (SQLException e) {
        e.printStackTrace();
        //TODO log странички
      }
   }

  }

  public View execute(HttpServletRequest request) {

    String params[] = request.getParameterValues("id");
    deleteContacts(params);

    final View view = new View("");
    view.setRedirect(true);
    return view;
  }
}

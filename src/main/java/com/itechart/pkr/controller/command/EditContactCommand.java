package com.itechart.pkr.controller.command;


import com.itechart.pkr.controller.View;
import com.itechart.pkr.domain.Contact;
import com.itechart.pkr.service.ContactService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class EditContactCommand implements ICommand {
    public View execute(HttpServletRequest request) {

        String params[] = request.getParameterValues("id");

        View view;
        if(params != null && params.length == 1){
            getContactToEdit(params, request);
            return new View("new_contact");
        }
        else
            view = new View("");
            view.setRedirect(true);

        return view;
    }

    private void getContactToEdit(String[] params, HttpServletRequest request){

        try {
            final ContactService contactService = ContactService.getService();
            final Contact contactToEdit = contactService.contactLoad(Integer.parseInt(params[0]));
            request.setAttribute("contactToEdit", contactToEdit);

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Something wrong with contactService");
        }
    }
}

package com.itechart.pkr.controller.command;

import com.itechart.pkr.controller.View;

import javax.servlet.http.HttpServletRequest;

public class SearchContactsCommand implements ICommand {

    @Override
    public View execute(HttpServletRequest request) {
//        final ContactService contactService = (ContactService) context.getAttribute("contactservice");
//        final String searchParam = parameter.getParameter("search_string");
//        parameter.setAttribute("contacts", contactService.findContactsByName(searchParam));
//             return new View("contacts");
        return new View("search");
    }
}
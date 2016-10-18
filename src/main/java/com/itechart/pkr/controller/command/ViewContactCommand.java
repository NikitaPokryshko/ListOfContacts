package com.itechart.pkr.controller.command;

//import com.itechart.pokryshko.domain.Attachment;
//import com.itechart.pokryshko.domain.Contact;
//import com.itechart.pokryshko.domain.Phone;
//import com.itechart.pokryshko.service.ContactService;
//import com.itechart.pokryshko.service.Reflection;

import com.itechart.pkr.controller.View;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by nipo on 12/7/15.
 */
public class ViewContactCommand implements ICommand {
    public View execute(HttpServletRequest request) {

//        final String attachDescribe = Reflection.getObjectDescribeAsJSON( Attachment.class );
//        parameter.setAttribute( "attachmentdescribe", attachDescribe );
//        parameter.setAttribute( "attachmentclassname", Attachment.class.getSimpleName() );
//        final String phoneDescribe = Reflection.getObjectDescribeAsJSON( Phone.class );
//        parameter.setAttribute( "phonedescribe", phoneDescribe );
//        parameter.setAttribute( "phoneclassname", Phone.class.getSimpleName() );
//
//        final ContactService contactService = ( ContactService )context.getAttribute( "contactservice" );
//        final Integer id = Integer.valueOf(parameter.getParameter("contactid"));
//        final Contact contact = contactService.contactLoad( id );
//        parameter.setAttribute( "contact", contact );

        return new View("edit_contact");

    }
}

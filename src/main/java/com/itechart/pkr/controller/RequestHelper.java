package com.itechart.pkr.controller;

import com.itechart.pkr.controller.command.*;
import com.sun.org.apache.bcel.internal.generic.ICONST;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by nipo on 9/7/16.
 */
public class RequestHelper {

    private Map<String, Object> commandMap;
    private final static String URL_PREFIX = "/web";

    {
        commandMap = new HashMap<>();
        commandMap.put("error", new ErrorCommand() );
        commandMap.put("", new GetAllContactsCommand());
        commandMap.put("contact", new EditContactCommand());
        commandMap.put("contact/new", new NewContactCommand());
        commandMap.put("delete", new DeleteContactCommand());
        commandMap.put("contact/edit", new EditContactCommand());
        commandMap.put("contact/save", new SaveContactCommand());
        commandMap.put("contact/email", new EmailContactCommand());
        commandMap.put("search", new SearchContactsCommand());
    }

    public ICommand getCommand(HttpServletRequest request){

        if (!commandMap.containsKey(getKey(request))){
            return (ICommand) new ErrorCommand();
        }
        return (ICommand) commandMap.get(getKey(request));
    }



    private String getKey(HttpServletRequest request){
        String key = request.getRequestURI();

        if (key.startsWith(URL_PREFIX)){
            key = key.substring(URL_PREFIX.length());
        }
        if(key.startsWith("/")) {
            key = key.substring(1, key.length());
        }
        if (key.endsWith("/")) {
            key = key.substring(0, key.length() - 1);
        }
        return key;
    }
}

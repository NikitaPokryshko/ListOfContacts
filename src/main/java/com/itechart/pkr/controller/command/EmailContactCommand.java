package com.itechart.pkr.controller.command;

import com.itechart.pkr.controller.View;

import javax.servlet.http.HttpServletRequest;

public class EmailContactCommand implements ICommand {

    public View execute(HttpServletRequest request) {
        System.out.println("HELLO FROM EMAIL COMMAND");
        return new View("email");
    }
}

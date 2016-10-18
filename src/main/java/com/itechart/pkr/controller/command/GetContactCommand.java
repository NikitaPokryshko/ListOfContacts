package com.itechart.pkr.controller.command;

import com.itechart.pkr.controller.View;

import javax.servlet.http.HttpServletRequest;

public class GetContactCommand implements ICommand {

  public View execute(HttpServletRequest request) {
    return new View("contact");
  }
}

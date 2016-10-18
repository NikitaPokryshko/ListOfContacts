package com.itechart.pkr.controller.command;

import com.itechart.pkr.controller.View;

import javax.servlet.http.HttpServletRequest;


public class ErrorCommand implements ICommand {

  public View execute(HttpServletRequest request) {
    //TODO добавить сюда редирект страницы и перепроверить как она сработает
    return new View("error");
  }
}

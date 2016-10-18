package com.itechart.pkr.controller.command;

import com.itechart.pkr.controller.View;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by nipo on 9/7/16.
 */
public interface ICommand {

    View execute(HttpServletRequest request) throws NoSuchFieldException;

}

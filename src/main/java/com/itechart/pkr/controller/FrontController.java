package com.itechart.pkr.controller;

import com.itechart.pkr.controller.command.ErrorCommand;
import com.itechart.pkr.controller.command.ICommand;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/web/*")
public class FrontController extends HttpServlet {

    private RequestHelper requestHelper;
    private ViewResolver viewResolver;

    @Override
    public void init() throws ServletException {

       // super.init(); TODO узнать, зачем этот метод
        requestHelper = new RequestHelper();
        viewResolver = new ViewResolver();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }


    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ICommand command = requestHelper.getCommand(req);
        View view;
        try {
            view = command.execute(req);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            System.err.println("Ошибка выскочила в методе process контроллера");

            view = new ErrorCommand().execute(req);
            dispatch(view, req, resp);
            return; //поэксперементировать с этими строчками (удалить и проверить запрос)
                    // спросить у Жеки по поводу разницы и уточнить
        }
        dispatch(view, req, resp);
    }

    private void dispatch(View view, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String page = viewResolver.resolveView(view);
        if (view.isRedirect()){
            redirect(page, resp);
        } else forward(page, req, resp);

    }


    private void forward(String page, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(req, resp);
    }

    private void redirect(String page, HttpServletResponse resp) throws ServletException, IOException{
        resp.sendRedirect(page);
    }
}

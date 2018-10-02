package com.epam.training.inner.utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

@WebServlet(urlPatterns = { "/requestHeader" })
public class RequestServlet extends HttpServlet {
    private int count = 0;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException {
        performTask(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException {
        performTask(req, resp);
    }

    private void performTask(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException {
        try {
            resp.setContentType(" text/html; charset = Windows - 1251");

            PrintWriter out = resp.getWriter();
            RequestInfo.printToBrowser(out, req);
        } catch (UnsupportedEncodingException e) {
            System.err.print("UnsupportedEncoding");
        } catch
                (IOException e) {
            System.err.print("IOError");
        }
    }
}

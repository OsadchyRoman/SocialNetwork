package com.epam.training.inner.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.util.Enumeration;

public class RequestInfo {
    static
    String br = "<br>";

    public static void printToBrowser(PrintWriter out, HttpServletRequest req) {
        out.println("Method: " + req.getMethod());
        out.print(br + "Request URI: " + req.getRequestURI());
        out.print(br + "Protocol: " + req.getProtocol());
        out.print(br + "PathInfo: " + req.getPathInfo());
        out.print(br + "Remote Address: " + req.getRemoteAddr());
        Enumeration e = req.getHeaderNames();
        out.print(br + "Header INFO: ");
        while (e.hasMoreElements()) {
            String name = (String) e.nextElement();
            String value = req.getHeader(name);
            out.print(br + name + " = " + value);
        }
    }
}

package org.secidea.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Java 1.7/1.8 no CRLF vulns (test in Java 1.7/1.8)
 *
 * @author JoyChou (joychou@joychou.org) @2018-01-03
 */
@Controller
@RequestMapping("/crlf")
public class CRLFInjection {

    public void addCRLFValidation(HttpServletRequest request, HttpServletResponse response) {
        String test3 = request.getParameter("test3");
        if (test3 != null) {
            test3 = test3.replaceAll("(\\r|\\n)","");
            Cookie cookie = new Cookie("test3", test3);
            response.addCookie(cookie);
        }
    }

    @RequestMapping("/safecode")
    @ResponseBody
    public void crlf(HttpServletRequest request, HttpServletResponse response) {
        response.addHeader("test1", request.getParameter("test1"));
        response.setHeader("test2", request.getParameter("test2"));
        String author = request.getParameter("test3");
        addCRLFValidation(request, response);
        Cookie cookie = new Cookie("test3", author);
        response.addCookie(cookie);
    }
}

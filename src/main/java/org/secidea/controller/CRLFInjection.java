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

    @RequestMapping("/safecode")
    @ResponseBody
    public void crlf(HttpServletRequest request, HttpServletResponse response) {
        String test1 = request.getParameter("test1");
        if (test1 != null) {
            test1 = test1.replaceAll("[\\r\\n]","");
            response.addHeader("test1", test1);
        }
        String test2 = request.getParameter("test2");
        if (test2 != null) {
            test2 = test2.replaceAll("[\\r\\n]","");
            response.setHeader("test2", test2);
        }
        String author = request.getParameter("test3");
        String test3 = author;
        if (test3 != null) {
            test3 = test3.replaceAll("[\\r\\n]","");
            Cookie cookie = new Cookie("test3", test3);
        }
        response.addCookie(cookie);
    }
}

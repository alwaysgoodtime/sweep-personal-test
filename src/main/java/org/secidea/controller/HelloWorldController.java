package org.secidea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Controller
public class HelloWorldController {
    @RequestMapping("/")
    @ResponseBody
    public String hello(HttpServletRequest request) {
        return "hello";
    }
}

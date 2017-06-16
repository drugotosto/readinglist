package com.ferrero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by drugo on 16/06/2017.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String greeting() {
        return "Hello World";
    }

}

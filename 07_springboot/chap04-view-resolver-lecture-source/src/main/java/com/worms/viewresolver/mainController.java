package com.worms.viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class mainController {
//    @RequestMapping("/")
//    public String defaultLocation() {
//        return "main";
//    }
//
//    @RequestMapping("/main")
//    public void main() {}

    @RequestMapping(value = {"/", "/main"})
    public String main() {
        return "main";
    }
}
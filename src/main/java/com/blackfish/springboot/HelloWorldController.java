package com.blackfish.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;

/**
 * @Auther: chengchengpeng
 * @Date: 2018/10/24 14:18
 * @Description:
 */
@Controller
public class HelloWorldController {

    @RequestMapping("/helloWorld")
    public String helloWorld(Model m){
        m.addAttribute("now",DateFormat.getDateInstance().format(new Date()));
        return "helloWorld";
    }
}

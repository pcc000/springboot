package com.blackfish.springboot.controller;

import com.blackfish.java.event.OrderEvent;
import com.blackfish.springboot.entity.Student;
import com.blackfish.springboot.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: chengchengpeng
 * @Date: 2018/10/25 19:40
 * @Description:
 */
@Controller
public class StudentController {

    @Autowired
    private ApplicationContext applicationContext;

    @Resource
    StudentMapper studentMapper;

    @RequestMapping("/listStudent")
    public String listStudent(Model model) {
        OrderEvent orderEvent = new OrderEvent("");
        applicationContext.publishEvent(orderEvent);

        List<Student> students = studentMapper.findAll();
        model.addAttribute("students", students);
        return "listStudent";
    }
}

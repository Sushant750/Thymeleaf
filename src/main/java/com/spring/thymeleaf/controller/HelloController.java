package com.spring.thymeleaf.controller;

import com.spring.thymeleaf.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
      return "hello";
}

@RequestMapping("/sendData")
public ModelAndView sendData(){

    ModelAndView data = new ModelAndView("data");
   return data.addObject("message", "Increase your knowledge");
}

@RequestMapping("/student")
public ModelAndView getStudent(){
        ModelAndView modelAndView = new ModelAndView("student");
    Student value = new Student();
    value.setName("Sonu");
    value.setScore(100);
    return modelAndView.addObject("student", value);

}



    @RequestMapping("/students")
    public ModelAndView getStudents(){
        ModelAndView modelAndView = new ModelAndView("studentList");
        Student student = new Student();
        student.setName("Ravi");
        student.setScore(99);

        Student student1 = new Student();
        student1.setName("Hari");
        student1.setScore(98);

        List<Student> studentList = Arrays.asList(student, student1);
        return modelAndView.addObject("students", studentList);

    }


    @RequestMapping("/studentForm")
    public ModelAndView displayStudentForm(){
        ModelAndView modelAndView = new ModelAndView("studentForm");
        Student value = new Student();
        value.setName("Amar");
        value.setScore(100);
        return modelAndView.addObject("student", value);

    }

    @RequestMapping("/saveStudent")
    public ModelAndView saveStudent(@ModelAttribute Student student){
        ModelAndView modelAndView = new ModelAndView("result");
        System.out.println(student.getName());
        System.out.println(student.getScore());
        return modelAndView;
    }



}

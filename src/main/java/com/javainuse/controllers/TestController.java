package com.javainuse.controllers;

import com.javainuse.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    @RequestMapping("/welcome")
    public ModelAndView firstPage() {
        return new ModelAndView("welcome");
    }

    @RequestMapping("/welcome2")
    public String firstPage(Model model) {
        model.addAttribute("helo", "HelloWorld");
        return "welcome_1";
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public Employee employeeDetailsTest() {

        Employee emp = new Employee();
        emp.setName("emp1");
        emp.setDesignation("manager");
        emp.setEmpId("1");
        emp.setSalary(3000);

        return emp;
    }

}

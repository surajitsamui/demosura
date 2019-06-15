package com.javainuse.controllers;

import com.javainuse.model.Employee;
import com.javainuse.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
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

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/viewEmployee/{id}")
    @ResponseBody
    public Employee viewAllItems(@PathVariable String id) {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees.get(Integer.parseInt(id) - 1);
    }
    
    @RequestMapping("/viewEmployees")
    @ResponseBody
    public List<Employee> viewAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
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

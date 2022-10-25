package com.adeanastasia.spring.mvc.wishlist.v1.controller;

import com.adeanastasia.spring.mvc.wishlist.v1.dao.EmpDAO;
import com.adeanastasia.spring.mvc.wishlist.v1.entity.Employee;
import com.adeanastasia.spring.mvc.wishlist.v1.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmpController {
    @Autowired
    private MainService mainService;

    //@GetMapping
    @RequestMapping("/")
    public String showAllEmployees(Model model) {

        List<Employee> allEmployees = mainService.getAllEmployees();
        model.addAttribute("allEmps", allEmployees);
        return "all-employees";
    }

    //@GetMapping("addNewEmployee")
    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee-info";
    }

    //@PostMapping("saveNewEmployee")
    @RequestMapping("/saveNewEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        mainService.saveEmployee(employee);
        return "redirect:/";
    }

    //@GetMapping("updateInfo")
    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int id, Model model) {
        Employee employee = mainService.getEmployee(id);
        model.addAttribute("employee", employee);
        return "employee-info";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int id, Model model) {
        mainService.deleteEmployee(id);
        return "redirect:/";
    }
}

package com.adeanastasia.spring.mvc.wishlist.v1.controller;

import com.adeanastasia.spring.mvc.wishlist.v1.entity.Employee;
import com.adeanastasia.spring.mvc.wishlist.v1.entity.Wish;
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

    @RequestMapping("/wishes")
    public String showEmployeesWishes(@RequestParam("empId") int id, Model model) {
        Employee employee = mainService.getEmployee(id);
        model.addAttribute("employee", employee);
        return "employees-wishes";
    }

    @RequestMapping("/addNewWish")
    public String addNewWish(@RequestParam("empId") int id, Model model) {
        Wish wishlist = mainService.getWishListFromEmployee(id);
        Employee employee = mainService.getEmployee(id);
        Wish wish = new Wish();
        employee.setWishlist(wish);
        mainService.saveEmployee(employee);
        model.addAttribute("employee", employee);
        return "wish-info";
    }

    @RequestMapping("/saveNewWish")
    public String saveWish(@RequestParam("empId") int id, @RequestParam("empWisp") String wish, Model model) {
        mainService.saveWishToEmployee(id, wish);
/*        model.addAttribute("employee", employee);
        model.addAttribute("wishlist", employee.getWishlist());
        mainService.saveEmployee(employee);
        mainService.saveWishToEmployee()*/
     //saveEmployee(employee); // здесь нужно добавить корректное обновление работника или желание

        return "employees-wishes";
    }

}



package com.adeanastasia.spring.mvc.wishlist.v1.service;

import com.adeanastasia.spring.mvc.wishlist.v1.entity.Employee;

import java.util.List;

public interface MainService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployee(int id);
    void deleteEmployee(int id);
}

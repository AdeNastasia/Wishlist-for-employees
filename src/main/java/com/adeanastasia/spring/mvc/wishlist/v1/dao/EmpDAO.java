package com.adeanastasia.spring.mvc.wishlist.v1.dao;

import com.adeanastasia.spring.mvc.wishlist.v1.entity.Employee;
import com.adeanastasia.spring.mvc.wishlist.v1.entity.Wish;

import java.util.List;

public interface EmpDAO {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);

    Employee getEmployee(int id);
    void deleteEmployee(int id);

    void saveWishToEmployee(int id, String wish);

    Wish getWishListFromEmployee(int id);
}

package com.adeanastasia.spring.mvc.wishlist.v1.service;

import com.adeanastasia.spring.mvc.wishlist.v1.dao.EmpDAO;
import com.adeanastasia.spring.mvc.wishlist.v1.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MainServiceImpl implements MainService {

    @Autowired
    private EmpDAO empDAO;

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return empDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        empDAO.saveEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        return empDAO.getEmployee(id);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        empDAO.deleteEmployee(id);
    }
}

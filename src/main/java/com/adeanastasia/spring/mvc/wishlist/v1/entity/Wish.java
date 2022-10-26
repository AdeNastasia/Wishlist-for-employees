package com.adeanastasia.spring.mvc.wishlist.v1.entity;

import javax.persistence.*;

@Entity
@Table(name = "wish")
public class Wish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Column(name = "title_of_wish")
    private String titleOfWish;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Wish() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitleOfWish() {
        return titleOfWish;
    }

    public void setTitleOfWish(String wish) {
        this.titleOfWish = wish;
    }
}

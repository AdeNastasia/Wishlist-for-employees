package com.adeanastasia.spring.mvc.wishlist.v1.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "birth_day")
    private int birthDay;

    @Column(name = "birth_month")
    private String birthMonth;

    public List<Wish> getWishes() {
        return wishes;
    }

    public void setWishes(List<Wish> wishes) {
        this.wishes = wishes;
    }

    @OneToMany(mappedBy = "wish")
    @JoinColumn(name = "wish_id")
    private List<Wish> wishes;

    @Transient // - нужна ли тут эта аннотация ?
    private Map<String, String> monthsList; // оставить ли поле статическим?
    @Transient
    private Map<Integer, Integer> daysList;

    public Map<String, String> getMonthsList() {
        return monthsList;
    }

    public void setMonthsList(Map<String, String> monthsList) {
        this.monthsList = monthsList;
    }

    public Map<Integer, Integer> getDaysList() {
        return daysList;
    }

    public void setDaysList(Map<Integer, Integer> daysList) {
        this.daysList = daysList;
    }

    public Employee() {
        monthsList = new HashMap<>();
        monthsList.put("January", "January");
        monthsList.put("February", "February");
        monthsList.put("March ", "March ");
        monthsList.put("April", "April");
        monthsList.put("May", "May");
        monthsList.put("June ", "June ");
        monthsList.put("July", "July");
        monthsList.put("August", "August");
        monthsList.put("September ", "September ");
        monthsList.put("October ", "October ");
        monthsList.put("November ", "November ");
        monthsList.put("December ", "December ");

        daysList = new HashMap<>();
        for (int i = 1; i < 32; i++) {
            daysList.put(i, i);
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
    }





    public void addWishToEmployee(Wish wish) {
        if (wishes == null) {
            wishes = new ArrayList<>();
        }
        wishes.add(wish);
        wish.setEmployee(this);
    }

}

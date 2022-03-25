package com.emp.model;

import java.io.Serializable;
/*
员工模型类
 */
public class Emp implements Serializable {
    private Integer id;
    private String sname;
    private String ssex;
    private Integer age;
    private Float salary;

    public Emp() {
    }

    public Emp(Integer id) {
        this.id = id;
    }

    public Emp(String sname, String ssex, Integer age, Float salary) {
        this.sname = sname;
        this.ssex = ssex;
        this.age = age;
        this.salary = salary;
    }

    public Emp(Integer id, String sname, String ssex, Integer age, Float salary) {
        this.id = id;
        this.sname = sname;
        this.ssex = ssex;
        this.age = age;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}

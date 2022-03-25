package com.emp.model;

/**
 * @author 故离
 * @data 2022/3/14  10:50
 */
public class User {
    private Integer id;
    private String sname;
    private String spasswd;

    public User() {
    }

    public User(Integer id, String sname, String spasswd) {
        this.id = id;
        this.sname = sname;
        this.spasswd = spasswd;
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

    public String getSpasswd() {
        return spasswd;
    }

    public void setSpasswd(String spasswd) {
        this.spasswd = spasswd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", sname='" + sname + '\'' +
                ", spasswd='" + spasswd + '\'' +
                '}';
    }
}

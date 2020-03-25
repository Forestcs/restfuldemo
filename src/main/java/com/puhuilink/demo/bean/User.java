package com.puhuilink.demo.bean;

import org.springframework.context.annotation.Bean;


public class User {
    private Integer Id;
    private String Name;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                '}';
    }

    public User() {
    }

    public User(Integer id, String name) {
        this.Id = id;
        this.Name = name;
    }
}

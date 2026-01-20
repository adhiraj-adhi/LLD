package com.design.schema.model;

import jakarta.persistence.Entity;
@Entity
public class Student extends BaseModel {
    private String name;
    private String email;
    private String address;
    private String phoneNum;
    private String password;
}

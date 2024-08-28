package com.raks.BookstoreAPI.model;

import lombok.Data;

@Data
public class Customer {
    private Long id;
    private String name;
    private String email;
    private String address;
}

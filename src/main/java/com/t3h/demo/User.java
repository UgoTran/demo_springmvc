package com.t3h.demo;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
public class User {
    private Integer id;
    private LocalDate birthday;
    private String name;
    private String password;
}

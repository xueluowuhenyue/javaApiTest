package com.course.model;

import lombok.Data;

@Data
public class getUserListCase {
    private String id;
    private String userName;
    private String password;
    private String expected;
}

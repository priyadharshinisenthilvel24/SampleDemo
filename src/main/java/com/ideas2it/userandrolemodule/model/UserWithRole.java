package com.ideas2it.userandrolemodule.model;

import lombok.Data;

@Data
public class UserWithRole {
    private Long userId;
    private String userName;
    private String userEmail;
    private String userInfo;
    private int roleId;
}

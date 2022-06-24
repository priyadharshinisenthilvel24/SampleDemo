package com.ideas2it.userandrolemodule.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSchema {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String userId;
    private String userName;
    private String userEmail;
    private String userInfo;

}

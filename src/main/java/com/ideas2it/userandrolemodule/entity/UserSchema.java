package com.ideas2it.userandrolemodule.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "userschema")
public class UserSchema {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_Id",nullable=false)
    private Long userId;
    @Column(name="user_Name")
    private String userName;
    @Column(name="user_Email")
    private String userEmail;
    @Column(name="user_Info")
    private String userInfo;

}

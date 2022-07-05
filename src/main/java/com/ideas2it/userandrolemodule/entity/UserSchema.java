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
@Table(name = "userschema", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class UserSchema {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long userId;
    @Column(name="username")
    private String userName;
    @Column(name="useremail")
    private String userEmail;
    @Column(name="userinfo")
    private String userInfo;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="roleid", referencedColumnName = "id")
    private Role role;

}

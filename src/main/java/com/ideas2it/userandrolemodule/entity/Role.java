package com.ideas2it.userandrolemodule.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "role", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class Role {

    @Id
    @GeneratedValue
    @Column(name = "id",nullable=false)
    private int id;
    @Column(name="role")
    private String role;

    //@OneToMany(mappedBy = "role")
    //private List<UserSchema> listUsers = new ArrayList<>();
}

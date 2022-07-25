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
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class UserSchema {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="role", referencedColumnName = "id")
    private Role role;

}

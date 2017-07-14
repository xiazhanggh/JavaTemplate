package com.build.oa.domain;

import javax.persistence.*;

/**
 * Created by xzhang on 7/14/2017.
 */
@Entity
@Table(name = "oa_user")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "u_name",length = 64)
    private String name;

    @Column(length = 64,nullable = false)
    private String account;

    @Column(length = 64,nullable = false)
    private String password;

    @Column(length = 32)
    private String role;

}

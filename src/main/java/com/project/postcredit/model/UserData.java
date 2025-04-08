package com.project.postcredit.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(unique = true)
    private String userName;
    private String password;
    private String email;
    private String phone;
}

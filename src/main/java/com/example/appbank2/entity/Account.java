package com.example.appbank2.entity;


import com.example.appbank2.entity.Client;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

@Entity
@Table(name = "accounts")
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "status")
    private String status;

    @Column(name = "email")
    private String email;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "currency_code")
    private String currencyCode;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

 //   @Column(name = "currency")
//    @Enumerated(EnumType.STRING)
//  private Currency currency;


}

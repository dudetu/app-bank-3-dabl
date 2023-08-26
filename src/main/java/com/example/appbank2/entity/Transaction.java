package com.example.appbank2.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
@Table(name = "transactions")
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "amout")
    private BigDecimal amount;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "debit_account_id")
    private Account debitAccount;

    @ManyToOne
    @JoinColumn(name = "credit_account_id")
    private Account creditAccount;

    public Long getDebitAccountId() {
        return null;
    }

    public Long getCreditAccountId() {
        return null;
    }
}


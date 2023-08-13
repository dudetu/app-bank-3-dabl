package entity;
import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@EnableTransactionManagement
@Configuration
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

        @Column(name = "balance")
        private BigDecimal balance;

        @Column(name = "currency_code")
        private String currencyCode;

        @Column(name = "created_at")
        private LocalDateTime createdAt;

        @Column(name = "updated_at")
        private LocalDateTime updatedAt;

        @ManyToOne
        @JoinColumn(name = "client_id")
        private Client client;
    }




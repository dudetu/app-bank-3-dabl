package com.example.appbank2.repository;
import com.example.appbank2.entity.Transaction;
import com.example.appbank2.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;

    @Test
    public void testSaveTransaction() {
        // Создаем объект транзакции
        Transaction transaction = new Transaction();
        // Устанавливаем необходимые значения
        transaction.setAmount(BigDecimal.valueOf(100.0));
        transaction.setDescription("Test Transaction");

        // Сохраняем транзакцию в репозитории
        Transaction savedTransaction = transactionRepository.save(transaction);

        // Проверяем, что транзакция успешно сохранена
        assertThat(savedTransaction.getId()).isNotNull();
        assertThat(savedTransaction.getAmount()).isEqualTo(100.0);
        assertThat(savedTransaction.getDescription()).isEqualTo("Test Transaction");
    }

    @Test
    public void testFindTransactionById() {
        // Создаем объект транзакции
        Transaction transaction = new Transaction();
        transaction.setAmount(BigDecimal.valueOf(200.0));
        transaction.setDescription("Another Test Transaction");

        // Сохраняем транзакцию и получаем ее ID
        Transaction savedTransaction = transactionRepository.save(transaction);
        Long transactionId = savedTransaction.getId();

        // Ищем транзакцию по ID
        Optional<Transaction> foundTransaction = transactionRepository.findById(transactionId);

        // Проверяем, что транзакция успешно найдена
        assertThat(foundTransaction).isPresent();
        assertThat(foundTransaction.get().getAmount()).isEqualTo(200.0);
        assertThat(foundTransaction.get().getDescription()).isEqualTo("Another Test Transaction");
    }

    // Аналогично, напишите тесты для остальных операций, таких как findAll, delete, и т.д.
}

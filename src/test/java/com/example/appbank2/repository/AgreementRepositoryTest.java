package com.example.appbank2.repository;

import com.example.appbank2.entity.Agreement;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class AgreementRepositoryTest {

    @Autowired
    private AgreementRepository agreementRepository;

    @Test
    void testSaveAgreement() {
        // Создаем новое соглашение
        Agreement agreement = new Agreement();
        agreement.setDetails("Test Agreement");
        agreement.setType("Service");
        agreement.setStatus("Active");

        // Сохраняем в репозиторий
        Agreement savedAgreement = agreementRepository.save(agreement);

        // Проверяем, что соглашение успешно сохранено
        assertTrue(savedAgreement.getId() > 0);
        assertEquals(agreement.getDetails(), savedAgreement.getDetails());
        assertEquals(agreement.getType(), savedAgreement.getType());
        assertEquals(agreement.getStatus(), savedAgreement.getStatus());
    }

    @Test
    void testFindAllAgreements() {
        // Получаем все соглашения из репозитория
        List<Agreement> agreements = agreementRepository.findAll();

        // Проверяем, что список не пустой
        assertTrue(agreements.size() > 0);
    }

    @Test
    void testFindAgreementById() {
        // Создаем новое соглашение
        Agreement agreement = new Agreement();
        agreement.setDetails("Test Agreement");
        agreement.setType("Service");
        agreement.setStatus("Active");

        // Сохраняем в репозиторий
        Agreement savedAgreement = agreementRepository.save(agreement);

        // Ищем соглашение по ID
        Agreement foundAgreement = agreementRepository.findById(savedAgreement.getId()).orElse(null);

        // Проверяем, что соглашение успешно найдено
        assertEquals(savedAgreement, foundAgreement);
    }

    @Test
    void testDeleteAgreement() {
        // Создаем новое соглашение
        Agreement agreement = new Agreement();
        agreement.setDetails("Test Agreement");
        agreement.setType("Service");
        agreement.setStatus("Active");

        // Сохраняем в репозиторий
        Agreement savedAgreement = agreementRepository.save(agreement);

        // Удаляем соглашение
        agreementRepository.deleteById(savedAgreement.getId());

        // Проверяем, что соглашение больше не существует
        assertTrue(agreementRepository.findById(savedAgreement.getId()).isEmpty());
    }
}

package com.example.appbank2.service;

import com.example.appbank2.entity.Agreement;

import java.util.List;

/**
 * Интерфейс для работы с договорами.
 */
public interface AgreementService {

    /**
     * Получает список всех договоров.
     *
     * @return Список объектов типа Agreement.
     */
    List<Agreement> getAllAgreements();

    /**
     * Получает договор по его идентификатору.
     *
     * @param id Идентификатор договора.
     * @return Объект типа Agreement или null, если договор не найден.
     */
    Agreement getAgreementById(Long id);

    /**
     * Создает новый договор.
     *
     * @param agreement Объект типа Agreement, представляющий новый договор.
     * @return Созданный договор.
     */
    Agreement createAgreement(Agreement agreement);
}

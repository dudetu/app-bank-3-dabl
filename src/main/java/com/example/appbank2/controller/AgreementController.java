package com.example.appbank2.controller;

import com.example.appbank2.entity.Agreement;
import com.example.appbank2.service.AgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для управления договорами.
 */
@RestController
@RequestMapping("/api/agreements")
public class AgreementController {

    private final AgreementService agreementService;

    /**
     * Конструктор контроллера.
     *
     * @param agreementService Сервис управления договорами.
     */
    @Autowired
    public AgreementController(AgreementService agreementService) {
        this.agreementService = agreementService;
    }

    /**
     * Получает список всех договоров.
     *
     * @return ResponseEntity со списком договоров и статусом HTTP.
     */
    @GetMapping("/all")
    public ResponseEntity<List<Agreement>> getAllAgreements() {
        List<Agreement> agreements = agreementService.getAllAgreements();
        return new ResponseEntity<>(agreements, HttpStatus.OK);
    }

    /**
     * Получает договор по его идентификатору.
     *
     * @param id Идентификатор договора.
     * @return ResponseEntity с договором и статусом HTTP.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Agreement> getAgreementById(@PathVariable Long id) {
        Agreement agreement = agreementService.getAgreementById(id);
        if (agreement != null) {
            return new ResponseEntity<>(agreement, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Создает новый договор.
     *
     * @param agreement Новый договор.
     * @return ResponseEntity с созданным договором и статусом HTTP.
     */
    @PostMapping("/create")
    public ResponseEntity<Agreement> createAgreement(@RequestBody Agreement agreement) {
        Agreement createdAgreement = agreementService.createAgreement(agreement);
        return new ResponseEntity<>(createdAgreement, HttpStatus.CREATED);
    }
}

package com.example.appbank2.controller;


import com.example.appbank2.entity.Agreement;
import com.example.appbank2.service.AgreementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AgreementControllerTest {

    @Mock
    private AgreementService agreementService;

    private AgreementController agreementController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        agreementController = new AgreementController(agreementService);
    }

    @Test
    void testGetAllAgreements() {
        // Arrange
        List<Agreement> agreements = Arrays.asList(new Agreement(), new Agreement());
        when(agreementService.getAllAgreements()).thenReturn(agreements);

        // Act
        ResponseEntity<List<Agreement>> response = agreementController.getAllAgreements();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(agreements, response.getBody());
    }

    @Test
    void testGetAgreementById() {
        // Arrange
        Long agreementId = 1L;
        Agreement agreement = new Agreement();
        when(agreementService.getAgreementById(agreementId)).thenReturn(agreement);

        // Act
        ResponseEntity<Agreement> response = agreementController.getAgreementById(agreementId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(agreement, response.getBody());
    }

    @Test
    void testGetAgreementById_NotFound() {
        // Arrange
        Long agreementId = 1L;
        when(agreementService.getAgreementById(agreementId)).thenReturn(null);

        // Act
        ResponseEntity<Agreement> response = agreementController.getAgreementById(agreementId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testCreateAgreement() {
        // Arrange
        Agreement agreement = new Agreement();
        when(agreementService.createAgreement(agreement)).thenReturn(agreement);

        // Act
        ResponseEntity<Agreement> response = agreementController.createAgreement(agreement);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(agreement, response.getBody());
    }
}

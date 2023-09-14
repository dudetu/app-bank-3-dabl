package com.example.appbank2.service;


import com.example.appbank2.entity.Agreement;
import com.example.appbank2.exception.DataNotFoundException;
import com.example.appbank2.repository.AgreementRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class AgreementServiceTest {

    @Mock
    private AgreementRepository agreementRepository;

    @InjectMocks
    private AgreementServiceImpl agreementService;

    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllAgreements() {
        // Arrange
        when(agreementRepository.findAll()).thenReturn(List.of(
                new Agreement(), new Agreement()
        ));

        // Act
        List<Agreement> agreements = agreementService.getAllAgreements();

        // Assert
        assertThat(agreements).hasSize(2);
    }

    @Test
    void testGetAgreementById() {
        // Arrange
        Long agreementId = 1L;
        Agreement agreement = new Agreement();
        when(agreementRepository.findById(agreementId)).thenReturn(Optional.of(agreement));

        // Act
        Agreement result = agreementService.getAgreementById(agreementId);

        // Assert
        assertThat(result).isEqualTo(agreement);
    }

    @Test
    void testGetAgreementByIdNotFound() {
        // Arrange
        Long agreementId = 1L;
        when(agreementRepository.findById(agreementId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(DataNotFoundException.class, () -> agreementService.getAgreementById(agreementId));
    }

    @Test
    void testCreateAgreement() {
        // Arrange
        Agreement agreement = new Agreement();

        // Act
        Agreement result = agreementService.createAgreement(agreement);

        // Assert
        verify(agreementRepository).save(agreement);
        assertThat(result).isEqualTo(agreement);
    }
}

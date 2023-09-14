package com.example.appbank2.service;

import com.example.appbank2.entity.Agreement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.appbank2.repository.AgreementRepository;

import java.util.List;

/**
 * Реализация интерфейса AgreementService для работы с договорами.
 */
@Service
public class AgreementServiceImpl implements AgreementService {

    private final AgreementRepository agreementRepository;

    @Autowired
    public AgreementServiceImpl(AgreementRepository agreementRepository) {
        this.agreementRepository = agreementRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Agreement> getAllAgreements() {
        return agreementRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Agreement getAgreementById(Long id) {
        return agreementRepository.findById(id).orElse(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Agreement createAgreement(Agreement agreement) {
        return agreementRepository.save(agreement);
    }
}

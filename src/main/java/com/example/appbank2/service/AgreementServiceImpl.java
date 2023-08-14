package com.example.appbank2.service;

import com.example.appbank2.entity.Agreement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.appbank2.repository.AgreementRepository;

import java.util.List;

@Service
public class AgreementServiceImpl implements AgreementService {

    private final AgreementRepository agreementRepository;

    @Autowired
    public AgreementServiceImpl(AgreementRepository agreementRepository) {
        this.agreementRepository = agreementRepository;
    }

    @Override
    public List<Agreement> getAllAgreements() {
        return agreementRepository.findAll();
    }

    @Override
    public Agreement getAgreementById(Long id) {
        return agreementRepository.findById(id).orElse(null);
    }

    @Override
    public Agreement createAgreement(Agreement agreement) {
        return agreementRepository.save(agreement);
    }


}


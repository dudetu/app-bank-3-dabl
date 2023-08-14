package com.example.appbank2.service;

import com.example.appbank2.entity.Agreement;

import java.util.List;

public interface AgreementService {
    List<Agreement> getAllAgreements();
    Agreement getAgreementById(Long id);
    Agreement createAgreement(Agreement agreement);

}

package service;

import entity.Agreement;

import java.util.List;

public interface AgreementService {
    List<Agreement> getAllAgreements();
    Agreement getAgreementById(Long id);
    Agreement createAgreement(Agreement agreement);

}

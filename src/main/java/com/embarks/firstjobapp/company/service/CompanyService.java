package com.embarks.firstjobapp.company.service;

import com.embarks.firstjobapp.company.model.Company;
import java.util.List;

public interface CompanyService {
    void createCompany(Company company);
    List<Company> getAllCompanies();
    Company updateCompanyById(Long id, Company updatedCompany);
    void deleteCompanyById(Long id);
    Company getCompanyById(Long id);
}

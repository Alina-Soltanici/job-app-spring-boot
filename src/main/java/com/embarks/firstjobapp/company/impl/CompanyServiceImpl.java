package com.embarks.firstjobapp.company.impl;

import com.embarks.firstjobapp.company.model.Company;
import com.embarks.firstjobapp.company.repository.CompanyRepository;
import com.embarks.firstjobapp.company.service.CompanyService;
import com.embarks.firstjobapp.exception.ResourceNotFoundException;
import com.embarks.firstjobapp.job.model.Job;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    @Override
    public void createCompany(Company company) {
        companyRepository.save (company);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll ();
    }

    @Override
    public Company updateCompanyById(Long id, Company updateCompany) {
        Company existingCompany = companyRepository.findById (id)
                .orElseThrow (() -> new ResourceNotFoundException ("Company", id));

        if(updateCompany.getName () != null) {
            existingCompany.setName (updateCompany.getName ());
        }

        if(updateCompany.getDescription () != null) {
            existingCompany.setDescription (updateCompany.getDescription ());
        }

        if(updateCompany.getJobs () != null) {
            existingCompany.setJobs (updateCompany.getJobs ());
        }

        return companyRepository.save(existingCompany);
    }

    @Override
    public void deleteCompanyById(Long id) {
        Company existingCompany = companyRepository.findById (id)
                .orElseThrow (() -> new ResourceNotFoundException ("Company", id));
        companyRepository.delete (existingCompany);
    }

    @Override
    public Company getCompanyById(Long id) {
        Company company = companyRepository.findById (id)
                .orElseThrow(() -> new ResourceNotFoundException ("Company", id));
        return company;
    }
}

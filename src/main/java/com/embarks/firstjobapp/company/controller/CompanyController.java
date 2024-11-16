package com.embarks.firstjobapp.company.controller;

import com.embarks.firstjobapp.company.model.Company;
import com.embarks.firstjobapp.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {
        List<Company> companies = companyService.getAllCompanies ();
        return ResponseEntity.status (HttpStatus.OK).body (companies);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompanyById(@PathVariable(name = "id") Long id, @RequestBody Company company) {
        Company updatedCompany = companyService.updateCompanyById (id, company);
        return ResponseEntity.status (HttpStatus.OK).body ("Company has been updated successfully");
    }

    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Company company) {
        companyService.createCompany(company);
        return ResponseEntity.status (HttpStatus.CREATED).body ("Company has been added successfully!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable(name = "id") Long id) {
        companyService.deleteCompanyById (id);
        return ResponseEntity.status (HttpStatus.OK).body ("Company has been removed successfully! ");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable(name = "id") Long id) {
        Company company = companyService.getCompanyById (id);
        return ResponseEntity.status (HttpStatus.OK).body (company);
    }
}

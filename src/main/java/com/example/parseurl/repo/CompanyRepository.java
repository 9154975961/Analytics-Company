package com.example.parseurl.repo;

import com.example.parseurl.models.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Long> {
}

package com.tarasenko.graphqlusers.repository;

import org.springframework.data.repository.CrudRepository;

import com.tarasenko.graphqlusers.entity.Company;

public interface CompanyRepository extends CrudRepository<Company, Long>
{
}

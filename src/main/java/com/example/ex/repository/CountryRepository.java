package com.example.ex.repository;

import com.example.ex.model.Country;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {
}

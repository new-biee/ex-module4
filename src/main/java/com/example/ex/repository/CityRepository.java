package com.example.ex.repository;

import com.example.ex.model.City;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CityRepository extends PagingAndSortingRepository<City, Long> {
}

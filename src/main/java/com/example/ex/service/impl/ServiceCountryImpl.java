package com.example.ex.service.impl;

import com.example.ex.model.Country;
import com.example.ex.repository.CountryRepository;
import com.example.ex.service.ServiceCountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceCountryImpl implements ServiceCountry {

    @Autowired
    CountryRepository countryRepository;

    @Override
    public Iterable<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public void save(Country model) {
        countryRepository.save(model);
    }

    @Override
    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }
}

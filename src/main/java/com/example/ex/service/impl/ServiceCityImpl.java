package com.example.ex.service.impl;

import com.example.ex.model.City;
import com.example.ex.repository.CityRepository;
import com.example.ex.service.ServiceCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceCityImpl implements ServiceCity {

    @Autowired
    CityRepository cityRepository;

    @Override
    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> findById(Long id) {
        return cityRepository.findById(id);
    }

    @Override
    public void save(City model) {
        cityRepository.save(model);
    }

    @Override
    public void deleteById(Long id) {
        cityRepository.deleteById(id);
    }


}

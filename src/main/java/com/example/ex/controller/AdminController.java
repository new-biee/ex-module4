package com.example.ex.controller;

import com.example.ex.model.City;
import com.example.ex.model.Country;
import com.example.ex.repository.CityRepository;
import com.example.ex.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("/country/create")
    public ModelAndView showCreateFormCountry() {
        return new ModelAndView("country/create", "country", new Country());
    }

    @PostMapping("/country/create")
    public ModelAndView saveCategory(@ModelAttribute("category") @Validated Country country, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("country/create");
            return modelAndView;
        }
        countryRepository.save(country);
        ModelAndView modelAndView = new ModelAndView("country/create");
        modelAndView.addObject("country", country);
        modelAndView.addObject("message", "The Country created successfully");
        return modelAndView;
    }

    @GetMapping("/city/create")
    public ModelAndView showCreateFormProduct() {
        ModelAndView modelAndView = new ModelAndView("city/create");
        Iterable<Country> countries = countryRepository.findAll();
        modelAndView.addObject("countries", countries);
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @PostMapping("/city/create")
    public ModelAndView saveCity(@ModelAttribute("city") City city) {
        cityRepository.save(city);
        ModelAndView modelAndView = new ModelAndView("city/create");
        Iterable<Country> countries = countryRepository.findAll();
        modelAndView.addObject("countries", countries);
        modelAndView.addObject("city", city);
        modelAndView.addObject("message", "The city created successfully");
        return modelAndView;
    }

    @GetMapping("/city/list")
    public ModelAndView showListCity() {
        Iterable<City> cities = cityRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("city/list");
        modelAndView.addObject("cities", cities);
        return modelAndView;
    }

    @PostMapping("/city-delete/{id}")
    public String removeById(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        cityRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "The city delete successfully");
        return "redirect:/admin/city/list";
    }

    @GetMapping("/city-edit/{id}")
    public ModelAndView showFormEditCity(@PathVariable Long id) {
        Optional<City> city = cityRepository.findById(id);
        if (city.isPresent()) {
            Iterable<Country> countries = countryRepository.findAll();
            ModelAndView modelAndView = new ModelAndView("city/edit");
            modelAndView.addObject("city", city);
            modelAndView.addObject("countries", countries);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("city/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/city-edit")
    public ModelAndView updateCity(@ModelAttribute("city") City city) {
        cityRepository.save(city);
        Iterable<Country> countries = countryRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("city/edit");
        modelAndView.addObject("city", city);
        modelAndView.addObject("countries", countries);
        modelAndView.addObject("message", "City updated successfully");
        return modelAndView;
    }

}

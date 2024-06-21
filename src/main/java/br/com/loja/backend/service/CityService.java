package br.com.loja.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja.backend.entity.City;
import br.com.loja.backend.repository.CityRepository;

import java.util.Date;
import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> getAll() {
        return cityRepository.findAll();
    }

    public City register(City city) {
        city.setCreationdate(new Date());
        City newCity = cityRepository.saveAndFlush(city);
        return newCity;
    }

    public City update(City city) {
        city.setUpdatedate(new Date());
        return cityRepository.saveAndFlush(city);
    }

    public void delete(Long id) {
        City city = cityRepository.findById(id).get();
        cityRepository.delete(city);
    }

}

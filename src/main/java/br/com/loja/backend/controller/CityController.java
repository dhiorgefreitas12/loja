package br.com.loja.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja.backend.entity.City;
import br.com.loja.backend.service.CityService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/")
    public List<City> getAll() {
        return cityService.getAll();
    }

    @PostMapping("/")
    public City register(@RequestBody City city) {
        return cityService.register(city);

    }

    @PutMapping("/")
    public City update(@RequestBody City city) {
        return cityService.update(city);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        cityService.delete(id);
        return ResponseEntity.ok().build();
    }

}

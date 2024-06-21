package br.com.loja.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja.backend.entity.Brand;
import br.com.loja.backend.repository.BrandRepository;

import java.util.Date;
import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    public Brand register(Brand brand) {
        brand.setCreationdate(new Date());
        Brand newBrand = brandRepository.saveAndFlush(brand);
        return newBrand;
    }

    public Brand update(Brand brand) {
        brand.setUpdatedate(new Date());
        return brandRepository.saveAndFlush(brand);
    }

    public void delete(Long id) {
        Brand brand = brandRepository.findById(id).get();
        brandRepository.delete(brand);
    }

}

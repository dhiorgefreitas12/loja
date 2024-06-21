package br.com.loja.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.loja.backend.entity.Product;
import br.com.loja.backend.repository.ProductRepository;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product register(Product product) {
        product.setCreationdate(new Date());
        Product newProduct = productRepository.saveAndFlush(product);
        return newProduct;
    }

    public Product update(Product product) {
        product.setUpdatedate(new Date());
        return productRepository.saveAndFlush(product);
    }

    public void delete(Long id) {
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
    }

}

package br.com.loja.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.loja.backend.entity.Image;
import br.com.loja.backend.entity.Product;
import br.com.loja.backend.repository.ImageRepository;
import br.com.loja.backend.repository.ProductRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<Image> getAll() {
        return imageRepository.findAll();
    }

    public Image register(Long idProduct, MultipartFile file) {
        Product product = productRepository.findById(idProduct).get();
        Image newimage = new Image();
        try {
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                String imageName = String.valueOf(product.getId())
                        + file.getOriginalFilename();
                Path path = Paths.get("/home/dhiorgefreitas/Imagens/image" + imageName);
                Files.write(path, bytes);
                newimage.setName(imageName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        newimage.setProduct(product);
        newimage.setCreationdate(new Date());
        newimage = imageRepository.saveAndFlush(newimage);
        return newimage;
    }

    public Image update(Image image) {
        image.setUpdatedate(new Date());
        return imageRepository.saveAndFlush(image);
    }

    public void delete(Long id) {
        Image image = imageRepository.findById(id).get();
        imageRepository.delete(image);
    }

}

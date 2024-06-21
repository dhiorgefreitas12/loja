package br.com.loja.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.loja.backend.entity.Image;
import br.com.loja.backend.service.ImageService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/")
    public List<Image> getAll() {
        return imageService.getAll();
    }

    @PostMapping("/")
    public Image register(@RequestParam("idProduct") Long idProduct, @RequestParam("file") MultipartFile file) {
        return imageService.register(idProduct, file);

    }

    @PutMapping("/")
    public Image update(@RequestBody Image image) {
        return imageService.update(image);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        imageService.delete(id);
        return ResponseEntity.ok().build();
    }

}

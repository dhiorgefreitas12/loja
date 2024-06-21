package br.com.loja.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import java.util.Date;

@Entity
@Data
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String shortDescription;
    private String detailedDescription;
    private String imageName;
    private double valueCusto;
    private double valueVenda;

    @ManyToOne
    @JoinColumn(name = "idBrand")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "idCategory")
    private Category category;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedate;
}

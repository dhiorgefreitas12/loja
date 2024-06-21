package br.com.loja.backend.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.Date;

import java.util.List;

@Entity
@Data
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String cpf;
    private String email;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateShippingCode;
    private String passwordRecoveryCode;
    private String password;
    private String andress;
    private String cep;

    @ManyToOne
    @JoinColumn(name = "idCity")
    private City city;

    @OneToMany(mappedBy = "person", orphanRemoval = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @Setter(value = AccessLevel.NONE)
    private List<PermissionPerson> permissionPerson;

    @ManyToOne
    @JoinColumn(name = "idState")
    private State state;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedate;

    public void setPermissionPessoa(List<PermissionPerson> pp) {
        for (PermissionPerson p : pp) {
            p.setPerson(this);
        }
        this.permissionPerson = pp;
    }

}

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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@Table(name = "permissionPerson")
public class PermissionPerson {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "idPerson")
  @JsonIgnore
  private Person person;

  @ManyToOne
  @JoinColumn(name = "idPermission")
  private Permission permission;

  @Temporal(TemporalType.TIMESTAMP)
  private Date creationdate;

  @Temporal(TemporalType.TIMESTAMP)
  private Date updatedate;

}

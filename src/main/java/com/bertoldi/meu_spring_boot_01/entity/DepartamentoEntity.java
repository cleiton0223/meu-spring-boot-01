package com.bertoldi.meu_spring_boot_01.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "departamento")
public class DepartamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departamento")
    private int idDepartamento;

    @Column(name = "nm_departamento")
    private String nmDepartamento;

    public String getNomeDepartamento() {
        return nmDepartamento;
    }
}

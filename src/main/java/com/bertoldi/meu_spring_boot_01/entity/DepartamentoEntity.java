package com.bertoldi.meu_spring_boot_01.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "departamento")
public class DepartamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departamento")
    private int idDepartamento;

   @Column(name = "nm_departamento")
    private String nmDepartamento;

    public DepartamentoEntity(int id_departamento, String nm_departamento) {
        this.idDepartamento = id_departamento;
        this.nmDepartamento = nm_departamento;
    }

    public DepartamentoEntity() {

    }

    public int getId_departamento() {
        return idDepartamento;
    }

    public void setId_departamento(int id_departamento) {
        this.idDepartamento = id_departamento;
    }

    public String getNm_departamento() {
        return nmDepartamento;
    }

    public void setNm_departamento(String nm_departamento) {
        this.nmDepartamento = nm_departamento;
    }
}

package com.bertoldi.meu_spring_boot_01.entity;

import javax.lang.model.element.NestingKind;

public class Departamentoentity {

    private int idDepartamento;
    private String nmDepartamento;

    public Departamentoentity(int id_departamento, String nm_departamento) {
        this.idDepartamento = id_departamento;
        this.nmDepartamento = nm_departamento;
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

package com.bertoldi.meu_spring_boot_01.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class DepartamentoDto {



    private int idDepartamento;

    @NotBlank(message = "Nome do departamento não pode ser vazio")
    @Size(max = 50, message = "Departamento não pode ultrapassar 50 caracteres")
    private String nmDepartamento;

    public DepartamentoDto(int idDepartamento, String nmDepartamento) {
        this.idDepartamento = idDepartamento;
        this.nmDepartamento = nmDepartamento;
    }
    public DepartamentoDto() {

    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNmDepartamento() {
        return nmDepartamento;
    }

    public void setNmDepartamento(String nmDepartamento) {
        this.nmDepartamento = nmDepartamento;
    }

    @Override
    public String toString() {
        return "DepartamentoDto{" +
                "idDepartamento=" + idDepartamento +
                ", nmDepartamento='" + nmDepartamento + '\'' +
                '}';
    }
}

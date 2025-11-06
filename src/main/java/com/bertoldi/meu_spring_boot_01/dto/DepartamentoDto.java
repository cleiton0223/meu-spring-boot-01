package com.bertoldi.meu_spring_boot_01.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor


public class DepartamentoDto {



    private int idDepartamento;

    @NotBlank(message = "Nome do departamento não pode ser vazio")
    @Size(max = 50, message = "Departamento não pode ultrapassar 50 caracteres")
    private String nmDepartamento;


}

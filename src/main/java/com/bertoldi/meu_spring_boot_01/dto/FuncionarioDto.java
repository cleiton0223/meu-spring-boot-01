package com.bertoldi.meu_spring_boot_01.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.lang.annotation.Target;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class FuncionarioDto {

    private int idFuncionario;


    @NotBlank(message = "Nome do funcionário não pode ser vazio")
    @Size(max = 100, message = "Nome do funcionário não pode ultrapassar 100 caracteres")
    private String nome;

    @NotBlank(message = "Email do funcionário não pode ser vazio")
    @Size(max = 50, message = "Email do funcionário não pode ultrapassar 50 caracteres")
    @Email(message = "Email do funcionário inválido")
    private String email;

    @NotBlank(message = "Senha do funcionário não pode ser vazia")
    @Size(max = 50, message = "Senha do funcionário não pode ultrapassar 50 caracteres")
    private String senha;

    @Digits(integer = 10, fraction = 2, message = "Salário do funcionário inválido")
    @PositiveOrZero(message = "Salário do funcionário não pode ser negativo")
    private double salario;

    private int departamento;


}
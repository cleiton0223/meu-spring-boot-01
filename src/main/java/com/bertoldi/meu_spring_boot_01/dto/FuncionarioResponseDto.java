package com.bertoldi.meu_spring_boot_01.dto;


import com.bertoldi.meu_spring_boot_01.entity.FuncionarioEntity;
import jakarta.validation.constraints.*;
import lombok.*;

import javax.lang.model.element.NestingKind;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class FuncionarioResponseDto {

    private int idFuncionario;


   private  String nome;

   private String email;

   private String senha;

   private double salario;

   private String nomeDepartamento;

}



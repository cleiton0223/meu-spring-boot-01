package com.bertoldi.meu_spring_boot_01.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "funcionario")
public class FuncionarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcionario")
    private int idFuncionario;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "salario")
    private double salario;

    @ManyToOne
    @JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento")
    private DepartamentoEntity departamento;

}
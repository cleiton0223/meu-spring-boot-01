package com.bertoldi.meu_spring_boot_01.repo;

import com.bertoldi.meu_spring_boot_01.entity.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionarioRepository   extends JpaRepository<FuncionarioEntity,Integer> {

 boolean existsByEmail (String Email);

boolean existsByEmailAndIdFuncionarioNot(String email,int id);

boolean existsByDepartamentoIdDepartamento(int idDepartamento);
}

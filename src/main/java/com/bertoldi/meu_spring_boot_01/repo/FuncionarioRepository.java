package com.bertoldi.meu_spring_boot_01.repo;

import com.bertoldi.meu_spring_boot_01.entity.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository   extends JpaRepository<FuncionarioEntity,Integer> {
}

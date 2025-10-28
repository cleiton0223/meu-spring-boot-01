package com.bertoldi.meu_spring_boot_01.repo;

import com.bertoldi.meu_spring_boot_01.entity.DepartamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository <DepartamentoEntity,Integer> {

}

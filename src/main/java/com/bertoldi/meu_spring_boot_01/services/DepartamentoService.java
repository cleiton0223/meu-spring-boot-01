package com.bertoldi.meu_spring_boot_01.services;

import com.bertoldi.meu_spring_boot_01.dto.DepartamentoDto;
import com.bertoldi.meu_spring_boot_01.entity.DepartamentoEntity;
import com.bertoldi.meu_spring_boot_01.repo.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepo;

    // CRUD

    // Create
    public void cadastrarDepartamento(DepartamentoDto departamentoDto) {
        // Convertendo Dto para Entity
        DepartamentoEntity departamentoEntity = new DepartamentoEntity();

        departamentoEntity.setNm_departamento(departamentoDto.getNmDepartamento());

        departamentoRepo.save(departamentoEntity);
    }

    // Read

    // Update

    // Delete
}

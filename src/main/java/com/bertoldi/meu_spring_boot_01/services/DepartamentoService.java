package com.bertoldi.meu_spring_boot_01.services;

import com.bertoldi.meu_spring_boot_01.dto.DepartamentoDto;
import com.bertoldi.meu_spring_boot_01.entity.DepartamentoEntity;
import com.bertoldi.meu_spring_boot_01.repo.DepartamentoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


import java.util.ArrayList;
import java.util.List;

@Service
@Validated
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepo;

    // CRUD

    // Create
    public void cadastrarDepartamento(@Valid DepartamentoDto departamentoDto) {
        // Convertendo Dto para Entity
        DepartamentoEntity departamentoEntity = new DepartamentoEntity();

        departamentoEntity.setNm_departamento(departamentoDto.getNmDepartamento());

        departamentoRepo.save(departamentoEntity);
    }

    // Read
    public List<DepartamentoDto> listarDepartamentos() {

        List<DepartamentoEntity> listaDepartamentoEntity = departamentoRepo.findAll();

        List<DepartamentoDto> listaDepartamentoDto = new ArrayList<>();

        for (DepartamentoEntity d : listaDepartamentoEntity) {

            DepartamentoDto departamentoDto = new DepartamentoDto();
            departamentoDto.setIdDepartamento(d.getId_departamento());
            departamentoDto.setNmDepartamento((d.getNm_departamento()));

            listaDepartamentoDto.add(departamentoDto);
        }
        return listaDepartamentoDto;

    }
    // Update
    public void atualizarDepartamento(int id,@Valid DepartamentoDto departamentoDto) {


        DepartamentoEntity departamentoEntity = new DepartamentoEntity();

        departamentoEntity.setId_departamento(id);
        departamentoEntity.setNm_departamento(departamentoDto.getNmDepartamento());

        departamentoRepo.save(departamentoEntity);
    }
    // Delete

    public void deletarDepartamento(int id) {
        departamentoRepo.deleteById(id);

    }




}

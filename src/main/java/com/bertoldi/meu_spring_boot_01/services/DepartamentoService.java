package com.bertoldi.meu_spring_boot_01.services;

import com.bertoldi.meu_spring_boot_01.dto.DepartamentoDto;
import com.bertoldi.meu_spring_boot_01.entity.DepartamentoEntity;
import com.bertoldi.meu_spring_boot_01.entity.FuncionarioEntity;
import com.bertoldi.meu_spring_boot_01.repo.DepartamentoRepository;
import com.bertoldi.meu_spring_boot_01.repo.FuncionarioRepository;
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
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    // CRUD

    // Create
    public void cadastrarDepartamento(@Valid DepartamentoDto departamentoDto) {
        // Convertendo Dto para Entity
        DepartamentoEntity departamentoEntity = new DepartamentoEntity();

        departamentoEntity.setNmDepartamento(departamentoDto.getNmDepartamento());

        departamentoRepo.save(departamentoEntity);
    }

    // Read
    public List<DepartamentoDto> listarDepartamentos() {

        List<DepartamentoEntity> listaDepartamentoEntity = departamentoRepo.findAll();

        List<DepartamentoDto> listaDepartamentoDto = new ArrayList<>();

        for (DepartamentoEntity d : listaDepartamentoEntity) {

            DepartamentoDto departamentoDto = new DepartamentoDto();
            departamentoDto.setIdDepartamento(d.getIdDepartamento());
            departamentoDto.setNmDepartamento((d.getNmDepartamento()));

            listaDepartamentoDto.add(departamentoDto);
        }
        return listaDepartamentoDto;

    }
    // Update
    public void atualizarDepartamento(int id,@Valid DepartamentoDto departamentoDto) {


        //Faz a verificação se existe esse id ou não.
        DepartamentoEntity departamentoEntity =  departamentoRepo.findById(id)
        .orElseThrow(()-> new RuntimeException("Departamento não existe"));


        departamentoEntity.setNmDepartamento(departamentoDto.getNmDepartamento());

        departamentoRepo.save(departamentoEntity);
    }
    // Delete

    public void deletarDepartamento(int id) {

        DepartamentoEntity departamentoEntity =  departamentoRepo.findById(id)
       .orElseThrow(()-> new RuntimeException("Departamento não existe"));

        if(funcionarioRepository.existsByDepartamentoIdDepartamento(id)){
            throw new RuntimeException("Não pode deletar departamento com funcionários");
        }

        departamentoRepo.deleteById(id);

    }
}

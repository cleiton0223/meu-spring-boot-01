package com.bertoldi.meu_spring_boot_01.services;

import com.bertoldi.meu_spring_boot_01.dto.DepartamentoDto;
import com.bertoldi.meu_spring_boot_01.entity.Departamentoentity;
import com.bertoldi.meu_spring_boot_01.repo.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    @Autowired
    private DepartamentoRepository departamentoRepo;

    //Crud





    //Create

    //Conversão de dto para entity
    public void cadastrarDepartamento(DepartamentoDto departamentoDto){
        Departamentoentity departamentoEntity = new Departamentoentity();

        departamentoEntity.setNm_departamento(departamentoDto.getNmDepartamento());

        departamentoRepo.save(departamentoEntity);
    }





    //Read



    //Update




    //Delete



}

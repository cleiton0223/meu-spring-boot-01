package com.bertoldi.meu_spring_boot_01.services;

import com.bertoldi.meu_spring_boot_01.dto.DepartamentoDto;
import com.bertoldi.meu_spring_boot_01.dto.FuncionarioDto;
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
import java.util.Optional;

@Service
@Validated
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepo;


    @Autowired
    private DepartamentoRepository departamentoRepo;
    //Create

    public void cadastrarFuncionario(FuncionarioDto funcionarioDto) {

      DepartamentoEntity departamento= departamentoRepo.
      findById(funcionarioDto.getDepartamento()).orElseThrow(() -> new RuntimeException("Departamento não existe"));

        FuncionarioEntity funcionarioEntity = new FuncionarioEntity();

        funcionarioEntity.setNome(funcionarioDto.getNome());
        funcionarioEntity.setEmail(funcionarioDto.getEmail());
        funcionarioEntity.setSenha(funcionarioDto.getSenha());
        funcionarioEntity.setSalario(funcionarioDto.getSalario());



        funcionarioRepo.save(funcionarioEntity);



    }

    //Read

    public List<FuncionarioDto> listarFuncionario() {

        List<FuncionarioEntity> funcionarioEntityList = funcionarioRepo.findAll();

        List<FuncionarioDto> funcionarioDtos = new ArrayList<>();

        for(FuncionarioEntity f : funcionarioEntityList){

            FuncionarioDto funcionarioDto = new FuncionarioDto();

            funcionarioDto.setIdFuncionario(f.getIdFuncionario());
            funcionarioDto.setNome(f.getNome());
            funcionarioDto.setEmail(f.getEmail());
            funcionarioDto.setSalario(f.getSalario());
            funcionarioDto.setSenha(f.getSenha());
            funcionarioDto.setDepartamento(f.getDepartamento().getId_departamento());
            funcionarioDtos.add(funcionarioDto);
        }
        return funcionarioDtos;

    }
    //Update

    public void atualizarFuncionario(int id, FuncionarioDto funcionarioDto) {

        Optional<DepartamentoEntity> departamento = departamentoRepo.findById(funcionarioDto.getDepartamento());

        FuncionarioEntity funcionarioEntity = new FuncionarioEntity();



        funcionarioEntity.setIdFuncionario(id);
        funcionarioEntity.setNome(funcionarioDto.getNome());
        funcionarioEntity.setEmail(funcionarioDto.getEmail());
        funcionarioEntity.setSalario(funcionarioDto.getSalario());
        funcionarioEntity.setSenha(funcionarioDto.getSenha());
        funcionarioEntity.setDepartamento(departamento.get());


        funcionarioRepo.save(funcionarioEntity);
    }
    //delete
    public void deletarFuncionario(int id) {
        funcionarioRepo.deleteById(id);

    }



}

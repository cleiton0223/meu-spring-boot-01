package com.bertoldi.meu_spring_boot_01.services;

import com.bertoldi.meu_spring_boot_01.dto.DepartamentoDto;
import com.bertoldi.meu_spring_boot_01.dto.FuncionarioDto;
import com.bertoldi.meu_spring_boot_01.dto.FuncionarioResponseDto;
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
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepo;

    @Autowired
    private DepartamentoRepository departamentoRepo;

    // Create
    public void cadastrarFuncionario(@Valid FuncionarioDto funcionarioDto) {

        if (funcionarioRepo.existsByEmail(funcionarioDto.getEmail())) {
            throw new RuntimeException("Email já cadastrado");
        }

        DepartamentoEntity departamento = departamentoRepo
                .findById(funcionarioDto.getDepartamento())
                .orElseThrow(() -> new RuntimeException("Departamento não encontrado"));

        FuncionarioEntity funcionarioEntity = new FuncionarioEntity();

        funcionarioEntity.setNome(funcionarioDto.getNome());
        funcionarioEntity.setEmail(funcionarioDto.getEmail());
        funcionarioEntity.setSenha(funcionarioDto.getSenha());
        funcionarioEntity.setSalario(funcionarioDto.getSalario());
        funcionarioEntity.setDepartamento(departamento);

        funcionarioRepo.save(funcionarioEntity);
    }

    // Read
    public List<FuncionarioResponseDto> listarFuncionario() {

        List<FuncionarioEntity> listarFuncionarioEntity = funcionarioRepo.findAll();
        List<FuncionarioResponseDto> funcionarioResponseDtos = new ArrayList<>();

        for (FuncionarioEntity f : listarFuncionarioEntity) {
            FuncionarioResponseDto funcionarioDto = new FuncionarioResponseDto();

            funcionarioDto.setIdFuncionario(f.getIdFuncionario());
            funcionarioDto.setNome(f.getNome());
            funcionarioDto.setEmail(f.getEmail());
            funcionarioDto.setSalario(f.getSalario());
            funcionarioDto.setSenha(f.getSenha());


            funcionarioDto.setNomeDepartamento(f.getDepartamento().getNomeDepartamento());

            funcionarioResponseDtos.add(funcionarioDto);
        }

        return funcionarioResponseDtos;
    }

    // Update
    public void atualizarFuncionario(int id, @Valid FuncionarioDto funcionarioDto) {

        FuncionarioEntity funcionarioEntity = funcionarioRepo
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        if (funcionarioRepo.existsByEmailAndIdFuncionarioNot(funcionarioDto.getEmail(), id)) {
            throw new RuntimeException("Email já cadastrado");
        }

        DepartamentoEntity departamento = departamentoRepo
                .findById(funcionarioDto.getDepartamento())
                .orElseThrow(() -> new RuntimeException("Departamento não encontrado"));

        funcionarioEntity.setNome(funcionarioDto.getNome());
        funcionarioEntity.setEmail(funcionarioDto.getEmail());
        funcionarioEntity.setSalario(funcionarioDto.getSalario());
        funcionarioEntity.setSenha(funcionarioDto.getSenha());
        funcionarioEntity.setDepartamento(departamento);

        funcionarioRepo.save(funcionarioEntity);
    }

    // Delete
    public void deletarFuncionario(int idRemover) {
        funcionarioRepo.findById(idRemover)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        funcionarioRepo.deleteById(idRemover);
    }
}

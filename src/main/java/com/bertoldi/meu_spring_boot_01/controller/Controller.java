package com.bertoldi.meu_spring_boot_01.controller;

import com.bertoldi.meu_spring_boot_01.dto.DepartamentoDto;
import com.bertoldi.meu_spring_boot_01.dto.FuncionarioDto;
import com.bertoldi.meu_spring_boot_01.services.DepartamentoService;
import com.bertoldi.meu_spring_boot_01.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Controller  implements CommandLineRunner {

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private FuncionarioService funcionarioService;

    @Override
    public void run(String... args) throws Exception {

        FuncionarioDto funcionarioDto = new FuncionarioDto();

        funcionarioDto.setNome("Maria");
        funcionarioDto.setEmail("mariapaula@gmail.com");
        funcionarioDto.setSenha("123456");
        funcionarioDto.setDepartamento(3);
        funcionarioDto.setSalario(5000);

        funcionarioService.atualizarFuncionario(2,funcionarioDto);

    }
}

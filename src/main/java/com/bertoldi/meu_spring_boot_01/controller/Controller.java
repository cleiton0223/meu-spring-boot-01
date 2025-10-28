package com.bertoldi.meu_spring_boot_01.controller;

import com.bertoldi.meu_spring_boot_01.dto.DepartamentoDto;
import com.bertoldi.meu_spring_boot_01.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Controller  implements CommandLineRunner {

    @Autowired
    private DepartamentoService departamentoService;

    @Override
    public void run(String... args) throws Exception {

        DepartamentoDto departamentoDto = new DepartamentoDto();

        departamentoDto.setNmDepartamento("Comercial");

        departamentoService.cadastrarDepartamento(departamentoDto);


    }
}

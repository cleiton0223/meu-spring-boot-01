package com.bertoldi.meu_spring_boot_01.controller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Controller  implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {


        System.out.println("Oi");


    }
}

package com.mkyong;

import javax.smartcardio.ResponseAPDU;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;
import antlr.collections.List;

@SpringBootApplication
public class StartApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(StartApplication.class);

    @Autowired
    private CentroRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

    @Override
    public void run(String... args) {

        log.info("StartApplication...");

        // no segundo run, podemos comentar estas 3 linhas
        repository.save(new Centro("Centro de Reguengos de Monsaraz", "Reguengos de Monsaraz"));
        repository.save(new Centro("Centro de Monsaraz", "Monsaraz"));
        repository.save(new Centro("Centro de Évora", "Évora"));

        List<Centro> queryList = repository.findByRegiaoContainingIgnoreCase("Monsaraz");
        System.out.println("Tamanho da lista: " + queryList.size() + "\nList: " + queryList.toString());

    }

}
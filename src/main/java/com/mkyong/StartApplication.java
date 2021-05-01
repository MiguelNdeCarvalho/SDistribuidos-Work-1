package com.mkyong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class StartApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(StartApplication.class);

    @Autowired
    private CentroRepository centroRepository;
    @Autowired
    private InscricaoRepository inscricaoRepository;
    @Autowired
    private VacinadoRepository vacinadoRepository;

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

    @Override
    public void run(String... args) {

        log.info("StartApplication...");

        centroRepository.save(new Centro("Centro de Reguengos de Monsaraz", "Reguengos de Monsaraz"));
        centroRepository.save(new Centro("Centro de Monsaraz", "Monsaraz"));
        centroRepository.save(new Centro("Centro de Évora", "Évora"));

        //List<Centro> queryList = centroRepository.findByRegiaoContainingIgnoreCase("Monsaraz");
        //System.out.println("Tamanho da lista: " + queryList.size() + "\nList: " + queryList.toString());

        Centro centroEvora = centroRepository.findOneByNomeContainingIgnoreCase("Évora");
        inscricaoRepository.save(new Inscricao(centroEvora, "C101", "Miguel Carvalho", "Masculino", (long) 20));
        
        Inscricao miguelInscricao = inscricaoRepository.findOneByNomeContainingIgnoreCase("Miguel Carvalho");
        
        LocalDateTime date = LocalDateTime.now();

        vacinadoRepository.save(new Vacinado(miguelInscricao.getCodigo(), miguelInscricao.getNome(), miguelInscricao.getGenero(), miguelInscricao.getIdade(), date, "teste"));
        
        inscricaoRepository.deleteById(miguelInscricao.getId());
    }

}
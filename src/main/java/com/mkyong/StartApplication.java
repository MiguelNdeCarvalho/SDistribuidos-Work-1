package com.mkyong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;

@SpringBootApplication
public class StartApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(StartApplication.class);

    @Autowired
    private CentroRepository centroRepository;
    @Autowired
    private InscricaoRepository inscricaoRepository;

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

    @Override
    public void run(String... args) {

        log.info("StartApplication...");

        //centroRepository.save(new Centro("Centro de Reguengos de Monsaraz", "Reguengos de Monsaraz"));
        //centroRepository.save(new Centro("Centro de Monsaraz", "Monsaraz"));
        //centroRepository.save(new Centro("Centro de Évora", "Évora"));

        //List<Centro> queryList = centroRepository.findByRegiaoContainingIgnoreCase("Monsaraz");
        //System.out.println("Tamanho da lista: " + queryList.size() + "\nList: " + queryList.toString());

        //Centro tempCentro = centroRepository.findOneByNomeContainingIgnoreCase("Évora");
        //inscricaoReposccccccccitory.save(new Inscricao(tempCentro, "C101", "Miguel Carvalho", "Masculino", (long) 20));
        //System.out.println(tempCentro.toString());
    }

}
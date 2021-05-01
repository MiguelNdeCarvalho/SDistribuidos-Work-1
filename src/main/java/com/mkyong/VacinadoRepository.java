package com.mkyong;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VacinadoRepository extends CrudRepository<Vacinado, Long> {

    List<Vacinado> findById(long id);

    Vacinado findOneByCodigoContainingIgnoreCase(String nome);
    Vacinado findOneByNomeContainingIgnoreCase(String nome);
    List<Vacinado> findByNomeContainingIgnoreCase(String nome);
    List<Vacinado> findByTipo(String tipo);
}

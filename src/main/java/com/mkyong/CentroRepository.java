package com.mkyong;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CentroRepository extends CrudRepository<Centro, Long> {

    List<Centro> findById(long id);
    Centro findOneByNomeContainingIgnoreCase(String nome);
    List<Centro> findByNomeContainingIgnoreCase(String nome);
    Centro findOneByRegiaoContainingIgnoreCase(String regiao);
    List<Centro> findByRegiaoContainingIgnoreCase(String regiao);
}

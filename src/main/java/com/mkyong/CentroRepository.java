package com.mkyong;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CentroRepository extends CrudRepository<Centro, Long> {

    List<Centro> findById(long id);
    List<Centro> findByNomeContainingIgnoreCase(String nome);
    List<Centro> findByRegiaoContainingIgnoreCase(String regiao);
}

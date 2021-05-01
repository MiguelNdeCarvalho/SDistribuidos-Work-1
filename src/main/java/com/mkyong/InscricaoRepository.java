package com.mkyong;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InscricaoRepository extends CrudRepository<Inscricao, Long> {

    List<Centro> findById(long id);
    List<Centro> findByCentro(Centro centro);
    List<Centro> findByCodigo(String codigo);
    List<Centro> findByNomeContainingIgnoreCase(String nome);
    List<Centro> findByGeneroContainingIgnoreCase(String genero);
    List<Centro> findByIdade(Long idade);
}
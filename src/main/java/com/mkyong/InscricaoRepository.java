package com.mkyong;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InscricaoRepository extends CrudRepository<Inscricao, Long> {

    List<Inscricao> findById(long id);
    Inscricao findOneByNomeContainingIgnoreCase(String nome);
    List<Inscricao> findByCentro(Centro centro);
    List<Inscricao> findByCodigo(String codigo);
    List<Inscricao> findByNomeContainingIgnoreCase(String nome);
    List<Inscricao> findByGeneroContainingIgnoreCase(String genero);
    List<Inscricao> findByIdade(Long idade);
}
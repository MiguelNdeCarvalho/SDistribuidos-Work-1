package com.mkyong;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Inscricao {

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
    private String codigo, nome, genero;
    private Long idade;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="idCentro")
    private Centro centro;

    protected Inscricao() {}

    public Inscricao(Centro centro, String codigo, String nome, String genero, Long idade) {
        this.centro = centro;
        this.codigo = codigo;
        this.nome = nome;
        this.genero = genero;
        this.idade = idade;
    }

    @Override
	public String toString() {
		return String.format(
				"Centro[id=%d, idCentro=%d, codigo='%s', nome='%s'. genero='%s', idade=%d]",
				id, centro.getId(), codigo, nome, genero, idade);
	}
    
    public Long getId() {
		return id;
    }

    public Long getIdCentro(){
        return centro.getId();
    }

    public String getCodigo() {
        return codigo;
    }
    
    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public Long getIdade() {
        return idade;
    }
}

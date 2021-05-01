package com.mkyong;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.*; 

@Entity
public class Vacinado {

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
    private String codigo, nome,genero,tipo;
    private Long idade;
    private LocalDateTime data;
    
    protected Vacinado() {}

    public Vacinado(String codigo, String nome, String genero, Long idade, LocalDateTime data, String tipo) {
        this.codigo = codigo;
        this.nome = nome;
        this.genero = genero;
        this.idade = idade;
        this.data = data;
        this.tipo = tipo;
    }

    @Override
	public String toString() {
		return String.format(
				"Vacinado[id=%d, codigo='%s', nome='%s', genero='%s', idade=%d, data='%s', tipo='%s']",
				id, codigo, nome, genero, idade, data.toString(), tipo);
	}
    
    public Long getId() {
		return id;
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
    
    public LocalDateTime getData() {
        return data;
    }

    public String getTipo() {
        return tipo;
    }
}

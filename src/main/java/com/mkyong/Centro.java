package com.mkyong;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Centro {

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
    private String nome, regiao;

    @OneToMany(mappedBy = "centro", cascade = CascadeType.MERGE)
	private List<Inscricao> inscricao;
    
    protected Centro() {}

    public Centro(String nome, String regiao) {
        this.nome = nome;
        this.regiao = regiao;
    }

    @Override
	public String toString() {
		return String.format(
				"Centro[id=%d, nome='%s', região='%s']",
				id, nome, regiao);
	}
    
    public Long getId() {
		return id;
    }
    
    public String getNome() {
        return nome;
    }

    public String getRegiao() {
        return regiao;
    }
}

package Entities;

import java.util.Objects;

public class Motorista {
    private String nome;
    private String identificacao;

    public Motorista() {
		super();
	}

	public Motorista(String nome, String identificacao) {
        this.nome = nome;
        this.identificacao = identificacao;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
		this.nome = nome;
	}

    public String getIdentificacao() {
        return identificacao;
    }

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(identificacao, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Motorista other = (Motorista) obj;
		return Objects.equals(identificacao, other.identificacao) && Objects.equals(nome, other.nome);
	}	
}

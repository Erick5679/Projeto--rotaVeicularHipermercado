package Entities;

import java.util.ArrayList;
import java.util.List;

public class Frota {
	private List<Veiculo> veiculos;
	private List<Motorista> motoristas;
	private List<Deslocamento> deslocamentos;

	public Frota() {
		this.veiculos = new ArrayList<>();
		this.motoristas = new ArrayList<>();
		this.deslocamentos = new ArrayList<>();
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public List<Motorista> getMotoristas() {
		return motoristas;
	}

	public List<Deslocamento> getDeslocamentos() {
		return deslocamentos;
	}

	public void adicionarVeiculoFrota(Veiculo veiculo) {
		veiculos.add(veiculo);
	}

	public void adicionarMotorista(Motorista motorista) {
		motoristas.add(motorista);
	}

	public void registrarDeslocamento(Deslocamento deslocamento) {
		deslocamentos.add(deslocamento);
	}
}

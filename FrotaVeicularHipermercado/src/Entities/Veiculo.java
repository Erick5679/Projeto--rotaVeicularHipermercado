package Entities;

import java.util.Objects;

public class Veiculo {

	private String placa;
	private String modelo;
	private Integer odometro;
	private String estadoFisico;

	public Veiculo() {
		super();
	}

	public Veiculo(String placa, String modelo, Integer odometro, String estadoFisico) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.odometro = odometro;
		this.estadoFisico = estadoFisico;
	}

	public Veiculo(String placa, String modelo) {
		this.placa = placa;
		this.modelo = modelo;
		this.odometro = 0;
		this.estadoFisico = "Bom";
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getOdometro() {
		return odometro;
	}

	public void setOdometro(Integer odometro) {
		this.odometro = odometro;
	}

	public String getEstadoFisico() {
		return estadoFisico;
	}

	public void setEstadoFisico(String estadoFisico) {
		this.estadoFisico = estadoFisico;
	}

	@Override
	public int hashCode() {
		return Objects.hash(placa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		return Objects.equals(placa, other.placa);
	}

}
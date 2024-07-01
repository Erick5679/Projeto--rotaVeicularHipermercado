package Entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class Deslocamento {
	private Veiculo veiculo;
	private Motorista motorista;
	private Integer odometroInicio;
	private LocalDateTime dataHoraInicio;
	private String motivo;
	private String observacaoInicio;

	private int odometroFim;
	private LocalDateTime dataHoraFim;
	private String observacaoFim;

	public Deslocamento() {
		super();
	}

	public Deslocamento(Veiculo veiculo, Motorista motorista, Integer odometroInicio, LocalDateTime dataHoraInicio,
			String motivo, String observacaoInicio) {
		this.veiculo = veiculo;
		this.motorista = motorista;
		this.odometroInicio = odometroInicio;
		this.dataHoraInicio = dataHoraInicio;
		this.motivo = motivo;
		this.observacaoInicio = observacaoInicio;
	}

	public Deslocamento(Veiculo veiculo, Motorista motorista, Integer odometroInicio, LocalDateTime dataHoraInicio,
			String motivo, String observacaoInicio, Integer odometroFim, LocalDateTime dataHoraFim, String observacaoFim) {
		super();
		this.veiculo = veiculo;
		this.motorista = motorista;
		this.odometroInicio = odometroInicio;
		this.dataHoraInicio = dataHoraInicio;
		this.motivo = motivo;
		this.observacaoInicio = observacaoInicio;
		this.odometroFim = odometroFim;
		this.dataHoraFim = dataHoraFim;
		this.observacaoFim = observacaoFim;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public Integer getOdometroInicio() {
		return odometroInicio;
	}

	public void setOdometroInicio(Integer odometroInicio) {
		this.odometroInicio = odometroInicio;
	}

	public LocalDateTime getDataHoraInicio() {
		return dataHoraInicio;
	}

	public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getObservacaoInicio() {
		return observacaoInicio;
	}

	public void setObservacaoInicio(String observacaoInicio) {
		this.observacaoInicio = observacaoInicio;
	}

	public int getOdometroFim() {
		return odometroFim;
	}

	public void setOdometroFim(int odometroFim) {
		this.odometroFim = odometroFim;
	}

	public LocalDateTime getDataHoraFim() {
		return dataHoraFim;
	}

	public void setDataHoraFim(LocalDateTime dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}

	public String getObservacaoFim() {
		return observacaoFim;
	}

	public void setObservacaoFim(String observacaoFim) {
		this.observacaoFim = observacaoFim;
	}

	public void finalizarDeslocamento(Integer odometroFim, LocalDateTime dataHoraFim, String observacaoFim) {
		this.odometroFim = odometroFim;
		this.dataHoraFim = dataHoraFim;
		this.observacaoFim = observacaoFim;
		veiculo.setOdometro(odometroFim);
		if (!observacaoFim.isEmpty()) {
			veiculo.setEstadoFisico(observacaoFim);
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataHoraInicio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deslocamento other = (Deslocamento) obj;
		return Objects.equals(dataHoraInicio, other.dataHoraInicio);
	}

	@Override
	public String toString() {
		return "{" + "veiculo = " + veiculo.getPlaca() + ", motorista = " + motorista.getNome()
				+ ", odometroInicio = " + odometroInicio + ",\n" + "dataHoraInicio = " + dataHoraInicio + ", \n"+"motivo = " + motivo
				+ ", observacaoInicio = " + observacaoInicio + ", \n"  + "odometroFim = " + odometroFim
				+ ", dataHoraFim = " + dataHoraFim + ", observacaoFim = " + observacaoFim + '}' + "\n";
	}
}

package services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import Entities.Deslocamento;
import Entities.Frota;
import Entities.Motorista;
import Entities.Veiculo;

public class DeslocamentoService {
	Scanner scanner = new Scanner(System.in);

	public void iniciarDeslocamento(Frota frota, Veiculo veiculo) {

		System.out.print("Nome do motorista: ");
		String nome = scanner.nextLine().toUpperCase();
		System.out.print("Identificação do motorista: ");
		String identificacao = scanner.nextLine().toUpperCase();
		Motorista motorista = new Motorista(nome, identificacao);
		frota.adicionarMotorista(motorista);
		System.out.print("Odômetro inicial: ");
		int odometroInicio = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		System.out.print("Motivo do deslocamento: ");
		String motivo = scanner.nextLine();

		System.out.print("Observação inicial: ");
		String observacaoInicio = scanner.nextLine();

		Deslocamento deslocamento = new Deslocamento(veiculo, motorista, odometroInicio, LocalDateTime.now(), motivo,
				observacaoInicio);
		frota.registrarDeslocamento(deslocamento);

		System.out.println("\nDeslocamento iniciado.");
	}

	public void listarDeslocamentos(List<Deslocamento> deslocamentos) {
		for (Deslocamento d : deslocamentos) {
			System.out.println(d);
		}
	}

	public void finalizarDeslocamento(List<Deslocamento> deslocamentos, Veiculo veiculo) {
		System.out.print("Odômetro final: ");
		int odometroFim = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		System.out.print("Observação final: ");
		String observacaoFim = scanner.nextLine();

		boolean deslocamentoFinalizado = false;

		for (Deslocamento deslocamento : deslocamentos) {
			if (deslocamento.getVeiculo().equals(veiculo) && deslocamento.getDataHoraFim() == null) {
				deslocamento.finalizarDeslocamento(odometroFim, LocalDateTime.now(), observacaoFim);
				System.out.println("\nDeslocamento finalizado.");
				deslocamentoFinalizado = true;
				break;
			}
		}

		if (!deslocamentoFinalizado) {
			System.out.println("Deslocamento não encontrado ou já finalizado.");
		}
	}
}

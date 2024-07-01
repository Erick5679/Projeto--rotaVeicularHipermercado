package services;

import java.util.List;
import java.util.Scanner;

import Entities.Frota;
import Entities.Motorista;

public class MotoristaService {
	private Scanner scanner;

	public void adicionarMotorista(Frota frota, Scanner scanner) {
		System.out.print("Nome do motorista: ");
		String nome = scanner.nextLine().toUpperCase();
		System.out.print("Identificação do motorista: ");
		String identificacao = scanner.nextLine().toUpperCase();
		Motorista motorista = new Motorista(nome, identificacao);
		frota.adicionarMotorista(motorista);
		System.out.println("Motorista adicionado com sucesso.\n");
	}

	public void listarMotoristas(List<Motorista> motoristas) {
		for (Motorista m : motoristas) {
			System.out.println("Nome: " + m.getNome() + ", Identificação: " + m.getIdentificacao());
		}
	}

	public Motorista buscarMotorista(List<Motorista> motoristas, String identificacao) {
		for (Motorista m : motoristas) {
			if (m.getIdentificacao().equals(identificacao)) {
				return m;
			}
		}
		return null;
	}

	public void removerMotorista(List<Motorista> motoristas) {
		System.out.print("Identificação do motorista: ");
		scanner = new Scanner(System.in);
		String identificacao = scanner.nextLine().toUpperCase();
		Motorista motorista = buscarMotorista(motoristas, identificacao);
		if (motorista == null) {
			System.out.println("Nenhum Motorista Encontrado!");
		}else if (motorista != null) {
			motoristas.remove(motorista);
			System.out.println("Motorista removido com sucesso!");
		}
	}
}

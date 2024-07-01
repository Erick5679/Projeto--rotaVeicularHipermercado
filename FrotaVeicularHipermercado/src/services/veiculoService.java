package services;

import java.util.List;
import java.util.Scanner;

import Entities.Frota;
import Entities.Veiculo;

public class veiculoService {

	public void listarVeiculos(List<Veiculo> veiculos) {
		for (Veiculo v : veiculos) {
			System.out.println("Placa: " + v.getPlaca() + "\n" + "Modelo: " + v.getModelo() + "\n" + "Odômetro: "
					+ v.getOdometro() + "\n" + "Estado Físico: " + v.getEstadoFisico() + "\n");
		}
	}

	public void adicionarVeiculo(Frota frota, Scanner scanner) {
		System.out.print("Placa do veículo: ");
		String placa = scanner.nextLine().toUpperCase();
		System.out.print("Modelo do veículo: ");
		String modelo = scanner.nextLine().toUpperCase();
		Veiculo veiculo = new Veiculo(placa, modelo);
		frota.adicionarVeiculoFrota(veiculo);
		System.out.println("Veículo adicionado com sucesso.\n");
	}

	public Veiculo buscarVeiculo(List<Veiculo> veiculos, String placa) {
		for (Veiculo v : veiculos) {
			if (v.getPlaca().equals(placa)) {
				return v;
			}
		}
		return null;
	}

	public void removerVeiculo(List<Veiculo> veiculos, String placa) {
		Veiculo veiculo = buscarVeiculo(veiculos, placa);
		veiculos.remove(veiculo);
	}
}

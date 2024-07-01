package Resources;

import java.time.LocalDateTime;
import java.util.Scanner;

import Entities.Deslocamento;
import Entities.Frota;
import Entities.Motorista;
import Entities.Veiculo;
import services.DeslocamentoService;
import services.MotoristaService;
import services.veiculoService;

public class MainResources {
	Scanner scanner = new Scanner(System.in);
	Frota frota = new Frota();
	static veiculoService veiculoService = new veiculoService();

	static MotoristaService motoristaService = new MotoristaService();

	static DeslocamentoService deslocamentoService = new DeslocamentoService();

	public void executarMenu() {
		// Adicionando veículos e motoristas para teste
		frota.adicionarVeiculoFrota(new Veiculo("ABC-1234", "Caminhão"));
		frota.adicionarVeiculoFrota(new Veiculo("XYZ-5678", "Van"));
		frota.adicionarMotorista(new Motorista("João", "M1"));
		frota.adicionarMotorista(new Motorista("Maria", "M2"));
		veiculoService.listarVeiculos(frota.getVeiculos());
		while (true) {
			System.out.println("--------------------------------------------------------");
			System.out.println("1. Listar Veículos: \t\t6. Adicionar Motorista:");
			System.out.println("2. Iniciar Deslocamento: \t7. Listar Motoristas:");
			System.out.println("3. Finalizar Deslocamento: \t8. Remover Motorista:");
			System.out.println("4. Listar Deslocamentos: \t9. Remover Veiculo:");
			System.out.println("5. Adicionar Veículo: \t\t10. Sair:");
			System.out.println("\n--------------------------------------------------------");
			int opcao = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			if (opcao == 1) {
				if (!frota.getVeiculos().isEmpty()) {
					veiculoService.listarVeiculos(frota.getVeiculos());
				} else {
					System.out.println("Nenhum Veiculo Encontrado!");
				}
			} else if (opcao == 2) {
				System.out.print("Placa do veículo: ");
				String placa = scanner.nextLine().toUpperCase();
				Veiculo veiculo = veiculoService.buscarVeiculo(frota.getVeiculos(), placa);

				if (veiculo == null) {
					System.out.println("Veículo não encontrado.");
					continue;
				}
				deslocamentoService.iniciarDeslocamento(frota, veiculo);	

			} else if (opcao == 3) {
				System.out.print("Placa do veículo: ");
				String placa = scanner.nextLine().toUpperCase();
				Veiculo veiculo = veiculoService.buscarVeiculo(frota.getVeiculos(), placa);

				if (veiculo == null) {
					System.out.println("Veículo não encontrado.");
					continue;
				}

				DeslocamentoService deslocamentoService = new DeslocamentoService();
				deslocamentoService.finalizarDeslocamento(frota.getDeslocamentos(), veiculo);

			} else if (opcao == 4) {
				if (!frota.getDeslocamentos().isEmpty()) {
					System.out.println("Deslocamentos:\n");
					deslocamentoService.listarDeslocamentos(frota.getDeslocamentos());
				} else {
					System.out.println("Nenhum Deslocamento encontrado!");
				}
			} else if (opcao == 5) {

				veiculoService.adicionarVeiculo(frota, scanner);

			} else if (opcao == 6) {
				motoristaService.adicionarMotorista(frota, scanner);

			} else if (opcao == 7) {
				if (!frota.getMotoristas().isEmpty()) {
					motoristaService.listarMotoristas(frota.getMotoristas());
				} else {
					System.out.println("Nenhum Motorista Cadastrado!");
				}

			} else if (opcao == 8) {
				if (!frota.getMotoristas().isEmpty()) {
					motoristaService.removerMotorista(frota.getMotoristas());
				}

			} else if (opcao == 9) {
				if (!frota.getVeiculos().isEmpty()) {
					System.out.print("Placa do veiculo: ");
					String placa = scanner.nextLine().toUpperCase();
					veiculoService.removerVeiculo(frota.getVeiculos(), placa);
					System.out.println("Veiculo removido com sucesso!");
				} else {
					System.out.println("Nenhum Veiculo Encontrado!");
				}
			} else if (opcao == 10) {
				break;

			} else {
				System.out.println("Opção inválida.");
			}
		}
		scanner.close();
	}
}

package executor;

import Resources.MainResources;
import services.veiculoService;

public class Main {
	public static void main(String[] args) {
		MainResources mainResources = new MainResources();

		mainResources.executarMenu();
	}

	static veiculoService veiculoService = new veiculoService();
}

import java.util.Random;
import java.util.concurrent.*;

public class SimuladorBanco {
	private static final int DURACAO_SIMULACAO_MS = 300_000;
	private static final int N_ATENDENTES = 8;

	public static void main(String[] args) throws InterruptedException {
	System.out.println("SIMULAÇÃO DO BANCO FIRMEZA INVESTIMENTOS");
		System.out.println("========================================");
		System.out.println("Simulando " + N_ATENDENTES + " atendentes por " + (DURACAO_SIMULACAO_MS / 1000) + " segundos.");
		BlockingQueue<Cliente> fila = new LinkedBlockingQueue<>();
		Estatisticas estatisticas = new Estatisticas();
		ExecutorService pool = Executors.newFixedThreadPool(N_ATENDENTES);

		for (int i = 0; i < N_ATENDENTES; i++) {
			pool.submit(new Atendente(fila, estatisticas));
		}

		Random random = new Random();
		long inicio = System.currentTimeMillis();
		int idCliente = 1;

		while (System.currentTimeMillis() - inicio < DURACAO_SIMULACAO_MS) {
			long tempoChegada = System.currentTimeMillis();
			long tempoAtendimento = 30_000 + random.nextInt(90_000);

			Cliente cliente = new Cliente(idCliente++, tempoChegada, tempoAtendimento);
			fila.put(cliente);

			long intervaloProximaChegada = 5_000 + random.nextInt(45_000);
			Thread.sleep(intervaloProximaChegada);
		}

		pool.shutdownNow();
		pool.awaitTermination(10, TimeUnit.SECONDS);

		System.out.println("Clientes atendidos: " + estatisticas.getClientesAtendidos());
		System.out.println("Tempo máximo de espera: " + estatisticas.getTempoMaxEspera() / 1000 + "s");
		System.out.println("Tempo máximo de atendimento: " + estatisticas.getTempoMaxAtendimento() / 1000 + "s");
		System.out.println("Tempo médio no banco: " + estatisticas.getTempoMedioTotalBanco() / 1000 + "s");
		System.out.println("Tempo médio de espera: " + estatisticas.getTempoMedioEspera() / 1000 + "s");

		if (estatisticas.getTempoMedioEspera() > 120_000) {
			System.out.println("Objetivo de 2 minutos não foi atingido.");
		} else {
			System.out.println("Objetivo de 2 minutos atingido.");
		}
	}
}
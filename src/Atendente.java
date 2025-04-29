import java.util.concurrent.BlockingQueue;

public class Atendente implements Runnable {
	private final BlockingQueue<Cliente> fila;
	private final Estatisticas estatisticas;

	public Atendente(BlockingQueue<Cliente> fila, Estatisticas estatisticas) {
		this.fila = fila;
		this.estatisticas = estatisticas;
	}

	@Override
	public void run() {
		try {
			while (true) {
				Cliente cliente = fila.take();
				long agora = System.currentTimeMillis();
				long espera = agora - cliente.getTempoChegada();
				long atendimento = cliente.getTempoAtendimento();

				Thread.sleep(atendimento);
				long tempoTotal = espera + atendimento;

				estatisticas.registrarCliente(espera, atendimento, tempoTotal);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			System.out.println("Atendente interrompido.");
		} catch (Exception e) {
			System.err.println("Erro no atendente: " + e.getMessage());
		} finally {
			System.out.println("Atendente finalizado.");
		}
	}
}
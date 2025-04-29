import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Estatisticas {
	private final AtomicInteger clientesAtendidos = new AtomicInteger(0);
	private final AtomicLong tempoTotalEspera = new AtomicLong(0);
	private final AtomicLong tempoTotalBanco = new AtomicLong(0);
	private final AtomicLong tempoMaxEspera = new AtomicLong(0);
	private final AtomicLong tempoMaxAtendimento = new AtomicLong(0);

	public void registrarCliente(long espera, long atendimento, long tempoTotal) {
		clientesAtendidos.incrementAndGet();
		tempoTotalEspera.addAndGet(espera);
		tempoTotalBanco.addAndGet(tempoTotal);
		tempoMaxEspera.updateAndGet(max -> Math.max(max, espera));
		tempoMaxAtendimento.updateAndGet(max -> Math.max(max, atendimento));
	}

	public int getClientesAtendidos() { return clientesAtendidos.get(); }
	public long getTempoMedioEspera() { return tempoTotalEspera.get() / Math.max(1, clientesAtendidos.get()); }
	public long getTempoMaxEspera() { return tempoMaxEspera.get(); }
	public long getTempoMaxAtendimento() { return tempoMaxAtendimento.get(); }
	public long getTempoMedioTotalBanco() { return tempoTotalBanco.get() / Math.max(1, clientesAtendidos.get()); }
}
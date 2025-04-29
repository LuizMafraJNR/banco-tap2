public class Cliente {
	private final int id;
	private final long tempoChegada;
	private final long tempoAtendimento;

	public Cliente(int id, long tempoChegada, long tempoAtendimento) {
		this.id = id;
		this.tempoChegada = tempoChegada;
		this.tempoAtendimento = tempoAtendimento;
	}

	public int getId() { return id; }
	public long getTempoChegada() { return tempoChegada; }
	public long getTempoAtendimento() { return tempoAtendimento; }
}
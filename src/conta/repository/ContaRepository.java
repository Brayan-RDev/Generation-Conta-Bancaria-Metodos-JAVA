package conta.repository;

import conta.model.ModelConta;

public interface ContaRepository {
	//Métodos Bancarios
	public void sacar(float valor);
	public void depositar(float valor);
	public void transferir(int numeroDestino, float valor);
}

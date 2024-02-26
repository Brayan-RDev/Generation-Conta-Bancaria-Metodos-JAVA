package conta.model;

import conta.util.Cores;

public class ContaCorrente extends ModelConta{
	private float limite;
	
	public ContaCorrente(int numero, int agencia, String tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;
	}

	public ContaCorrente() {
	}

	public float getLimite() {
		return limite;
	}
	
	public void setLimite(float limite) {
		this.limite = limite;
	}
	
	@Override
	public void visualizar() {		
		System.out.println("--------Dados da Conta--------");
		System.out.println("Numero da conta: " + getNumero());
		System.out.println("Agência: " + getAgencia());
		System.out.println("Tipo da conta: " + getTipo());
		System.out.println("Titular: " + getTitular());
		System.out.println("Saldo: " + getSaldo());
		System.out.println("Limite de Crédito: " + getLimite()
						+ "\n------------------------------");
	} 

	@Override
	public void depositar(int numero, float valor) {

	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {

	}

	@Override
	public void procurarPorNumero(int numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listarTodas() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cadastrar(ModelConta conta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(ModelConta conta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(int numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}
}

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
	public void sacar(float valor) {
		if(this.getLimite() < valor) {
			System.out.println(Cores.RED + "\nVocê excedeu o limite de saque" + Cores.RESET);
		}
		else if (this.getSaldo() < valor) {
			System.out.println(Cores.RED + "\nSaldo insuficiente" + Cores.RESET);
		}
		else { 
			this.setSaldo(this.getSaldo() - valor);
			System.out.println(Cores.GREEN + "\nValor sacado: " + Cores.RESET + Cores.RED + "-" + valor + Cores.RESET);
		}
	}

	@Override
	public void depositar(float valor) {
		if(valor <= 0) {
			System.out.println(Cores.RED + "Depósito Invalido" + Cores.RESET);
		}
		else {
			this.setSaldo(this.getSaldo() + valor);
			System.out.println("\nValor do depósito:" + Cores.GREEN + "+" + valor + Cores.RESET);
		}
	}

	@Override
	public void transferir(int numeroDestino, float valor) {
		if(valor <= 0) {
			System.out.println(Cores.RED + "Transferência Invalida" + Cores.RESET);
		}
		else if (this.getSaldo() < valor) {
			System.out.println(Cores.RED + "\nSaldo insuficiente" + Cores.RESET);
		}
		else {
			this.setSaldo(this.getSaldo() - valor);
			System.out.println("\nValor Transferido: " + Cores.YELLOW + "🔄️" + valor + Cores.RESET + " Para a conta: " + numeroDestino + Cores.RESET);
		}
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
}

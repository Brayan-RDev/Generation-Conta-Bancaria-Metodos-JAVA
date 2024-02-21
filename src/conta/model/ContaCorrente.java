package conta.model;

import conta.util.Cores;

public class ContaCorrente extends ModelConta{
	private float limite;
	
	public ContaCorrente(int numero, int agencia, String tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;
	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}
	
	@Override
	public boolean sacar(float valor) {
		if(this.getLimite() < valor) {
			System.out.println(Cores.RED + "\nVocê excedeu o limite de saque" + Cores.RESET);
			return false;
		}
		else if (this.getSaldo() < valor) {
			System.out.println(Cores.RED + "\nSaldo insuficiente" + Cores.RESET);
			return false;
		}
		else { 
			this.setSaldo(this.getSaldo() - valor);
			System.out.println(Cores.GREEN + "\nValor sacado com sucesso: " + Cores.RESET + Cores.RED + "-" + valor + Cores.RESET);
			return true;
		}
	}
}

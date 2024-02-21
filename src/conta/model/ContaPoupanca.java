package conta.model;

import conta.util.Cores;

public class ContaPoupanca extends ModelConta {
	public ContaPoupanca(int numero, int agencia, String tipo, String titular, float saldo) {
		super(numero, agencia, tipo, titular, saldo);
	}
	
	@Override
	public boolean sacar(float valor) {
		if (this.getSaldo() < valor) {
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

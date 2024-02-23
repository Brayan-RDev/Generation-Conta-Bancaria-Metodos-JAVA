package conta.model;

import conta.util.Cores;

public class ContaPoupanca extends ModelConta {
	public ContaPoupanca(int numero, int agencia, String tipo, String titular, float saldo) {
		super(numero, agencia, tipo, titular, saldo);
	}

	public ContaPoupanca() {
	}

	@Override
	public void sacar(float valor) {
		if (this.getSaldo() < valor) {
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
			System.out.println("\nValor Transferido: " + Cores.YELLOW + "🔄️" + valor + Cores.RESET + "/nPara a conta de número: " + numeroDestino + Cores.RESET);
		}
	}
}

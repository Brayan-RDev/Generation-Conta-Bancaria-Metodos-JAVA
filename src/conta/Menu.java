package conta;

import conta.model.ModelConta;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ModelConta c1 = new ModelConta(1234, 0001, 1, "Brayan", 2000f);
		
		c1.visualizar();
		c1.setAgencia(456);
		
		if (c1.sacar(100)) {
			System.out.println("Saque efetuado com sucesso. O novo saldo é de: " + Cores.BLUE + c1.getSaldo());
		}
		else {
			System.out.println("O saldo é insuficiente!");
		}

		c1.depositar(1000);
		System.out.println("Depósito efetuado com sucesso.\n" + "O novo saldo é de: " + Cores.BLUE + c1.getSaldo());		
	}
		
}

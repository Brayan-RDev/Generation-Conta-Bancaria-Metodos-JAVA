package conta;

import java.util.Scanner;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int escolhaTipoConta;
		String tipoConta = "";
		do {
			System.out.println("ESCOLHA O TIPO DE CONTA QUE DESEJA ACESSAR\n"
								+ "1 - Conta Corrente\n"
								+ "2 - Conta Poupança\n");
			escolhaTipoConta = scan.nextInt();
			scan.nextLine();
			
			switch(escolhaTipoConta) {
				case 1:{
					tipoConta = "Conta Corrente";
					escolhaTipoConta = 0;
					break;
				}
				case 2:{
					tipoConta = "Conta Poupança";
					escolhaTipoConta = 0;
					break;
				}
				default:{
					System.out.println(Cores.RED + "Opção invalida!" + Cores.RESET);
					break;
				}
			}
		}while(escolhaTipoConta != 0);
		
		ContaPoupanca contaPoupanca1 = new ContaPoupanca(1234, 0001, tipoConta, "Brayan", 4000f);
		
		System.out.println("Saldo inicial: " + contaPoupanca1.getSaldo());
		contaPoupanca1.sacar(5500);
		System.out.println("Saldo pós saque: " + contaPoupanca1.getSaldo());
		
		scan.close();
	}
		
}

package conta;

import java.util.Scanner;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int escolha;
		float valor, saldo = 1000;
		
		do {
			System.out.println("------ESCOLHA UMA OPÇÃO------\n"
							 + "Saldo: " + Cores.BLUE + saldo + Cores.RESET + "\n"
							 + "1 - Sacar\n"
							 + "2 - Depositar\n"
							 + "3 - Transferir\n"
							 + "0 - Sair\n"
							 + "Entre com a opção desejada: ");
			escolha = scan.nextInt();
			scan.nextLine();
			
			switch(escolha) {
				case 0:{
					break;
				}
				case 1:{
					System.out.println("Digite o valor que deseja sacar: ");
					valor = scan.nextFloat();
					if(valor > saldo) {
						System.out.println(Cores.RED + "\nSaldo insuficiente ");
					}
					else {
						System.out.println("\nValor do saque: " + Cores.RED + "-" + valor + Cores.RESET + "\nSaldo Atual: " + Cores.BLUE  + (saldo - valor) + Cores.RESET);
					}
					break;
				}
				case 2:{
					System.out.println("Digite o valor que deseja depositar: ");
					valor = scan.nextFloat();
					if(valor <= 0) {
						System.out.println(Cores.RED + "Depósito Invalido");
					}
					else {
						System.out.println("\nValor do depósito:" + Cores.GREEN + "+" + valor + Cores.RESET + "\nSaldo Atual: " + Cores.BLUE + (saldo + valor) + Cores.RESET);
					}
					break;
				}
				case 3:{
					System.out.println("Digite o valor que deseja transferir: ");
					valor = scan.nextFloat();
					if(valor <= 0) {
						System.out.println(Cores.RED + "Transferência Invalida");
					}
					else {
						System.out.println("\nValor Transferido: " + Cores.YELLOW + "🔄️" + valor + Cores.RESET + "\nSaldo Atual: " + Cores.BLUE + (saldo - valor) + Cores.RESET);
					}
					break;
				}
				default :{
					System.out.println(Cores.RED + "Opção Invalida!");
					System.out.println("\n");;
					break;
				}
			}
		}while(escolha != 0);
		
		System.out.println("Programa Finalizado!");
		scan.close();
	}
}

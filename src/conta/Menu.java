package conta;

import java.util.Scanner;

import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		ContaCorrente contaCorrente1 = new ContaCorrente();
		ContaPoupanca contaPoupanca1 = new ContaPoupanca();
		int escolha, contaDestino;
		float valor;
		
		do {
			System.out.println("ESCOLHA O TIPO DE CONTA QUE DESEJA ACESSAR\n"
								+ "1 - Conta Corrente\n"
								+ "2 - Conta Poupança\n");
			escolha= scan.nextInt();
			scan.nextLine();
			
			switch(escolha) {
				case 1:{
					contaCorrente1.setNumero(1);
					contaCorrente1.setAgencia(11);
					System.out.println("/nDigite o nome do titular da conta: ");
					contaCorrente1.setTitular(scan.nextLine());
					contaCorrente1.setTipo("Conta Corrente");
					contaCorrente1.setSaldo(5000f);
					System.out.println("/nDigite o limite por saque da conta: ");
					contaCorrente1.setLimite(scan.nextFloat());
					do {
						System.out.println("--------ESCOLHA UMA OPÇÃO--------\n"
								 		 + "Nome: " + Cores.BLUE + contaCorrente1.getTitular() + Cores.RESET + " Tipo: " + contaCorrente1.getTipo()
										 + "\nSaldo: " + Cores.BLUE + contaCorrente1.getSaldo() + Cores.RESET + "\n"
										 + "1 - Sacar\n"
										 + "2 - Depositar\n"
										 + "3 - Transferir\n"
										 + "4 - Visualizar dados da conta\n"
										 + "0 - Sair\n"
										 + "---------------------------------\n"
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
								scan.nextLine();
								contaCorrente1.sacar(valor);
								break;
							}
							case 2:{
								System.out.println("Digite o valor que deseja depositar: ");
								valor = scan.nextFloat();
								scan.nextLine();
								contaCorrente1.depositar(valor);
								break;
							}
							case 3:{
								System.out.println("Digite o valor que deseja transferir: ");
								valor = scan.nextFloat();
								System.out.println("Digite o número da conta para tranferência: ");
								contaDestino = scan.nextInt();
								scan.nextLine();
								contaCorrente1.transferir(contaDestino, valor);
								break;
							}
							case 4:{
								contaCorrente1.visualizar();
								break;
							}
							default :{
								System.out.println(Cores.RED + "Opção Invalida!");
								System.out.println("\n");;
								break;
							}
						}
					}while(escolha != 0);
					break;
				}
				case 2:{
					contaPoupanca1.setNumero(1);
					contaPoupanca1.setAgencia(11);
					System.out.println("/nDigite o nome do titular da conta: ");
					contaPoupanca1.setTitular(scan.nextLine());
					contaPoupanca1.setTipo("Conta Poupança");
					contaPoupanca1.setSaldo(5000f);
					do {
						System.out.println("--------ESCOLHA UMA OPÇÃO--------\n"
								 		 + "Nome: " + Cores.BLUE + contaPoupanca1.getTitular() + Cores.RESET + " Tipo: " + contaPoupanca1.getTipo()
										 + "\nSaldo: " + Cores.BLUE + contaPoupanca1.getSaldo() + Cores.RESET + "\n"
										 + "1 - Sacar\n"
										 + "2 - Depositar\n"
										 + "3 - Transferir\n"
										 + "4 - Visualizar dados da conta\n"
										 + "0 - Sair\n"
										 + "---------------------------------\n"
										 + "Entre com a opção desejada: ");
						escolha = scan.nextInt();
						scan.nextLine();

						switch(escolha) {
							case 0:{
								break;
							}
							case 1:{
								System.out.println("\nDigite o valor que deseja sacar: ");
								valor = scan.nextFloat();
								scan.nextLine();
								contaPoupanca1.sacar(valor);
								break;
							}
							case 2:{
								System.out.println("\nDigite o valor que deseja depositar: ");
								valor = scan.nextFloat();
								scan.nextLine();
								contaPoupanca1.depositar(valor);
								break;
							}
							case 3:{
								System.out.println("\nDigite o valor que deseja transferir: ");
								valor = scan.nextFloat();
								System.out.println("\nDigite o número da conta para tranferência: ");
								contaDestino = scan.nextInt();
								scan.nextLine();
								contaPoupanca1.transferir(contaDestino, valor);
								break;
							}
							case 4:{
								contaPoupanca1.visualizar();
								break;
							}
							default :{
								System.out.println(Cores.RED + "\nOpção Invalida!");
								System.out.println("\n");;
								break;
							}
						}
					}while(escolha != 0);
					break;
				}
				default:{
					System.out.println(Cores.RED + "\nOpção invalida!" + Cores.RESET);
					break;
				}
			}
		}while(escolha != 0);
		
		System.out.println("\nPrograma Finalizado!");
		scan.close();
	}
		
}

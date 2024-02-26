package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		ContaController contas = new ContaController();
		int escolha, numero, agencia, aniversario;
		String titular, tipo;
		float saldo, limite, valor;
		
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 133, "Conta Corrente", "José da Silva", 5500f, 1200f);
		contas.cadastrar(cc1);
		
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 122, "Conta Corrente", "Caim Modesto", 20000f, 7700f);
		contas.cadastrar(cc2);
		
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 144, "Conta Poupança", "Jonas Pereira", 2500f, 17);
		contas.cadastrar(cp1);
		
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 155, "Conta Poupança", "Leonor Borbón", 100000f, 31);
		contas.cadastrar(cp2);
		do {
			System.out.println("-------- BANCO DO BRAZIL --------\n"
							 + "1 - Criar Conta\n" 
							 + "2 - Listar Todas as Contas\n" 
							 + "3 - Buscar Conta por Número\n" 
							 + "4 - Atualizar Dados da Conta\n"
							 + "5 - Apagar Conta\n"
							 + "6 - Sacar\n"
							 + "7 - Depositar\n"
							 + "8 - Transferir\n"
							 + "9 - Sair\n"
							 + "---------------------------------\n"
							 + "Entre com a opção desejada: ");
			
			try {
				escolha = scan.nextInt();
				scan.nextLine();
			}catch(InputMismatchException e){
				System.out.println("\nDigite valores inteiros!");
				scan.nextLine();
				escolha = 0;
			}
			
			switch (escolha) {
				case 1: {
					System.out.println("Criar Conta \n");
					System.out.println("Digite o Numero da Agência:");
					agencia = scan.nextInt();
					scan.nextLine();
					System.out.println("Digite seu nome: \n");
					scan.skip("\\R?");
					titular = scan.nextLine();
					
					do {
						System.out.println("ESCOLHA O TIPO DE CONTA QUE DESEJA ACESSAR\n"
											+ "1 - Conta Corrente\n"
											+ "2 - Conta Poupança\n");
						try {
							escolha = scan.nextInt();
							scan.nextLine();
						}catch(InputMismatchException e){
							System.out.println("\nDigite valores inteiros!");
							scan.nextLine();
							escolha = 0;
						}
						
						switch(escolha) {
							case 1: {
								tipo = "Conta Corrente";
								System.out.println("\nDigite o saldo da conta:");
								saldo = scan.nextFloat();
								System.out.println("\nDigite o Limite de Crédito (R$): ");
								limite = scan.nextFloat();
								contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
								keyPress();
								break;
							}
							
							case 2: {
								tipo = "Conta Poupança";
								System.out.println("\nDigite o saldo da conta:");
								saldo = scan.nextFloat();
								System.out.println("\nDigite o dia de Aniverssario da Conta: ");
								aniversario = scan.nextInt();
								scan.nextLine();
								contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
								keyPress();
								break;
							}
							
							default : {
								System.out.println("\nOpção invalida!");
								break;
							}
						}
					
				    }while(escolha != 1 && escolha != 2);
				}
				keyPress();
				break;
				
				case 2:{
					contas.listarTodas();
					keyPress();
					break;
				}
				
				case 3:{
					System.out.println("\nConsulta dados da conta - por número");
					
					System.out.println("\nDigite o número da conta:");
					numero = scan.nextInt();
					scan.nextLine();
					
					contas.procurarPorNumero(numero);
					keyPress();
					break;
				}
				case 4:{
					System.out.println("Atualizar dados da conta\n");
					
					System.out.println("\nDigite o número da conta:");
					numero = scan.nextInt();
					scan.nextLine();
					
					var buscaConta = contas.buscarNaCollection(numero);
					
					if(buscaConta != null) {
						tipo = buscaConta.getTipo();
						
						System.out.println("Digite o Numero da Agência:");
						agencia = scan.nextInt();
						scan.nextLine();
						System.out.println("Digite seu nome: \n");
						scan.skip("\\R?");
						titular = scan.nextLine();
						
						System.out.println("\nDigite o saldo da conta:");
						saldo = scan.nextFloat();
						
						switch(tipo) {
							case "Conta Corrente": {
								System.out.println("\nDigite o Limite de Crédito (R$): ");
								limite = scan.nextFloat();
								
								contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
								break;
							}
							
							case "Conta Poupança": {
								System.out.println("\nDigite o dia de Aniverssario da Conta: ");
								aniversario = scan.nextInt();
								scan.nextLine();
								
								contas.atualizar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));

								break;
							}
							
							default: {
								System.out.println("Tipo de conta inválido!");
							}
						}
					}
					else {
						System.out.println("A conta não foi encontrada!");

					}
					
					keyPress();
					break;
				}
				case 5:{
					System.out.println("\nApagar a Conta\n\n");
					
					System.out.println("\nDigite o número da conta:");
					numero = scan.nextInt();
					scan.nextLine();
					
					contas.deletar(numero);
					
					keyPress();
					break;	
				}
			}
		}while(escolha != 9);
		
}

	public static void keyPress() {

		try {

			System.out.println(Cores.RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}
	}
		
}

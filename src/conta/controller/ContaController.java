package conta.controller;

import java.util.ArrayList;

import conta.model.ModelConta;
import conta.repository.ContaRepository;
import conta.util.Cores;

public class ContaController implements ContaRepository {
	
	private ArrayList<ModelConta> listaContas = new ArrayList<ModelConta>();
	int numero = 0;
	
	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			conta.visualizar();
		}
		else {
			System.out.println("\nA conta número: " + numero + " Não foi encontrada!");
		}
	}
	
	@Override
	public void listarTodas() {
		for (var conta : listaContas){
			conta.visualizar();
		}
	}
	
	@Override
	public void cadastrar(ModelConta conta) {
		listaContas.add(conta);
		System.out.println("\nA conta número: " + conta.getNumero() + " Foi criada com sucesso!");
	}
	
	@Override
	public void atualizar(ModelConta conta) {
		var buscarConta = buscarNaCollection(conta.getNumero());
		
		if(buscarConta != null) {
			listaContas.set(listaContas.indexOf(buscarConta), conta);
			System.out.println("\nA conta número: " + conta.getNumero() + " Foi atualizada com sucesso!");
		}
		else {
			System.out.println("\nA conta número: " + conta.getNumero() + " não foi encontrada!");
		}
	}
	
	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			if(listaContas.remove(conta) == true) {
				System.out.println("\nA conta número: " + numero + " foi deletada com sucesso!");
			}
		}
		else {
			System.out.println("\nA conta número: " + conta.getNumero() + " não foi encontrada!");
		}
	}
	
	@Override
	public void sacar(int numero, float valor) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			if (conta.getSaldo() < valor) {
				System.out.println(Cores.RED + "\nSaldo Insuficiente" + Cores.RESET);
			}
			else {
				conta.setSaldo(conta.getSaldo() - valor);
				System.out.println(Cores.GREEN + "\nValor sacado: " + Cores.RESET + Cores.RED + "-" + valor + Cores.RESET +" Da conta número: " + numero);

			}
		}
		else {
			System.out.println("\nA conta número: " + numero + " não foi encontrada!");
		}
	}
	
	@Override
	public void depositar(int numero, float valor) {
	var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			if (valor < 0) {
				System.out.println(Cores.RED + "\nDepósito Invalido" + Cores.RESET);
			}
			else {
				conta.setSaldo(conta.getSaldo() + valor);
				System.out.println("\nValor do depósito:" + Cores.GREEN + "+" + valor + Cores.RESET + " Na conta número: " + numero);
			}
		}
		else {
			System.out.println("\nA conta número: " + numero + " não foi encontrada!");
		}
	}
	
	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		var contaOrigem = buscarNaCollection(numeroOrigem);
		var contaDestino = buscarNaCollection(numeroDestino);
		
		if(contaOrigem != null && contaDestino != null) {
			if(contaOrigem.getSaldo() > valor) {
				contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
				contaDestino.setSaldo(contaDestino.getSaldo() + valor);
				System.out.println("\nValor Transferido: " + Cores.YELLOW + "🔄️" + valor + Cores.RESET + " Da conta número: " + contaOrigem.getNumero() + " Para a conta: " + contaDestino.getNumero() + Cores.RESET);
			}
			else {
				System.out.println(Cores.RED + "\nSaldo Insuficiente" + Cores.RESET);
			}
		}
		else {
			System.out.println("\nA Conta de Origem e/ou Destino não foram encontradas ");
		}
	}
	
	public int gerarNumero(){
		return numero = listaContas.size() + 1;
	}
	
	public ModelConta buscarNaCollection(int numero) {
		for (var conta : listaContas) {
			if(conta.getNumero() == numero) {
				return conta;
			}
		}
		return null;	
	}
}

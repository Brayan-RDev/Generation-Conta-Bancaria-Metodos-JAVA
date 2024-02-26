package conta.controller;

import java.util.ArrayList;

import conta.model.ModelConta;
import conta.repository.ContaRepository;

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
	public void sacar(float valor) {
		
	}
	
	@Override
	public void depositar(float valor) {
		
	}
	
	@Override
	public void transferir(int numeroDestino, float valor) {
		
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

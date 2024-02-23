package conta.model;

import conta.repository.ContaRepository;

public abstract class ModelConta implements ContaRepository {
		
		private int numero;
		private int agencia;
		private String tipo;
		private String titular;
		private float saldo;
		
		public ModelConta(int numero, int agencia, String tipo, String titular, float saldo) {
			this.numero = numero;
			this.agencia = agencia;
			this.tipo = tipo;
			this.titular = titular;
			this.saldo = saldo;
		}
		
		public ModelConta() {}

		public int getNumero() {
			return numero;
		}

		public void setNumero(int numero) {
			this.numero = numero;
		}

		public int getAgencia() {
			return agencia;
		}

		public void setAgencia(int agencia) {
			this.agencia = agencia;
		}

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
	 
		public String getTitular() {
			return titular;
		}
	 
		public void setTitular(String titular) {
			this.titular = titular;
		}
	 
		public float getSaldo() {
			return saldo;
		}

		public void setSaldo(float saldo) {
			this.saldo = saldo;
		}
			
		public void visualizar() {		
			System.out.println("--------Dados da Conta--------");
			System.out.println("Numero da conta: " + this.numero);
			System.out.println("Agência da conta: " + this.agencia);
			System.out.println("Tipo da conta: " + this.tipo);
			System.out.println("Titular da conta: " + this.titular);
			System.out.println("Saldo da conta: " + this.saldo 
							+ "\n------------------------------");
		}
}


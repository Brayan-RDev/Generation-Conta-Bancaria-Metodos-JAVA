package conta.model;

public abstract class ModelConta {
		
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
		
		public boolean sacar(float valor) {
			if(this.saldo < valor)
			return false;
			
			this.setSaldo(this.saldo - valor);
			return true;
		}
		
		public void depositar(float valor) {
			
			this.setSaldo(this.saldo + valor);
		}
			
		public void visualizar() {		
			System.out.println("**************************");
			System.out.println("Dados da Conta");
			System.out.println("**************************");
			System.out.println("Numero da conta: " + this.numero);
			System.out.println("Agência da conta: " + this.agencia);
			System.out.println("Tipo da conta: " + this.tipo);
			System.out.println("Titular da conta: " + this.titular);
			System.out.println("Saldo da conta: " + this.saldo);
		}
}


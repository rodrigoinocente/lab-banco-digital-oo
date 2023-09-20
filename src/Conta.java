
public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	public static final double TAXA_DE_JUROS = 0.15; // ***TAXA DE JUROS***
	
	@Override
	public double emprestimo(double valorEmprestimo, int parcelas){
		
		double valorJuros = valorEmprestimo * TAXA_DE_JUROS;
		double valorTotal = valorJuros + valorEmprestimo;
		double valorParcela = valorTotal / parcelas;
		
		System.out.println(String.format("Valor da parcela: %.2f", valorParcela));
		saldo = saldo + valorEmprestimo;
		
		System.out.println("Saldo atual: " + saldo);
		
		return valorParcela;
		}
	
	@Override
	public void sacar(double valor) {
		if (verificarSaldo(valor)) {
	        saldo -= valor;
	        System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
	    } else {
	        System.out.println("Saldo insuficiente para o saque. O seu saldo é de R$ " + saldo + ". O valor solicitado foi R$ " + valor);
	    }
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}
	
	private boolean verificarSaldo (double valor) { //Verificar o saldo
		 if (saldo >= valor) {
		return true;
    } else {
    	return false;
    }
		
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}

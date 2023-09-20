
public class Main {

	public static void main(String[] args) {
		Cliente venilton = new Cliente("Venilton", "59874632145", 18);
		
		Conta cc = new ContaCorrente(venilton);
		Conta poupanca = new ContaPoupanca(venilton);

		cc.depositar(100);
		cc.transferir(100, poupanca);
		
		
		poupanca.emprestimo(50, 12);
		poupanca.sacar(300);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
	}

}

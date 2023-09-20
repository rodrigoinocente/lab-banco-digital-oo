
public class Cliente {

	private String nome;
	private String cpf;
	private int idade;

	public Cliente(String nome, String cpf, int idade) {
		if (idade >= 18) {
	    this.nome = nome;
	    this.idade = idade;
	    this.cpf = cpf;
	    } else {
	    	throw new IllegalArgumentException("O cliente deve ser maior de 18 anos."); // Verificando a maioridade
	      }
	    }
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}

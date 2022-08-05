package projetoJDBC.entidades;

public class Gato {
	private int id;
	private String nome;
	private String cor;
	private String sexo;
	
		public Gato() {
		
	}
	public Gato(String nome, String cor, String sexo) {	
			this.nome = nome;
			this.cor = cor;
			this.sexo = sexo;
		}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	
	
	
}

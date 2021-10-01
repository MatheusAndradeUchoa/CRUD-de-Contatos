package models;

public class Pessoa extends Telefone {
    private String nome;
    private double CPF;
    public Pessoa(String nome, double CPF,byte DDD,int numero){
    	setNome(nome);
    	setCPF(CPF);
    	setDDD(DDD);
    	setNumero(numero);
    }
    
	public String getNome() {
		return nome;
    	
    }
    
    public double getCPF() {
    	return CPF;
    }
    
	
	 public void setNome(String umNome) {
	    	this.nome = umNome;
	    }
	    public void setCPF(double umCpf) {
	    	this.CPF = umCpf;
	    }

	 
}
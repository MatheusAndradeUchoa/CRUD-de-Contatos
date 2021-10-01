package models;

public class Telefone {
	private byte DDD;
	private int numero;

	public byte getDDD() {
		return DDD;

	}
	public int getNumero() {
		return numero;
	}

	public void setDDD(byte DDD) {
		this.DDD = DDD;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	@Override
	public String toString(){
		return "Telefone: ("+this.DDD+")"+this.numero;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
package it.contocorrente.entity;

public class Movimento {

	// attributi
	private String data;
	private String iban;
	private double importo;
	private Operazione tipo;
	
	
	
	
	
	
	// getters e setters
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getIban() {
		return iban;
	}
	public void setConto(String iban) {
		this.iban = iban;
	}
	public double getImporto() {
		return importo;
	}
	public void setImporto(double importo) {
		this.importo = importo;
	}
	public Operazione getTipo() {
		return tipo;
	}
	public void setTipo(Operazione tipo) {
		this.tipo = tipo;
	}
	
	
	
	
}

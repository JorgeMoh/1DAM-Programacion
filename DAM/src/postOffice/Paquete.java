package postOffice;

import utils.Utils;

public class Paquete {

	int id=0;
	int peso=0;
	int altura=0;
	int ancho=0;
	String remitente="";
	String receptor="";
	String direccion="";
	String fechaDeEnvio="";
	String fechaDeRecogida="";
	
	Paquete(){
		
		this.id=Utils.numeroAleatorioEntreDosNumeros(1000, 9999);
		this.peso=Utils.pedirNumeroUsuario("Peso del paquete:");
		this.altura=Utils.pedirNumeroUsuario("Altura del paquete:");
		this.ancho=Utils.pedirNumeroUsuario("Ancho del paquete:");
		this.remitente=Utils.pedirTextoUsuario("Remitente del paquete:");
		this.receptor=Utils.pedirTextoUsuario("Receptor del paquete:");
		this.direccion=Utils.pedirTextoUsuario("Direccion de entrega:");
		this.fechaDeEnvio=Utils.pedirTextoUsuario("Fecha de envío:");
		this.fechaDeRecogida="";
		
	}

	@Override
	public String toString() {
		String texto= "Id: "+this.id+"\nPeso: "+this.peso+"\nAltura: "+this.altura+"\nAnchura: "+this.ancho+
				"\nRemitente: "+this.remitente+"\nReceptor: "+this.receptor+"\nDireccion de entrega: "+this.direccion+
				"\nFecha de envio: "+this.fechaDeEnvio+"\nFecha de entrega:"+this.fechaDeRecogida;
		return texto;
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public String getRemitente() {
		return remitente;
	}

	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}

	public String getReceptor() {
		return receptor;
	}

	public void setReceptor(String receptor) {
		this.receptor = receptor;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getFechaDeEnvio() {
		return fechaDeEnvio;
	}

	public void setFechaDeEnvio(String fechaDeEnvio) {
		this.fechaDeEnvio = fechaDeEnvio;
	}

	public String getFechaDeRecogida() {
		return fechaDeRecogida;
	}

	public void setFechaDeRecogida(String fechaDeRecogida) {
		this.fechaDeRecogida = fechaDeRecogida;
	}
	
}

package coleccionAntiguedades;

public class Cuadro extends Antiguedades {

	String tipoPintura="";
	
	Cuadro(){
		
	}

	@Override
	public String toString() {
		String texto="Nombre: "+super.nombre+" Tipo de pintura: "+this.tipoPintura+" Año de fabricacion: "+super.anoDeFabri+" origen: "
				+super.origen+" Precio: "+super.precio;
		return texto;
	}
	
	public String getTipoPintura() {
		return tipoPintura;
	}

	public void setTipoPintura(String tipoPintura) {
		this.tipoPintura = tipoPintura;
	}
	
}

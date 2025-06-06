package postOffice;

public class Main {

	public static void main(String[] args) {

		/**
		 * Crear una aplicación que gestione una oficina de correos. Se puede acceder al sistema con
			2 usuarios: un usuario administrador que controla los datos del paquete y un usuario cliente que
			interactúa con el recibo de recogida o envío del paquete. Estos usuarios
			guarde sus contraseñas en una colección tipo HashMap. La aplicación tiene el siguiente menú:

			2. Elimine el paquete solicitando Idpackage.
			3. Llamar al cliente al mostrador para recoger o enviar un paquete. Una vez que el
				Una vez realizada la gestión, se elimina de la cola y se llama al siguiente cliente.
			4. El cliente podrá elegir entre enviar y recibir un paquete. el sistema
			te entregará un ticket de espera para poder realizar la acción. Este billete debe ser
			asignado por orden de llegada (FIFO).
		 */
	
		Office k = new Office();
		
	}

}

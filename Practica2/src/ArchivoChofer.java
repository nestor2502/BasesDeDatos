package src;

import ArchivoLecturaNoCreadoException;
import ManipulaArchivo;
import Persona;
import Chofer;
import Taxi;

/**
 * repository.ArchivoMedico.java Clase encargada de leer/escribir objetos de la clase
 * model.Medico
 * 
 * @author Nestor Vazquez
 * @version 1.0
 * @see ManipulaArchivo
 */
public class ArchivoChofer extends ManipulaArchivo {

	/**
	*Constructor de la clase
	*@param tipo 0:propietario 1:chofer
	*/
	public ArchivoChofer(int tipo) {
		// coustrimos un file llamado propietario, para poder editar
		super("choferes.csv");
	}
	
		/**
	 * Prepara un arreglo de Persona para que pueda ser guardado
	 * 
	 * @param chofer
	 *            los chofers que se desean guardar
	 */
	public void escribeChofer(Chofer chofer[]) {
		String lineaChofer = "";
		for (Chofer m : chofer) {
			lineaChofer += m + "\n";
		}
		super.escribeArchivo(lineaChofer);
	}
 

}
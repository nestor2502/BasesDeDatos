package src;

import src.ArchivoLecturaNoCreadoException;
import src.ManipulaArchivo;
import src.Persona;
import src.Chofer;
import src.Taxi;
import java.util.List;
import java.util.ArrayList;


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
	public ArchivoChofer() {
		// coustrimos un file llamado chóferes, para poder editar
		super("choferes.csv");
	}
	
		/**
	 * Prepara un arreglo de Persona para que pueda ser guardado
	 * 
	 * @param chofer
	 *            los chofers que se desean guardar
	 */
	public void escribeChofer(List<Chofer> chofer) {
		String lineaChofer = "";
		for (Chofer m : chofer) {
			lineaChofer += m + "\n";
		}
		super.escribeArchivo(lineaChofer);
	}

	/**
	 * Convierte un arreglo de String a un arreglo de taxis
	 * @return arreglo de model.Chofer con los datos del archivo
	 * @throws ArchivoLecturaNoCreadoException
	 */
	public List<Chofer> leeChofer() throws ArchivoLecturaNoCreadoException {
		String lineas[] = super.leeArchivo();
		List<Chofer> choferes = new ArrayList <Chofer>();
		for (int i = 0; i < lineas.length; i++) {
			if (!lineas[i].equals("null")) {
				choferes.add(parseaChofer(lineas[i])) ;
			}
		}
		return choferes;
	}

	/**
	 * Recibe una cadena y parsea los datos para crear el objeto model.Chofer
	 * @param cadenaChofer la cadena a parsear 
	 * @return el objeto con los datos de la cadena
	 */
	private Chofer parseaChofer(String cadenaChofer) {
		if(cadenaChofer.length() != 0){
			String linea[] = cadenaChofer.trim().split(",");
			String nombre = linea[0];
			String direccion = linea[1];
			String correo = linea[2];
			int num_celular = Integer.parseInt(linea[3]);
			int num_licencia = Integer.parseInt(linea[4]);
			String fecha_ingreso = linea[5];
			return new Chofer(nombre, direccion, correo, num_celular,num_licencia,fecha_ingreso);
		}
			return null;
	}

}
 
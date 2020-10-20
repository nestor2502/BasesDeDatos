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
public class ArchivoPropietario extends ManipulaArchivo {

	/**
	*Constructor de la clase
	*@param tipo 0:propietario 1:chofer
	*/
	public ArchivoPropietario(int tipo) {
		super("propietarios.csv");
	}
	
	/**
	 * Prepara un arreglo de Propietario para que pueda ser guardado
	 * 
	 * @param propietario
	 *            los propietarios que se desean guardar
	 */
	public void escribePropietario(Propietario propietario[]) {
		String lineaPropietario = "";
		for (Propietario m : propietario) {
			lineaPropietario += m + "\n";
		}
		super.escribeArchivo(lineaPropietario);
	}

	/**
	 * Convierte un arreglo de String a un arreglo de propietarios
	 * @return arreglo de Propietario con los datos del archivo
	 * @throws ArchivoLecturaNoCreadoException
	 */
	public Propietario[] leePropietarios() throws ArchivoLecturaNoCreadoException {
		String lineas[] = super.leeArchivo();
		Propietario propietarios[] = new Propietario[lineas.length];
		for (int i = 0; i < propietarios.length; i++) {
			if (!lineas[i].equals("null")) {
				propietarios[i] = this.parseaPropietario(lineas[i]);
			}
		}
		return propietarios;
	}

	/**
	 * Recibe una cadena y parsea los datos para crear el objeto Propietario
	 * @param cadenaPropietario la cadena a parsear 
	 * @return el objeto con los datos de la cadena
	 */
	private Propietario parseaPropietario(String cadenaPropietario) {
		String linea[] = cadenaPropietario.trim().split(",");

		String nombre = linea[0];
		String direccion = linea[1];
		String correo = linea[2];
		int num_celular = Integer.parseInt(linea[3]);
		int num_licencia = Integer.parseInt(linea[4]);
		String fecha_ingreso = linea[5];
		String rfc = linea[6];
		boolean es_chofer = Boolean.parseBoolean(linea[7]);
		return new Medico(nombre, direccion, correo, num_celular,num_licencia, fecha_ingreso, rfc, es_chofer);
	}
 

}
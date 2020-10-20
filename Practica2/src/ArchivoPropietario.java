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
	public Propietario[] leePropietario() throws ArchivoLecturaNoCreadoException {
		String lineas[] = super.leeArchivo();
		Propietario propietarios[] = new Propietario[lineas.length];
		for (int i = 0; i < propietarios.length; i++) {
			if (!lineas[i].equals("null")) {
				medicos[i] = this.parseaMedico(lineas[i]);
			}
		}
		return propietarios;
	}

	/**
	 * Recibe una cadena y parsea los datos para crear el objeto Propietario
	 * @param cadenaPropietario la cadena a parsear 
	 * @return el objeto con los datos de la cadena
	 */
	private Propietario parseaMedico(String cadenaPropietario) {
		String linea[] = cadenaMedico.trim().split(",");
		String nombre = linea[0];
		int direccion = Integer.parseInt(linea[1]);
		char correo = linea[2].charAt(0);
		int num_celular = Integer.parseInt(linea[3]);
		String especialidad = linea[4];
		return new Medico(nombre, direccion, correo, idMedico,especialidad,null);
	}
 

}
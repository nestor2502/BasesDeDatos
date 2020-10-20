package src;

import src.ArchivoLecturaNoCreadoException;
import src.Taxi;
import src.ManipulaArchivo;
import java.util.List;
import java.util.ArrayList;


/**
 * ArchivoTaxi.java Clase encargada de leer/escribir objetos de la clase Taxi
 * @author jose ramirez
 * @see ManipulaArchivo
 */
public class ArchivoTaxi extends ManipulaArchivo {
	public ArchivoTaxi() {
		// construimos un file llamado taxis, para poder editar
		super("taxis.csv");
	}

	/**
	 * Prepara un arreglo de Taxi para que pueda ser guardado
	 * 
	 * @param taxi
	 *            los taxis que se desean guardar
	 */
	public void escribeTaxi(List<Taxi> taxi) {
		String lineaTaxi = "";
		for (Taxi m : taxi) {
			if(m != null){
				lineaTaxi += m.toString() + "\n";
			}
			
		}
		super.escribeArchivo(lineaTaxi);
	}
 
	/**
	 * Convierte un arreglo de String a un arreglo de taxis
	 * @return arreglo de Taxi con los datos del archivo
	 * @throws ArchivoLecturaNoCreadoException Excepción si al archivo csv no está creado
	 */
	public List<Taxi> leeTaxis() throws ArchivoLecturaNoCreadoException {
		String lineas[] = super.leeArchivo();
		List<Taxi> taxis = new ArrayList <Taxi> ();
		for (int i = 0; i < lineas.length; i++) {
			if (!lineas[i].equals("null")) {
				taxis.add(parseaTaxi(lineas[i]));
			}
		}
		return taxis;
	}

	/**
	 * Recibe una cadena y parsea los datos para crear el objeto Taxi
	 * @param cadenaTaxi la cadena a parsear 
	 * @return el objeto con los datos de la cadena
	 */
	private Taxi parseaTaxi(String cadenaTaxi) {
		if(cadenaTaxi.length() != 0){
		String linea[] = cadenaTaxi.trim().split(",");
        String placas = linea[0];
        String marca = linea[1];
        String modelo = linea[2];
        int anio = Integer.parseInt(linea[3]);
        int cilindros = Integer.parseInt(linea[4]);
        int puertas = Integer.parseInt(linea[5]);
        boolean tiene_llanta_refaccion = Boolean.parseBoolean(linea[6]);
        boolean sigue_activo = Boolean.parseBoolean(linea[7]);
		return new Taxi(placas, marca, modelo, anio,cilindros,puertas,tiene_llanta_refaccion,sigue_activo);}
		return null;
	}
		

}

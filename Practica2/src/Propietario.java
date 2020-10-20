package src;
import src.Persona;
import src.Chofer;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Clase que modela a un propietario de taxis en la asociación
 * @author nestor vazquez
 */
public class Propietario extends Persona{


	private String rfc;
	private boolean es_chofer;


	/**
	*Constructor de la clase propietario con parámetros de entrada
	*@param nombre  Nombre del propietario
	*@param direccion Dirección del propietario
	*@param correo Correo del propietario
	*@param num_celular Número de celular del propietario
	*@param num_licencia Número de licencia de conducir del propietario
	*@param fecha_ingreso Fecha de ingreso a la asociación del propietario
	*@param es_chofer  Booleano que establece si el propietario también es chófer
	*/
	public Propietario(String nombre, String direccion, String correo, int num_celular, int num_licencia, String fecha_ingreso, String rfc, boolean es_chofer){
		super( nombre,  direccion,  correo,  num_celular,  num_licencia,  fecha_ingreso);
		this.rfc = rfc;
		this.es_chofer = es_chofer;
	}

	/**
	 * Constructor por defecto, que pide datos adicionales propios de un propietario de taxis
	 */
	public Propietario(){
		super();
		Scanner input;
		input = new Scanner(System.in);
		System.out.println("Ingresa el RFC");
		this.rfc = input.nextLine();

		input = new Scanner(System.in);
		boolean bandera = true;
		do {
			try {
				input = new Scanner(System.in);
				System.out.println("Es chofer? 1.- Si, 2.- No");
				int seleccion= input.nextInt();
				if(seleccion == 1 || seleccion == 2){
					if(seleccion == 1) this.es_chofer = true;
					else this.es_chofer = false;
					bandera = false;
				}
				else
					bandera = true;
			} catch (InputMismatchException e) {
				input.next();
				bandera = true;
			}
		} while (bandera);

	}

	/**
	 * Método que toma a un propietario y construye a un objeto Chofer adaptando sus atributos
	 */
	public Chofer convierteAChofer(){
		Chofer chofer = new Chofer(nombre, direccion, correo, num_celular, num_licencia, fecha_ingreso);
		return chofer;
	}

	/**
	 * Método que obtiene el RFC del propietario
	 * @return RFC del propietario de un taxi
	 */
	public String getRFC(){
		return this.rfc;
	}

	/**
	 * Método que establece el RFC de un propietario
	 * @param rfc  RFC del propietario de un taxi
	 */
	public void setRFC(String rfc){
		this.rfc=rfc;
	}

	/**
	 * Método que obtiene si un propietario también es chófer de taxi
	 * @return Booleano que establece si el propietario también es chófer
	 */
	public boolean getEsChofer(){
		return this.es_chofer;
	}

	/**
	 * Método que establece si un propietario también es chófer de taxi
	 * @param es_chofer Booleano que establece si el propietario también es chófer
	 */
	public void setEsChofer(boolean es_chofer){
		this.es_chofer=es_chofer;
	}

	@Override
	public String toString() {
		return  this.nombre + "," + this.direccion + "," + this.correo + "," + this.num_celular + "," + this.num_licencia + "," + this.fecha_ingreso + "," + this.rfc + "," +this.es_chofer;
	}

}
package src;
import src.Persona;
import src.Chofer;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Propietario extends Persona{

	private String nombre;
	private String direccion;
	private String correo;
	private int num_celular;
	private int num_licencia;
	private String fecha_ingreso;
	private String rfc;
	private boolean es_chofer;


	/**
	*Constructor de la clase persona
	*@param nombre
	*@param direccion
	*@param correo 
	*@param num_celular
	*@param num_licencia
	*@param fecha_ingreso
	*@param es_chofer 
	*/
	public Propietario(String nombre, String direccion, String correo, int num_celular, int num_licencia, String fecha_ingreso, String rfc, boolean es_chofer){
		super( nombre,  direccion,  correo,  num_celular,  num_licencia,  fecha_ingreso);
		this.rfc = rfc;
		this.es_chofer = es_chofer;
	}

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

	public Chofer convierteAChofer(){
		Chofer chofer = new Chofer(nombre, direccion, correo, num_celular, num_licencia, fecha_ingreso);
		return chofer;
	}

	public String getRFC(){
		return this.rfc;
	}

	public void setRFC(String rfc){
		this.rfc=rfc;
	}

	public boolean getEsChofer(){
		return this.es_chofer;
	}

	public void setEsChofer(boolean es_chofer){
		this.es_chofer=es_chofer;
	}

}
package src;
import src.Persona;
import src.Chofer;

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
	}

	public Chofer convierteChofer(){
		Chofer chofer = new Chofer(nombre, direccion, correo, num_celular, num_licencia, fecha_ingreso, es_chofer)
		return chofer;
	}


}
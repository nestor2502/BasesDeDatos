package src;
import src.Persona;

public class Chofer extends Persona{

	private String nombre;
	private String direccion;
	private String correo;
	private int num_celular;
	private int num_licencia;
	private String fecha_ingreso;

	/**
	*Constructor de la clase persona
	*@param nombre
	*@param direccion
	*@param correo 
	*@param num_celular
	*@param num_licencia
	*@param fecha_ingreso
	*/

	/**
	*Constructor de la clase
	*/
	public Chofer(String nombre, String direccion, String correo, int num_celular, int num_licencia, String fecha_ingreso){
		super( nombre,  direccion,  correo,  num_celular,  num_licencia,  fecha_ingreso);
	}

	public Chofer(){
		super();
	}

	@Override
	public String toString() {
		return  this.nombre + "," + this.direccion + "," + this.correo + "," + this.num_celular + "," + this.num_licencia + "," + this.fecha_ingreso;
	}
}
package src;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
*@author Nestor Vazquez 
*/
public class Persona{

	protected String nombre;
	protected String direccion;
	protected String correo;
	protected int num_celular;
	protected int num_licencia;
	protected String fecha_ingreso;

	/**
	*Constructor de la clase persona
	*@param nombre
	*@param direccion
	*@param correo 
	*@param num_celular
	*@param num_licencia
	*@param fecha_ingreso
	*/
	public Persona(String nombre, String direccion, String correo, int num_celular, int num_licencia, String fecha_ingreso ){

		this.nombre = nombre;
		this.direccion = direccion;
		this.correo = correo;
		this.num_celular = num_celular;
		this.fecha_ingreso = fecha_ingreso;
	}

		/**
	*Constructor de la clase persona
	*/
	public Persona(){
		pideDatos()
	}	
	public void pideDatos(){
		input = new Scanner(System.in);
		System.out.println("Ingresa nombre:");
		this.nombre = input.nextLine();

		input = new Scanner(System.in);
		System.out.println("Ingresa direccion:");
		this.direccion = input.nextLine();

		input = new Scanner(System.in);
		System.out.println("Ingresa Correo:");
		this.correo = input.nextLine();

		input = new Scanner(System.in);
		System.out.println("Ingresa nn numero celular");
		this.num_celular = input.nextLine();

		input = new Scanner(System.in);
		boolean bandera = true;
		do {
			try {
				input = new Scanner(System.in);
				System.out.println("Ingresa nn numero celular");
				this.num_celular = input.nextInt();
				bandera = false;
			} catch (InputMismatchException e) {
				input.next();
				bandera = true;
			}
		} while (bandera);

		input = new Scanner(System.in);
		boolean bandera = true;
		do {
			try {
				input = new Scanner(System.in);
				System.out.println("Ingresa el numero licencia");
				this.num_celular = input.nextInt();
				bandera = false;
			} catch (InputMismatchException e) {
				input.next();
				bandera = true;
			}
		} while (bandera);

				do {
			try {
				input = new Scanner(System.in);
				System.out.println("Ingresa la fecha de ingreso con el siguiente formato: dd/mm/aa ");
				this.fecha_ingreso = input.nextLine();
				bandera = false;
			} catch (InputMismatchException e) {
				input.next();
				bandera = true;
			}
		} while (bandera);
	}
	/**
	*Metodo que obtiene el nombre
	*@return nombre
	*/
	public String getNombre(){
		return nombre;
	}

	/**
	*setter de la variable nombre
	*@param nombre
	*/
	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	/**
	*Metodo que obtiene la direccion
	*@return 
	*/
	public String getDireccion(){
		return direccion;
	}

	/**
	*setter de la variable direccion
	*@param direccion
	*/
	public void setDireccion(String direccion){
		this.direccion = direccion;
	}

	/**
	*Metodo que obtiene el correo
	*@return correo
	*/
	public String getCorreo(){
		return correo;
	}

	/**
	*setter de la variable correo
	*@param correo
	*/
	public void setCorreo(String correo){
		this.correo = correo;
	}

	/**
	*Metodo que obtiene el telefono celular
	*@return nom_cel
	*/
	public int getCelular(){
		return num_celular;
	}

	/**
	*setter de la variable celular
	*/
	public void setCelular(int num_celular){
		this.num_celular = num_celular;
	}

	/**
	*Metodo que obtiene el numero de licencia
	*/
	public int getLicencia(){
		return num_licencia;
	}

	/**
	*setter de la variable licencia
	*/
	public void setLicencia(int num_licencia){
		this.num_licencia = num_licencia;
	}

	/**
	*Metodo que obtiene la fecha de ingreso
	*/
	public String getFechaIngreso(){
		return fecha_ingreso;
	}

	/**
	*setter de la variable feha_ingreso
	*/
	public void setFechaIngreso(String fecha_ingreso){
		this.fecha_ingreso = fecha_ingreso;
	}

}
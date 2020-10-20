package src;

import java.util.List;
import java.util.ArrayList;
import src.ArchivoLecturaNoCreadoException;
import src.Chofer;
import src.Taxi;
import src.Propietario;

/**
*@author Nestor Vazquez
*
* */
public class Asociacion{

	private List<Propietario> propietarios = new ArrayList<Propietario>();
	private List<Chofer> choferes = new ArrayList<Chofer>();
	private List<Taxi> taxis= new ArrayList<Taxi>();

	/**
	*Constructor de la clase, lee los archivos si estan creados
	*
	 */
	public Asociacion(){
	propietarios = new ArrayList<Propietario>();
	choferes = new ArrayList<Chofer>();
	taxis= new ArrayList<Taxi>();
	ArchivoPropietario archivoPropietario = new ArchivoPropietario();
		try{
			System.out.println("Leyendo datos....");
			propietarios = archivoPropietario.leePropietarios();
			System.out.println("Datos leidos....");
		}catch(ArchivoLecturaNoCreadoException e){
			System.out.println(e.getMessage());
		}	

	ArchivoChofer archivoChofer = new ArchivoChofer();
		try{
			System.out.println("Leyendo datos....");
			choferes = archivoChofer.leeChofer();
			System.out.println("Datos leidos....");
		}catch(ArchivoLecturaNoCreadoException e){
			System.out.println(e.getMessage());
		}
			
	ArchivoTaxi archivoTaxi = new ArchivoTaxi();
		try{
			System.out.println("Leyendo datos....");
			taxis = archivoTaxi.leeTaxis();
			System.out.println("Datos leidos....");
		}catch(ArchivoLecturaNoCreadoException e){
			System.out.println(e.getMessage());
		}
	}	

	/**
	*Agrega un propietario a la lista de propietarios
	*@param propietario
	*/
	public void agregaPropietario(Propietario propietario){
		this.propietarios.add(propietario);
	}

	/**
	*Agrega un chofer a la lista de choferes
	*@param chofer
	* */
	public void agregaChofer(Chofer chofer){
		this.choferes.add(chofer);
	}

	/**
	*Agrega un taxi a la lista de taxis
	*@param taxi
	* */
	public void agregaTaxi(Taxi taxi){
		this.taxis.add(taxi);
	}

	/**
	 * Escribe los propietarios en un archivo 
	 */
	public void guardaPropietarios(){
		ArchivoPropietario archivoP = new ArchivoPropietario();
		archivoP.escribePropietario(this.propietarios);
	}

	/**
	 * Escribe los Choferes en un archivo 
	 */
	public void guardaChoferes(){
		ArchivoChofer archivoC = new ArchivoChofer();
		archivoC.escribeChofer(this.choferes);
	}

	/**
	 * Escribe los Choferes en un archivo 
	 */
	public void guardaTaxis(){
		ArchivoTaxi archivoT = new ArchivoTaxi();
		archivoT.escribeTaxi(this.taxis);
	}

	/**
	 * ]Calcula los lugares ocupados por propietarios
	 * @return
	 */
	private int obtenerCantidadPropietario() {
		return propietarios.size();
	}

	/**
	 * ]Calcula los lugares ocupados por choferes
	 * @return
	 */
	private int obtenerCantidadChofer() {
		return choferes.size();
	}

	/**
	 * ]Calcula los lugares ocupados por taxis
	 * @return
	 */
	private int obtenerCantidadTaxis() {
		return taxis.size();
	}

	/**
	 * Muestra los propietarios que existen en la asociacion
	 * @return propietariosString
	 */
	public String listadoPropietarios(){
		String propietariosString = "";
		int i = 0;
		for(Propietario propietario: this.propietarios){
			if(propietario != null){
				propietariosString += i + " - Nombre: " + propietario.getNombre() + " Direccion:" + propietario.getDireccion() + "Correo: " +propietario.getCorreo()+ "Num.Cel: "+ propietario.getCelular()+" Num.Lic: "+propietario.getLicencia()+" RFC: "+propietario.getRFC()+" Fecha-Ingreso:"+propietario.getFechaIngreso()+"\n";
				i++;
			}
		}
		return propietariosString;
	}

	/**
	 * Muestra los choferes que se encuentran en la asociacion
	 * @return choferesString
	 */
	public String listadoChoferes(){
		String choferesString = "";
		int i = 0;
		for(Chofer chofer: this.choferes){
			if(chofer != null){
				choferesString += i + " - Nombre: " + chofer.getNombre() + " Direccion:" + chofer.getDireccion() + "Correo: " +chofer.getCorreo()+ "Num.Cel: "+ chofer.getCelular()+" Num.Lic: "+chofer.getLicencia()+" Fecha-Ingreso:"+chofer.getFechaIngreso()+"\n";
				i++;
			}
		}
		return choferesString;
	}

	/**
	 * Muestra los taxis que se encuentran en la asociacion
	 * @return
	 */
	public String listadoTaxis(){
		String taxisString = "";
		int i = 0;
		for(Taxi taxi: this.taxis){
			if(taxi != null){
				taxisString += i + " - Placas: " + taxi.getPlacas() + " Marca:" + taxi.getMarca() + "Modelo: " +taxi.getModelo()+ "Año: "+ taxi.getAnio()+" Num. Cilindros: "+taxi.getCilindros()+" Num. Puertas:"+taxi.getPuertas()+" LLanta refaccion: "+ taxi.getTieneLlantaRefaccion()+" Sigue activo: "+taxi.getSigueActivo()+"\n";
				i++;
			}
		}
		return taxisString;
	}

	/**
	*Obtiene los propietarios de la asociuacion
	*@return propietarios
	* */
	public List<Propietario> getPropietarios() {
		return this.propietarios;
	}

	/**
	*Obtiene los choferes de la asociacion
	*@return choferes
	 */
	public List<Chofer> getChoferes() {
		return this.choferes;
	}

	/**
	*Obtiene los taxis de la asociacion	
	*@return taxis
	* */
	public List<Taxi> getTaxis() {
		return this.taxis;
	}

	/**
	*Obtiene un propietario en especifico 
	*@param i posicion del propietario  
	*@return propietario
	* */
	public Propietario getPropietario(int i) throws IndexOutOfBoundsException{
		if(i < 0 || i >= this.obtenerCantidadPropietario()){
			throw new IndexOutOfBoundsException();
		}
		return this.propietarios.get(i);
	}	
	/**
	*Obtiene un chofer en especifico
	*@param i indice del chofer
	*@return 
	* */
	public Chofer getChofer(int i) throws IndexOutOfBoundsException{
		if(i < 0 || i >= this.obtenerCantidadChofer()){
			throw new IndexOutOfBoundsException();
		}
		return this.choferes.get(i);
	}	

	/**
	*Obtiene un taxi en especifico
	*@param i indice del taxi
	*@return 
	* */
	public Taxi getTaxi(int i) throws IndexOutOfBoundsException{
		if(i < 0 || i >= this.obtenerCantidadTaxis()){
			throw new IndexOutOfBoundsException();
		}
		return this.taxis.get(i);
	}	

	/**
	 * Elimina a un propietario de la lista de propietarios
	 * @param i indice del propietario a eliminar 
	 */
	public void eliminaPropietario(int i) {
		if(i >= 0 || i < this.obtenerCantidadPropietario()){
			this.propietarios.remove(0);
		}
	}

	/**
	 * Elimina a un propietario de la lista de médicos
	 * @param i indice del chofer a eliminar 
	 */
	public void eliminaChofer(int i) {
		if(i >= 0 || i < this.obtenerCantidadChofer()){
			this.choferes.remove(0);
		}
	}

	/**
	 * Elimina a un propietario de la lista de médicos
	 * @param i indice del taxi a eliminar 
	 */
	public void eliminaTaxi(int i) {
		if(i >= 0 || i < this.obtenerCantidadTaxis()){
			this.taxis.remove(0);
		}
	}

}
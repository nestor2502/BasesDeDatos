package src;

import java.util.List;
import java.util.ArrayList;
import exception.ArchivoLecturaNoCreadoException;


class Asociacion{

	private List<Propietario> propietarios; = new ArrayList<Propietario>();
	private List<Chofer> choferes; = new ArrayList<Chofer>();
	private List<Taxi> taxis;= new ArrayList<Taxi>();

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
	}

	ArchivoChofer archivoChofer = new ArchivoChofer(){
		try{
			System.out.println("Leyendo datos....");
			choferes = archivoChofer.leeChofer();
			System.out.println("Datos leidos....");
		}catch(ArchivoLecturaNoCreadoException e){
			System.out.println(e.getMessage());
		}	
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

	public void agregaPropietario(Propietario propietario){
		this.propietarios.add(propietario);
	}

	public void agregaChofer(Propietario propietario){
		this.choferes.add(propietario);
	}

	public void agregaTaxi(Taxi taxi){
		this.taxis.add(taxi);
	}

	/**
	 * Escribe los propietarios en un archivo 
	 */
	public void guardaPropietarios(){
		ArchivoPropietario archivoP = new ArchivoPropietario();
		archivoP.escribeMedico(this.propietarios);
	}

	/**
	 * Escribe los Choferes en un archivo 
	 */
	public void guardaChoferes(){
		ArchivoChofer archivoC = new ArchivoChofer();
		archivoC.escribeMedico(this.Choferes);
	}

	/**
	 * Escribe los Choferes en un archivo 
	 */
	public void guardaTaxis(){
		ArchivoTaxi archivoT = new ArchivoTaxi();
		archivoT.escribeMedico(this.Taxis);
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
	 * Muestra los medicos que existen en el hospital
	 * @returns
	 */
	public String listadoPropietarios(){
		String propietariosString = "";
		int i = 0;
		for(Propietario propietario: this.propietarios){
			if(propietario != null){
				propietariosString += i + " - Nombre: " + propietarios.getNombre() + " Direccion:" + propietarios.getEspecialidad() + "Correo: " +propietarios.getCorreo()+ "Num.Cel: "+ propietarios.getCelular()+" Num.Lic: "+propietarios.getLicencia()+" RFC: "+propietarios.getRFC()+" Fecha-Ingreso:"+propietarios.getFechaIngreso()+"\n";
				i++;
			}
		}
		return propietariosString;
	}

	/**
	 * Muestra los medicos que existen en el hospital
	 * @returns
	 */
	public String listadoChoferes(){
		String choferesString = "";
		int i = 0;
		for(Chofer chofer: this.choferes){
			if(chofer != null){
				choferString += i + " - Nombre: " + choferes.getNombre() + " Direccion:" + choferes.getEspecialidad() + "Correo: " +choferes.getCorreo()+ "Num.Cel: "+ choferes.getCelular()+" Num.Lic: "+choferes.getLicencia()+" Fecha-Ingreso:"+choferes.getFechaIngreso()+"\n";
				i++;
			}
		}
		return choferString;
	}

	/**
	 * Muestra los medicos que existen en el hospital
	 * @returns
	 */
	public String listadoTaxis(){
		String taxisString = "";
		int i = 0;
		for(Taxi taxi: this.taxis){
			if(taxi != null){
				taxiString += i + " - Placas: " + taxis.getPlacas() + " Marca:" + taxis.getMarca() + "Modelo: " +taxis.getModelo()+ "Año: "+ taxis.getAnio()+" Num. Cilindros: "+taxis.getCilindros()+" Num. Puertas:"+taxis.getPuertas()+" LLanta refaccion: "+ taxis.getTieneLlantaRefaccion()+" Sigue activo: "+taxis.getSigueactivo()+"\n";
				i++;
			}
		}
		return taxisString;
	}

	public List<Propietario> getPropietarios() {
		return this.propietarios;
	}

	
	public List<Chofer> getChoferes() {
		return this.choferes;
	}

	
	public List<Taxi> getTaxis() {
		return this.taxis;
	}

	public Propietario getPropietario(int i) throws ExcesoMedicoException{
		if(i < 0 || i >= this.obtenerCantidadPropietario()){
			throw new ExcesoMedicoException("model.Medico seleccionado incorrectamente");
		}
		return this.propietarios.get(i);
	}	

		public Choferes getPropietario(int i) throws ExcesoMedicoException{
		if(i < 0 || i >= this.obtenerCantidadChofer()){
			throw new ExcesoMedicoException("model.Medico seleccionado incorrectamente");
		}
		return this.choferes.get(i);
	}	

		public Propietario getTaxis(int i) throws ExcesoMedicoException{
		if(i < 0 || i >= this.obtenerCantidadTaxis()){
			throw new ExcesoMedicoException("model.Medico seleccionado incorrectamente");
		}
		return this.taxis.get(i);
	}	

	/**
	 * Elimina a un propietario de la lista de médicos
	 * @param i indice del medico a eliminar 
	 */
	public void eliminaPropietarios(int i) {
		if(i >= 0 || i < this.obtenerCantidadPropietario()){
			this.propietarios.remove(0);
		}
	}

	/**
	 * Elimina a un propietario de la lista de médicos
	 * @param i indice del medico a eliminar 
	 */
	public void eliminaChoferes(int i) {
		if(i >= 0 || i < this.obtenerCantidadChofer()){
			this.choferes.remove(0);
		}
	}

	/**
	 * Elimina a un propietario de la lista de médicos
	 * @param i indice del medico a eliminar 
	 */
	public void eliminatAXI(int i) {
		if(i >= 0 || i < this.obtenerCantidadTaxis()){
			this.taxis.remove(0);
		}
	}



}
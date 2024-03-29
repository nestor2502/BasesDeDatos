package src;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Clase que modela a un Taxi en la asociación
 * @author jose ramirez
 */
public class Taxi{
    private String placas;
    private String marca;
    private String modelo;
    private int anio;
    private int cilindros;
    private int puertas;
    private boolean tiene_llanta_refaccion;
    private boolean sigue_activo;

    /**
     * Constructor de la clase Taxi que pide cada atributo
     * @param placas Placas del taxi
     * @param marca Marca del taxi
     * @param modelo Modelo del taxi
     * @param anio Año del taxi
     * @param cilindros Número de cilindros del taxi
     * @param puertas Número de puertas del taxi
     * @param tiene_llanta_refaccion Booleano que indica si el taxi cuenta con llanta de refacción
     * @param sigue_activo Booleano que indica si el taxi sigue activo en la asociación
     */
    public Taxi (String placas,String marca, String modelo, int anio, 
            int cilindros,int puertas, boolean tiene_llanta_refaccion, boolean sigue_activo){
        this.placas=placas;
        this.marca=marca;
        this.modelo=modelo;
        this.anio=anio;
        this.cilindros=cilindros;
        this.puertas=puertas;
        this.tiene_llanta_refaccion=tiene_llanta_refaccion;
        this.sigue_activo = sigue_activo;
    }

    /**
	 * Constructor por omision
	 */
	public Taxi() {
		pideDatos();
	}

	/**
	 * Metodo que pide datos para inicializar la clase
	 */
	private void pideDatos() {
        Scanner input;
		input = new Scanner(System.in);
		boolean bandera = true;
		System.out.println("Ingresa placas:");
        this.placas = input.nextLine();
        System.out.println("Ingresa marca:");
		this.marca = input.nextLine();
		System.out.println("Ingresa modelo:");
        this.modelo = input.nextLine();
        do {
			try {
				System.out.println("Ingresa anio:");
				this.anio = input.nextInt();
				bandera = false;
			} catch (InputMismatchException e) {
				input.next();
				bandera = true;
			}
        } while (bandera);
        do {
			try {
				System.out.println("Ingresa numero de cilindros:");
				this.cilindros = input.nextInt();
				bandera = false;
			} catch (InputMismatchException e) {
				input.next();
				bandera = true;
			}
        } while (bandera);
        do {
			try {
				System.out.println("Ingresa numero de puertas:");
				this.puertas = input.nextInt();
				bandera = false;
			} catch (InputMismatchException e) {
				input.next();
				bandera = true;
			}
        } while (bandera);
        boolean bandera_temp = true;
        do{
            System.out.println("¿El taxi tiene llanta de refaccion? (S/N) :");
            char x = input.next().charAt(0);
            if (x == 'S' || x == 's' ){
                this.tiene_llanta_refaccion = true;
                bandera_temp = false;
            }
            else if (x == 'N'|| x == 'n'){
                this.tiene_llanta_refaccion=false;
                bandera_temp = false; 
            }
        } while (bandera_temp);
    
        input = new Scanner(System.in);
		bandera = true;
		do {
			try {
				input = new Scanner(System.in);
				System.out.println("sigue activo? 1.- Si, 2.- No");
				int seleccion= input.nextInt();
				if(seleccion == 1 || seleccion == 2){
					if(seleccion == 1) this.sigue_activo = true;
					else this.sigue_activo = false;
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
     * Método que permite editar datos
     */
    public void edita() {
		this.pideDatos();
	}

    /**
     * Método getter de las placas del taxi
     * @return Placas del taxi
     */
    public String getPlacas(){
        return placas;
    }

    /**
     * Método que establece las placas del taxi
     * @param placas Placas a quedar en el taxi
     */
    public void setPlacas(String placas){
        this.placas=placas;
    }

    /**
     * Método getter de la marca del taxi
     * @return Marca del taxi
     */
    public String getMarca(){
        return marca;
    }

    /**
     * Método setter para la marca del taxi
     * @param marca Marca del taxi
     */
    public void setMarca(String marca){
        this.marca=marca;
    }

    /**
     * Método getter del modelo del taxi
     * @return Modelo del taxi
     */
    public String getModelo(){
        return modelo;
    }

    /**
     * Método setter para el modelo del taxi
     * @param modelo Modelo del taxi
     */
    public void setModelo(String modelo){
        this.modelo=modelo;
    }

    /**
     * Método getter del año del taxi
     * @return Año del taxi
     */
    public int getAnio(){
        return anio;
    }

    /**
     * Método setter para el año del taxi
     * @param anio Año del taxi
     */
    public void setAnio(int anio){
        this.anio=anio;
    }

    /**
     * Método getter del número de cilindros del taxi
     * @return Número de cilindros del taxi
     */
    public int getCilindros(){
        return cilindros;
    }

    /**
     * Método setter para el número de cilindros del taxi
     * @param cilindros Número de cilindros del taxi
     */
    public void setCilindros(int cilindros){
        this.cilindros=cilindros;
    }

    /**
     * Método getter del número de puertas del taxi
     * @return Número de puertas del taxi
     */
    public int getPuertas(){
        return puertas;
    }

    /**
     * Método setter para el número de puertas del taxi
     * @param puertas Número de puertas del taxi
     */
    public void setPuertas(int puertas){
        this.puertas=puertas;
    }

    /**
     * Método getter de si tiene llanta de refacción el taxi
     * @return Si el taxi tiene actualmente llanta de refacción
     */
    public boolean getTieneLlantaRefaccion(){
        return tiene_llanta_refaccion;
    }

    /**
     * Método setter para la llanta de refacción el taxi
     * @param tiene_llanta_refaccion Booleano que indica si el taxi cuenta con llanta de refacción
     */
    public void setTieneLlantaRefaccion(boolean tiene_llanta_refaccion){
        this.tiene_llanta_refaccion=tiene_llanta_refaccion;
    }

    /**
     * Método getter de si está activo el taxi
     * @return El estado del taxi en la asociación
     */
    public boolean getSigueActivo(){
        return sigue_activo;
    }

    /**
     * Método setter para la llanta de refacción el taxi
     * @param sigue_activo Booleano que indica si el taxi sigue activo en la asociación
     */
    public void setSigueActivo(boolean sigue_activo){
        this.sigue_activo=sigue_activo;
    }

    @Override
	public String toString() {
        return this.placas+ "," +this.marca+ "," + this.modelo+ "," + this.anio+ "," + this.cilindros+ "," + this.puertas+ "," + this.tiene_llanta_refaccion+ "," + this.sigue_activo;
		
	}
}
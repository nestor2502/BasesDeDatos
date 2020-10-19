package src;

/**
 * Clase que modela a un Taxi en la asociación
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
     * Constructor de la clase Taxi
     */
    public Taxi (String placas,String marca, String modelo, int anio, 
            int cilindros,int puertas, boolean tiene_llanta_refaccion){
        this.placas=placas;
        this.marca=marca;
        this.modelo=modelo;
        this.anio=anio;
        this.cilindros=cilindros;
        this.puertas=puertas;
        this.tiene_llanta_refaccion=tiene_llanta_refaccion;
    }

    /**
     * Método getter de las placas del taxi
     */
    public String getPlacas(){
        return placas;
    }

    public void setPlacas(String placas){
        this.placas=placas;
    }

    /**
     * Método getter de la marca del taxi
     */
    public String getMarca(){
        return marca;
    }

    /**
     * Método setter para la marca del taxi
     */
    public void setMarca(String marca){
        this.marca=marca;
    }

    /**
     * Método getter del modelo del taxi
     */
    public String getModelo(){
        return modelo;
    }

    /**
     * Método setter para el modelo del taxi
     */
    public void setModelo(String modelo){
        this.modelo=modelo;
    }

    /**
     * Método getter del año del taxi
     */
    public int getAnio(){
        return anio;
    }

    /**
     * Método setter para el año del taxi
     */
    public void setAnio(int anio){
        this.anio=anio;
    }

    /**
     * Método getter del número de cilindros del taxi
     */
    public int getCilindros(){
        return cilindros;
    }

    /**
     * Método setter para el número de cilindros del taxi
     */
    public void setCilindros(int cilindros){
        this.cilindros=cilindros;
    }

    /**
     * Método getter del número de puertas del taxi
     */
    public int getPuertas(){
        return puertas;
    }

    /**
     * Método setter para el número de puertas del taxi
     */
    public void setPuertas(int puertas){
        this.puertas=puertas;
    }

    /**
     * Método getter de si tiene llanta de refacción el taxi
     */
    public String getTieneLlantaRefaccion(){
        return tiene_llanta_refaccion;
    }

    /**
     * Método setter para la llanta de refacción el taxi
     */
    public void setTieneLlantaRefaccion(boolean tiene_llanta_refaccion){
        this.tiene_llanta_refaccion=tiene_llanta_refaccion;
    }

    /**
     * Método getter de si está activo el taxi
     */
    public String getSigueActivo(){
        return sigue_activo;
    }

    /**
     * Método setter para la llanta de refacción el taxi
     */
    public void setSigueActivo(boolean sigue_activo){
        this.sigue_activo=sigue_activo;
    }
}
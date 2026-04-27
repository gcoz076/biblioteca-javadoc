/**
 * Representa una biblioteca que almacena libros en una determinada ciudad.
 * Permite gestionar la cantidad de libros, controlar la capacidad máxima
 * y consultar información sobre su ocupación.
 *
 * @author Alexandru Cozaru
 * @version 1.0
 * @since 1.0
 */
public class Biblioteca {

    /** Nombre de la biblioteca */
    private String nombre;

    /** Ciudad donde se encuentra la biblioteca */
    private String ciudad;

    /** Capacidad máxima de libros que puede almacenar */
    private int capacidad;

    /** Número actual de libros en la biblioteca */
    private int librosActuales;

    /**
     * Constructor que inicializa una biblioteca con nombre, ciudad y capacidad.
     * Inicialmente no contiene libros.
     *
     * @param nombre Nombre de la biblioteca
     * @param ciudad Ciudad donde se ubica
     * @param capacidad Capacidad máxima de libros
     */
    public Biblioteca(String nombre, String ciudad, int capacidad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.capacidad = capacidad;
        this.librosActuales = 0;
    }

    /**
     * Agrega una cantidad de libros a la biblioteca si hay espacio disponible.
     *
     * @param cantidad Número de libros a agregar
     * @return true si los libros se agregaron correctamente, false en caso contrario
     */
    public boolean agregarLibro(int cantidad) {
        if (cantidad <= 0) {
            return false;
        }
        if (librosActuales + cantidad > capacidad) {
            return false;
        }
        librosActuales += cantidad;
        return true;
    }

    /**
     * Retira una cantidad de libros de la biblioteca si es posible.
     *
     * @param cantidad Número de libros a retirar
     * @return true si los libros se retiraron correctamente, false en caso contrario
     */
    public boolean retirarLibro(int cantidad) {
        if (cantidad <= 0 || cantidad > librosActuales) {
            return false;
        }
        librosActuales -= cantidad;
        return true;
    }

    /**
     * Calcula el espacio disponible en la biblioteca.
     *
     * @return Número de libros que aún se pueden almacenar
     */
    public int getEspacioDisponible() {
        return capacidad - librosActuales;
    }

    /**
     * Calcula el porcentaje de ocupación de la biblioteca.
     *
     * @return Porcentaje de ocupación respecto a la capacidad total
     */
    public double getPorcentajeOcupacion() {
        if (capacidad == 0) return 0.0;
        return (librosActuales * 100.0) / capacidad;
    }

    /**
     * Indica si la biblioteca está llena.
     *
     * @return true si no hay más espacio disponible, false en caso contrario
     */
    public boolean estaLlena() {
        return librosActuales >= capacidad;
    }

    /**
     * Obtiene el nombre de la biblioteca.
     *
     * @return Nombre de la biblioteca
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la ciudad de la biblioteca.
     *
     * @return Ciudad donde se encuentra
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Obtiene la capacidad máxima de la biblioteca.
     *
     * @return Capacidad total de libros
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Obtiene el número actual de libros en la biblioteca.
     *
     * @return Número de libros actuales
     */
    public int getLibrosActuales() {
        return librosActuales;
    }

    /**
     * Devuelve una representación en texto de la biblioteca.
     *
     * @return Cadena con el nombre, ciudad y estado de libros
     */
    @Override
    public String toString() {
        return nombre + " (" + ciudad + ") - " + librosActuales + "/" + capacidad + " libros";
    }
}
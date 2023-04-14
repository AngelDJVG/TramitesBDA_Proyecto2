package org.itson.excepciones;

/**
 * Clase que maneja la persistencia excepción
 *
 * @author Ángel Valenzuela, Luis Durán
 */
public class PersistenciaException extends Exception {

    /**
     * Método constructor que inicializa el objeto sin nada.
     */
    public PersistenciaException() {
    }

    /**
     * Método constructor que inicializa el objeto con un mensaje.
     *
     * @param string mensaje de excepción.
     */
    public PersistenciaException(String string) {
        super(string);
    }

    /**
     * Método constructor que inicializa el objeto con un mensaje y un lanzable.
     *
     * @param string mensaje de excepción.
     * @param thrwbl lanzable de excepción.
     */
    public PersistenciaException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    /**
     * Método constructor que inicializa el objeto con un lanzable.
     *
     * @param thrwbl lanzable de la excepción.
     */
    public PersistenciaException(Throwable thrwbl) {
        super(thrwbl);
    }

    /**
     * Método constructor que inicializa el objeto con un mensaje, un lanzable,
     * un
     *
     * @param string mensaje de excepción.
     * @param thrwbl lanzable de excepción.
     * @param bln valor booleano que indica si se debe habilitar la supresión de
     * excepciones
     * @param bln1 valor booleano que indica si se debe habilitar el seguimiento
     * de la pila de excepciones
     */
    public PersistenciaException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
}

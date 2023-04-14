package org.itson.utilidades;

/**
 * Clase que representa la configuración de paginado para la visualización de
 * una lista de elementos en una tabla.
 *
 * @author Ángel Valenzuela, Luis Durán
 */
public class ConfiguracionPaginado {

    private int numeroPagina;
    private int elementosPorPagina;

    /**
     * Constructor de la clase, asigna valores a los atributos.
     *
     * @param numeroPagina el número de página actual
     * @param elementosPorPagina el número de elementos por página
     */
    public ConfiguracionPaginado(int numeroPagina, int elementosPorPagina) {
        this.numeroPagina = numeroPagina;
        this.elementosPorPagina = elementosPorPagina;
    }

    /**
     * Constructor de la clase, asigna valores por defecto de página 0 y 3
     * elementos por página.
     */
    public ConfiguracionPaginado() {
        this.numeroPagina = 0;
        this.elementosPorPagina = 3;
    }

    /**
     * Incrementa el número de página actual en 1.
     */
    public void avanzarPagina() {
        this.numeroPagina++;
    }

    /**
     * Decrementa el número de página actual en 1, solo si el número de página
     * es mayor a 0.
     */
    public void retrocederPagina() {
        if (numeroPagina > 0) {
            this.numeroPagina--;
        }
    }

    /**
     * Obtiene el número de página actual.
     *
     * @return el número de página actual
     */
    public int getNumeroPagina() {
        return numeroPagina;
    }

    /**
     * Establece el número de página actual.
     *
     * @param numeroPagina el número de página actual a establecer
     */
    public void setNumeroPagina(int numeroPagina) {
        this.numeroPagina = numeroPagina;
    }

    /**
     * Obtiene el número de elementos por página.
     *
     * @return el número de elementos por página
     */
    public int getElementosPorPagina() {
        return elementosPorPagina;
    }

    /**
     * Establece el número de elementos por página.
     *
     * @param elementosPorPagina el número de elementos por página a establecer
     */
    public void setElementosPorPagina(int elementosPorPagina) {
        this.elementosPorPagina = elementosPorPagina;
    }

    /**
     * Obtiene la cantidad de elementos a saltar en la paginación.
     *
     * @return la cantidad de elementos a saltar
     */
    public int getElementosSaltar() {
        return this.numeroPagina * this.elementosPorPagina;
    }

}

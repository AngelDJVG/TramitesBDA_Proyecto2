package org.itson.utilidades;

import java.util.List;

/**
 *
 * @author Ángel Valenzuela, Luis Duran
 */
public class ConfiguracionPaginado {

    private int numeroPagina;
    private int elementosPorPagina;

    public ConfiguracionPaginado(int numeroPagina, int elementosPorPagina) {
        this.numeroPagina = numeroPagina;
        this.elementosPorPagina = elementosPorPagina;
    }

    public ConfiguracionPaginado() {
        this.numeroPagina = 0;
        this.elementosPorPagina = 3;
    }

    public void avanzarPagina() {
        this.numeroPagina++;
    }

    public void retrocederPagina() {
        if (numeroPagina > 0) {
            this.numeroPagina--;
        }
    }

    public int getNumeroPagina() {
        return numeroPagina;
    }

    public void setNumeroPagina(int numeroPagina) {
        this.numeroPagina = numeroPagina;
    }

    public int getElementosPorPagina() {
        return elementosPorPagina;
    }

    public void setElementosPorPagina(int elementosPorPagina) {
        this.elementosPorPagina = elementosPorPagina;
    }

    public int getElementosSaltar() {
        return this.numeroPagina * this.elementosPorPagina;
    }

}
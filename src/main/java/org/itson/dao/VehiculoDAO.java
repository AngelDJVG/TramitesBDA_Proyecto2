/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.itson.dominio.Vehiculo;
import org.itson.interfaces.IVehiculo;
import org.itson.utilidades.ConfiguracionPaginado;

/**
 * Clase que implementa la interfaz IVehiculo y utiliza JPA para interactuar con
 * la base de datos.
 *
 * @author Ángel Valenzuela, Luis Durán
 */
public class VehiculoDAO implements IVehiculo {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.itson.tramites");
    private final EntityManager entityManager = emf.createEntityManager();

    /**
     * Consulta los vehículos activos asociados a una persona mediante su RFC.
     *
     * @param rfc el RFC de la persona.
     * @param configPaginado la configuración de la página.
     * @return una lista de arreglos de objetos que contiene los números de
     * serie del vehículo y la placa.
     */
    @Override
    public List<Object[]> consultarActivosPorRFC(String rfc, ConfiguracionPaginado configPaginado) {
        String consulta = "SELECT v.numero, p.numero "
                + "FROM Vehiculo v "
                + "JOIN v.placas p "
                + "WHERE v.persona.rfc = :rfc AND p.esActivo = true";
        TypedQuery<Object[]> query = entityManager.createQuery(consulta, Object[].class);
        query.setParameter("rfc", rfc);
        query.setFirstResult(configPaginado.getElementosSaltar());
        query.setMaxResults(configPaginado.getElementosPorPagina());
        return query.getResultList();
    }

    /**
     * Verifica si existe un vehículo en la base de datos a partir de su número
     * de serie.
     *
     * @param numSerie el número de serie del vehículo a verificar.
     * @return true si existe un vehículo con ese número de serie, false de lo
     * contrario.
     */
    @Override
    public boolean verificarExistencia(String numSerie) {
        TypedQuery<Vehiculo> query = entityManager.createQuery("SELECT v FROM Vehiculo v WHERE v.numero = :numSerie", Vehiculo.class);
        query.setParameter("numSerie", numSerie);
        List<Vehiculo> vehiculos = query.getResultList();
        return !vehiculos.isEmpty();
    }

    /**
     * Consulta un vehículo en la base de datos a partir de su número de serie.
     *
     * @param numSerie el número de serie del vehículo a consultar.
     * @return el vehículo encontrado en la base de datos, null si no existe.
     */
    @Override
    public Vehiculo consultarVehiculo(String numSerie) {
        TypedQuery<Vehiculo> query = entityManager.createQuery("SELECT v FROM Vehiculo v WHERE v.numero = :numSerie", Vehiculo.class);
        query.setParameter("numSerie", numSerie);
        Vehiculo vehiculo = query.getSingleResult();
        return vehiculo;
    }

}

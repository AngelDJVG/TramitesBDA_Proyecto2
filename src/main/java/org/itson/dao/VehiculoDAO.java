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

/**
 *
 * @author wikit
 */
public class VehiculoDAO implements IVehiculo {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.itson.tramites");
    private EntityManager entityManager = emf.createEntityManager();

    @Override
    public List<Object[]> consultarActivosPorRFC(String rfc) {
        String consulta = "SELECT v.numero, p.numero "
                + "FROM Vehiculo v "
                + "JOIN v.placas p "
                + "WHERE v.persona.rfc = :rfc AND p.esActivo = true";
        TypedQuery<Object[]> query = entityManager.createQuery(consulta, Object[].class);
        query.setParameter("rfc", rfc);
        return query.getResultList();
    }
    
    @Override
    public boolean verificarExistencia(String numSerie) {
        TypedQuery<Vehiculo> query = entityManager.createQuery("SELECT v FROM Vehiculo v WHERE v.numero = :numSerie", Vehiculo.class);
        query.setParameter("numSerie", numSerie);
        List<Vehiculo> vehiculos = query.getResultList();
        return !vehiculos.isEmpty();
    }

    @Override
    public Vehiculo consultarVehiculo(String numSerie) {
        TypedQuery<Vehiculo> query = entityManager.createQuery("SELECT v FROM Vehiculo v WHERE v.numero = :numSerie", Vehiculo.class);
        query.setParameter("numSerie", numSerie);
        Vehiculo vehiculo = query.getSingleResult();
        return vehiculo;
    }

}

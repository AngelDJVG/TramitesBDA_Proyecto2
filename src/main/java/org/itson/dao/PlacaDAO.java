/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.itson.dominio.Placa;
import org.itson.dominio.Vehiculo;
import org.itson.interfaces.IPlaca;

/**
 *
 * @author wikit
 */
public class PlacaDAO implements IPlaca {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.itson.tramites");
    private EntityManager entityManager = emf.createEntityManager();

    @Override
    public void agregarPlaca(Placa placa) {
        entityManager.getTransaction().begin();
        entityManager.persist(placa);
        entityManager.getTransaction().commit();
    }

    @Override
    public void actualizarPlaca(Vehiculo vehiculo) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Placa p SET p.esActivo = :esActivo WHERE p.vehiculo = :serie AND p.esActivo = true");
        query.setParameter("esActivo", false);
        query.setParameter("serie", vehiculo);
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }

    @Override
    public boolean verificarExistencia(String placa) {
        TypedQuery<Placa> query = entityManager.createQuery("SELECT p FROM Placa p WHERE p.numero = :numPlaca", Placa.class);
        query.setParameter("numPlaca", placa);
        List<Placa> placas = query.getResultList();
        return !placas.isEmpty();
    }
}

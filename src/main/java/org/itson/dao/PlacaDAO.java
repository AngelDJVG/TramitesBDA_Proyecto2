/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
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
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(placa);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new PersistenceException("Error al agregar la placa");
        }
    }

    @Override
    public void actualizarPlaca(Vehiculo vehiculo) {
        try {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Placa p SET p.esActivo = :esActivo WHERE p.vehiculo = :serie AND p.esActivo = true");
        query.setParameter("esActivo", false);
        query.setParameter("serie", vehiculo);
        query.executeUpdate();
        entityManager.getTransaction().commit();
        }catch(Exception e){
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new PersistenceException("Error al actualizar la placa");
        }
    }
    
    @Override
    public void eliminarPlaca(Placa placa){
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(placa);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new PersistenceException("Error al eliminar la placa");
        }
    }
    @Override
    public boolean verificarExistencia(String placa) {
        TypedQuery<Placa> query = entityManager.createQuery("SELECT p FROM Placa p WHERE p.numero = :numPlaca", Placa.class);
        query.setParameter("numPlaca", placa);
        List<Placa> placas = query.getResultList();
        return !placas.isEmpty();
    }
}

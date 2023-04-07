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
import org.itson.dominio.Automovil;
import org.itson.interfaces.IAutomovil;

/**
 *
 * @author wikit
 */
public class AutomovilDAO implements IAutomovil {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.itson.tramites");
    private EntityManager entityManager = emf.createEntityManager();
    
    @Override
    public void agregarAutomovil(Automovil automovil) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(automovil);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new PersistenceException("Error al agregar el automóvil");
        }
    }

    @Override
    public void actualizarAutomovil(Automovil automovil) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(automovil);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new PersistenceException("Error al actualizar el automóvil");
        }
    }

    @Override
    public void eliminarAutomovil(Automovil automovil) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(automovil);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new PersistenceException("Error al eliminar el automóvil");
        }
    }

    @Override
    public List<Automovil> consultarTodos() {
        Query query = entityManager.createQuery("SELECT a FROM Automovil a");
        return query.getResultList();
    }

}

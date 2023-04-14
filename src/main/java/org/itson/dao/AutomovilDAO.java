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
import org.itson.dominio.Automovil;
import org.itson.interfaces.IAutomovil;

/**
 * Clase que implementa la interfaz IAutomovil y utiliza JPA para interactuar
 * con la base de datos.
 *
 * @author Ángel Valenzuela, Luis Durán
 */
public class AutomovilDAO implements IAutomovil {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.itson.tramites");
    private final EntityManager entityManager = emf.createEntityManager();

    /**
     * Agrega un objeto Automovil a la base de datos.
     *
     * @param automovil El objeto Automovil a agregar.
     * @throws PersistenceException Si ocurre algún error al agregar el objeto a
     * la base de datos.
     */
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

    /**
     * Actualiza un objeto Automovil en la base de datos.
     *
     * @param automovil El objeto Automovil a actualizar.
     * @throws PersistenceException Si ocurre algún error al actualizar el
     * objeto en la base de datos.
     */
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

    /**
     * Elimina un objeto Automovil de la base de datos.
     *
     * @param automovil El objeto Automovil a eliminar.
     * @throws PersistenceException Si ocurre algún error al eliminar el objeto
     * de la base de datos.
     */
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

    /**
     * Consulta y devuelve una lista de todos los objetos Automovil en la base
     * de datos.
     *
     * @return Una lista de todos los objetos Automovil en la base de datos.
     */
    @Override
    public List<Automovil> consultarTodos() {
        Query query = entityManager.createQuery("SELECT a FROM Automovil a");
        return query.getResultList();
    }

}

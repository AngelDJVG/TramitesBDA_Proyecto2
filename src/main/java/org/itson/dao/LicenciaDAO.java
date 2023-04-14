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
import org.itson.dominio.Licencia;
import org.itson.interfaces.ILicencia;

/**
 * Clase que implementa la interfaz ILicencia y utiliza JPA para interactuar con
 * la base de datos.
 *
 * @author Ángel Valenzuela, Luis Durán
 */
public class LicenciaDAO implements ILicencia {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.itson.tramites");
    private final EntityManager entityManager = emf.createEntityManager();

    /**
     * Constructor por omisión.
     */
    public LicenciaDAO() {
    }

    /**
     * Agrega una nueva licencia a la base de datos.
     *
     * @param licencia Objeto Licencia que se va a agregar.
     * @throws PersistenceException Si ocurre algún error al agregar la
     * licencia.
     */
    @Override
    public void agregarLicencia(Licencia licencia) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(licencia);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new PersistenceException("Error al agregar la licencia");
        }
    }

    /**
     * Actualiza una licencia existente en la base de datos.
     *
     * @param licencia Objeto Licencia que se va a actualizar.
     * @throws PersistenceException Si ocurre algún error al actualizar la
     * licencia.
     */
    @Override
    public void actualizarLicencia(Licencia licencia) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(licencia);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new PersistenceException("Error al actualizar la licencia");
        }
    }

    /**
     * Elimina una licencia existente de la base de datos.
     *
     * @param licencia Objeto Licencia que se va a eliminar.
     * @throws PersistenceException Si ocurre algún error al eliminar la
     * licencia.
     */
    @Override
    public void eliminarLicencia(Licencia licencia) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(licencia);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new PersistenceException("Error al eliminar la licencia");
        }
    }

    /**
     * Consulta todas las licencias existentes en la base de datos.
     *
     * @return Lista de licencias.
     */
    @Override
    public List<Licencia> consultarTodos() {
        Query query = entityManager.createQuery("SELECT l FROM Licencia  l");
        return query.getResultList();
    }

    /**
     * Consulta la licencia vigente de una persona.
     *
     * @param rfc RFC de la persona de la que se quiere consultar la licencia.
     * @return Licencia vigente de la persona, o null si no tiene
     * licencia vigente.
     */
    @Override
    public Licencia consultarLicenciaPersona(String rfc) {
        TypedQuery<Licencia> query = entityManager.createQuery("SELECT l FROM Licencia l WHERE l.persona.rfc = :persona AND l.fechaVencimiento > CURRENT_DATE", Licencia.class);
        query.setParameter("persona", rfc);
        List<Licencia> licencias = query.getResultList();
        return licencias.isEmpty() ? null : licencias.get(0);
    }
}

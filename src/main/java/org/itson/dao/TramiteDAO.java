/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import org.itson.dominio.Tramite;
import org.itson.interfaces.ITramite;
import org.itson.tramitesbda.TramitesBDA;
import org.itson.utilidades.ConfiguracionPaginado;

/**
 *
 * @author Ángel De Jesús Valenzuela García
 */
public class TramiteDAO implements ITramite {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.itson.tramites");
    private EntityManager entityManager = emf.createEntityManager();

    public TramiteDAO() {
    }

    @Override
    public void agregarTramite(Tramite tramite) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(tramite);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new PersistenceException("Error al agregar el tramite");
        }
    }

    @Override
    public void actualizarTramite(Tramite tramite) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(tramite);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new PersistenceException("Error al actualizar el tramite");
        }
    }

    @Override
    public void eliminarTramite(Tramite tramite) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(tramite);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new PersistenceException("Error al actualizar el tramite");
        }
    }

    @Override
    public Tramite consultarTramite(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Tramite> consultarTodos() {
        TypedQuery<Tramite> query = entityManager.createQuery("SELECT t FROM Tramite t", Tramite.class);
        List<Tramite> tramites = query.getResultList();
        return tramites;
    }

    @Override
    public List<Tramite> consultarTramitesPersona(String rfc, ConfiguracionPaginado configPaginado) {
        TypedQuery<Tramite> query = entityManager.createQuery("SELECT t FROM Tramite t WHERE t.persona.rfc = :persona", Tramite.class);
        query.setParameter("persona", rfc);
        query.setFirstResult(configPaginado.getElementosSaltar());
        query.setMaxResults(configPaginado.getElementosPorPagina());
        List<Tramite> tramites = query.getResultList();
        return tramites;
    }

    @Override
    public List<Tramite> consultarTramitesPersona(String rfc) {
        TypedQuery<Tramite> query = entityManager.createQuery("SELECT t FROM Tramite t WHERE t.persona.rfc = :persona", Tramite.class);
        query.setParameter("persona", rfc);
        List<Tramite> tramites = query.getResultList();
        return tramites;
    }


}

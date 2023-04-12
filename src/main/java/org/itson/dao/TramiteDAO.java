/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import org.itson.dominio.Licencia;
import org.itson.dominio.Placa;
import org.itson.dominio.Tramite;
import org.itson.interfaces.ITramite;
import org.itson.tramitesbda.TramitesBDA;
import org.itson.utilidades.ConfiguracionPaginado;
import org.itson.utilidades.ParametrosBusquedaConsultaDTO;

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

    @Override
    public List<Tramite> consultarTramitesPorParametros(ParametrosBusquedaConsultaDTO params) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tramite> criteria = builder.createQuery(Tramite.class);
        Root<Tramite> entidadTramite = criteria.from(Tramite.class);
        List<Predicate> filtros = new LinkedList<>();

        if (params.getDesde() != null && params.getHasta() != null) {
            filtros.add(builder.between(entidadTramite.get("fechaExpedicion"), params.getDesde(), params.getHasta()));
        } else if (params.getDesde() != null) {
            filtros.add(builder.greaterThanOrEqualTo(entidadTramite.get("fechaExpedicion"), params.getDesde()));
        } else if (params.getHasta() != null) {
            filtros.add(builder.lessThanOrEqualTo(entidadTramite.get("fechaExpedicion"), params.getHasta()));
        }
        if (params.getNombre() != null) {
            filtros.add(builder.like(entidadTramite.get("nombrePersona"), "%" + params.getNombre() + "%"));
        }

        criteria = criteria.select(entidadTramite).where(builder.and((filtros.toArray(new Predicate[0]))));
        TypedQuery<Tramite> query = entityManager.createQuery(criteria);
        List<Tramite> tramites = query.getResultList();
        return tramites;
    }

    @Override
    public List<Licencia> consultarTramitesLicencia() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Licencia> criteria = builder.createQuery(Licencia.class);
        Root<Licencia> entidadLicencia = criteria.from(Licencia.class);
        criteria.select(entidadLicencia);
        TypedQuery<Licencia> query = entityManager.createQuery(criteria);
        return query.getResultList();
    }

    @Override
    public List<Placa> consultarTramitesPlacas() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Placa> criteria = builder.createQuery(Placa.class);
        Root<Placa> entidadPlaca = criteria.from(Placa.class);
        criteria.select(entidadPlaca);
        TypedQuery<Placa> query = entityManager.createQuery(criteria);
        return query.getResultList();
    }
    
}

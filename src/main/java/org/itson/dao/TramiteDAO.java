/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dao;

import java.text.Normalizer;
import java.util.ArrayList;
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
import org.itson.dominio.Licencia;
import org.itson.dominio.Placa;
import org.itson.dominio.Tramite;
import org.itson.interfaces.ITramite;
import org.itson.utilidades.ConfiguracionPaginado;
import org.itson.utilidades.ParametrosBusquedaConsultaDTO;

/**
 * Clase que implementa la interfaz ITramite y utiliza JPA para interactuar con
 * la base de datos.
 *
 * @author Ángel Valenzuela, Luis Durán
 */
public class TramiteDAO implements ITramite {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.itson.tramites");
    private final EntityManager entityManager = emf.createEntityManager();

    /**
     * Constructor por omisión.
     */
    public TramiteDAO() {
    }

    /**
     * Agrega un Tramite a la base de datos.
     *
     * @param tramite Objeto Tramite a agregar
     * @throws PersistenceException Si ocurre un error al agregar el tramite
     */
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

    /**
     * Actualiza un Tramite de la base de datos.
     *
     * @param tramite Objeto Tramite a actualizar
     * @throws PersistenceException Si ocurre un error al actualizar el tramite
     */
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

    /**
     * Elimina un Tramite de la base de datos.
     *
     * @param tramite Objeto Tramite a eliminar
     * @throws PersistenceException Si ocurre un error al eliminar el tramite
     */
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

    /**
     * Consulta todos los trámites en la base de datos.
     *
     * @return Una lista con todos los trámites.
     */
    @Override
    public List<Tramite> consultarTodos() {
        TypedQuery<Tramite> query = entityManager.createQuery("SELECT t FROM Tramite t", Tramite.class);
        List<Tramite> tramites = query.getResultList();
        return tramites;
    }

    /**
     * Consulta los trámites de una persona por su RFC.
     *
     * @param rfc El RFC de la persona a buscar.
     * @param configPaginado La configuración de paginado.
     * @return Una lista con los trámites de la persona.
     */
    @Override
    public List<Tramite> consultarTramitesPersona(String rfc, ConfiguracionPaginado configPaginado) {
        TypedQuery<Tramite> query = entityManager.createQuery("SELECT t FROM Tramite t WHERE t.persona.rfc = :persona", Tramite.class);
        query.setParameter("persona", rfc);
        query.setFirstResult(configPaginado.getElementosSaltar());
        query.setMaxResults(configPaginado.getElementosPorPagina());
        List<Tramite> tramites = query.getResultList();
        return tramites;
    }

    /**
     * Consulta los trámites de una persona por su RFC.
     *
     * @param rfc El RFC de la persona a buscar.
     * @return Una lista con los trámites de la persona especificada.
     */
    @Override
    public List<Tramite> consultarTramitesPersona(String rfc) {
        TypedQuery<Tramite> query = entityManager.createQuery("SELECT t FROM Tramite t WHERE t.persona.rfc = :persona", Tramite.class);
        query.setParameter("persona", rfc);
        List<Tramite> tramites = query.getResultList();
        return tramites;
    }

    /**
     * Consulta los trámites que coinciden con los parámetros.
     *
     * @param params Los parámetros de búsqueda.
     * @return Una lista con los trámites que coinciden con los parámetros
     * especificados.
     */
    @Override
    public List<Tramite> consultarTramitesPorParametros(ParametrosBusquedaConsultaDTO params) {
        if (params.getNombre() == null && params.getDesde() == null && params.getHasta() == null) {
            return this.consultarTodos();
        }
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tramite> criteria = builder.createQuery(Tramite.class);
        Root<Tramite> entidadTramite = criteria.from(Tramite.class);
        List<Predicate> filtros = new LinkedList<>();
        List<Tramite> todos = this.consultarTodos();

        if (params.getNombre() != null) {
            List<String> nombres = new ArrayList<>();
            for (Tramite tramite : todos) {
                String nombreSinAcentos = Normalizer.normalize(tramite.getNombrePersona(), Normalizer.Form.NFD)
                        .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                        .toLowerCase();
                String nombreBuscadoSinAcentos = Normalizer.normalize(params.getNombre(), Normalizer.Form.NFD)
                        .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                        .toLowerCase();
                if (nombreSinAcentos.contains(nombreBuscadoSinAcentos)) {
                    nombres.add(tramite.getNombrePersona());
                }
            }
            if (!nombres.isEmpty()) {
                filtros.add(entidadTramite.get("nombrePersona").in(nombres));
            } else {
                // Si no se ha encontrado ningún nombre, puedes añadir una cadena que no
                // coincide con ningún nombre, para que no se devuelvan todos los registros.
                filtros.add(builder.equal(entidadTramite.get("nombrePersona"), "nombre_que_nunca_concidirañ´´´"));
            }
        }

        if (params.getDesde() != null && params.getHasta() != null) {
            filtros.add(builder.between(entidadTramite.get("fechaExpedicion"), params.getDesde(), params.getHasta()));
        } else {
            if (params.getDesde() != null) {
                filtros.add(builder.greaterThanOrEqualTo(entidadTramite.get("fechaExpedicion"), params.getDesde()));
            }
            if (params.getHasta() != null) {
                filtros.add(builder.lessThanOrEqualTo(entidadTramite.get("fechaExpedicion"), params.getHasta()));
            }
        }

        criteria = criteria.select(entidadTramite).where(builder.and((filtros.toArray(new Predicate[filtros.size()]))));
        TypedQuery<Tramite> query = entityManager.createQuery(criteria);
        List<Tramite> tramites = query.getResultList();
        return tramites;
    }

    /**
     * Consulta los trámites de licencia registrados.
     *
     * @return una lista de objetos Licencia que representa los trámites
     * registrados
     */
    @Override
    public List<Licencia> consultarTramitesLicencia() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Licencia> criteria = builder.createQuery(Licencia.class);
        Root<Licencia> entidadLicencia = criteria.from(Licencia.class);
        criteria.select(entidadLicencia);
        TypedQuery<Licencia> query = entityManager.createQuery(criteria);
        return query.getResultList();
    }

    /**
     * Consulta los trámites de placas registrados.
     *
     * @return una lista de objetos Placa que representa los trámites
     * registrados
     */
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

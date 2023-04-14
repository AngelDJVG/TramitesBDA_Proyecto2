/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dao;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.itson.dominio.Persona;
import org.itson.interfaces.IPersona;
import org.itson.utilidades.ConfiguracionPaginado;
import org.itson.utilidades.ParametrosBusquedaConsultaDTO;

/**
 * Clase que implementa la interfaz IPersona y utiliza JPA para interactuar con
 * la base de datos.
 *
 * @author Ángel Valenzuela, Luis Durán
 */
public class PersonaDAO implements IPersona {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.itson.tramites");
    private final EntityManager entityManager = emf.createEntityManager();

    /**
     * Constructor por omisión.
     */
    public PersonaDAO() {
    }

    /**
     * Método que agrega una persona a la base de datos.
     *
     * @param persona La persona que se desea agregar.
     * @throws PersistenceException si ocurre un error al agregar a la persona.
     */
    @Override
    public void agregarPersona(Persona persona) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(persona);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new PersistenceException("Error al agregar a la persona");
        }
    }

    /**
     * Método que actualiza una persona en la base de datos.
     *
     * @param persona La persona que se desea actualizar.
     * @throws PersistenceException si ocurre un error al actualizar a la
     * persona.
     */
    @Override
    public void actualizarPersona(Persona persona) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(persona);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new PersistenceException("Error al actualizar a la persona");
        }
    }

    /**
     * Método que elimina una persona de la base de datos.
     *
     * @param persona La persona que se desea eliminar.
     * @throws PersistenceException si ocurre un error al eliminar a la persona.
     */
    @Override
    public void eliminarPersona(Persona persona) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(persona);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new PersistenceException("Error al actualizar a la persona");
        }
    }

    /**
     * Método que consulta una persona de la base de datos por su RFC.
     *
     * @param RFC El RFC de la persona que se desea consultar.
     * @return La persona consultada o null si no se encontró
     */
    @Override
    public Persona consultarPersona(String RFC) {
        try {
            Persona persona = entityManager.find(Persona.class, RFC.trim());
            if (persona != null) {
                return persona;
            }
            return null;
        } catch (Exception e) {
            throw new PersistenceException("Error al consultar a la persona por RFC");
        }
    }

    /**
     * Realiza una consulta de personas utilizando parámetros de búsqueda y una
     * configuración de paginación.
     *
     * @param params Los parámetros de búsqueda a utilizar.
     * @param configPaginado La configuración de paginación a aplicar.
     * @return Lista de las personas que cumplen con los parámetros de búsqueda
     * y la configuración de paginación.
     */
    @Override
    public List<Persona> consultarPorParametros(ParametrosBusquedaConsultaDTO params, ConfiguracionPaginado configPaginado) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> criteria = builder.createQuery(Persona.class);
        Root<Persona> entidadPersona = criteria.from(Persona.class);
        List<Predicate> filtros = new LinkedList<>();

        List<Persona> todas = this.consultarTodos();

        if (params.getRfc() != null) {
            filtros.add(builder.like(entidadPersona.get("rfc"), "%" + params.getRfc() + "%"));
        }
        if (params.getNombre() != null) {
            for (Persona persona : todas) {
                String concatenado = persona.getNombre() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno();
                if (concatenado.toLowerCase().contains(params.getNombre().toLowerCase())) {
                    filtros.add(builder.equal(entidadPersona.get("rfc"), persona.getRfc()));
                }
            }
        }
        if (params.getYear() != null) {
            Expression<String> year = builder.function("year", String.class, entidadPersona.get("fechaNacimiento"));
            filtros.add(builder.like(year, "%" + params.getYear() + "%"));
        }
        criteria = criteria.select(entidadPersona).where(builder.or((filtros.toArray(new Predicate[0]))));
        TypedQuery<Persona> query = entityManager.createQuery(criteria);
        query.setFirstResult(configPaginado.getElementosSaltar());
        query.setMaxResults(configPaginado.getElementosPorPagina());
        List<Persona> personas = query.getResultList();
        return personas;
    }

    /**
     * Realiza una consulta de todas las personas almacenadas en la base de
     * datos.
     *
     * @return Lista de todas las personas almacenadas en la base de datos.
     */
    @Override
    public List<Persona> consultarTodos() {
        Query query = entityManager.createQuery("SELECT p FROM Persona p");
        return query.getResultList();
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dao;

import java.util.ArrayList;
import java.util.GregorianCalendar;
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
 *
 * @author Ángel De Jesús Valenzuela García
 */
public class PersonaDAO implements IPersona {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.itson.tramites");
    private EntityManager entityManager = emf.createEntityManager();

    public PersonaDAO() {
    }
    
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
    
    @Override
    public List<Persona> consultarPorParametros(ParametrosBusquedaConsultaDTO params, ConfiguracionPaginado configPaginado) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> criteria = builder.createQuery(Persona.class);
        Root<Persona> entidadPersona = criteria.from(Persona.class);
        List<Predicate> filtros = new LinkedList<>();
        if (params.getRfc() != null) {
            filtros.add(builder.like(entidadPersona.get("rfc"), "%" + params.getRfc() + "%"));
        }
        if (params.getNombre() != null) {
            filtros.add(builder.like(
                    builder.concat(
                            builder.concat(entidadPersona.get("nombre"), entidadPersona.get("apellidoPaterno")),
                            entidadPersona.get("apellidoMaterno")
                    ), "%" + params.getNombre() + "%")
            );
        }
        if (params.getYear() != null) {
            Expression<Integer> year = builder.function("year", Integer.class, entidadPersona.get("fechaNacimiento"));
            filtros.add(builder.equal(year, params.getYear()));
        }
        criteria = criteria.select(entidadPersona).where(builder.or((filtros.toArray(new Predicate[0]))));
        TypedQuery<Persona> query = entityManager.createQuery(criteria);
        query.setFirstResult(configPaginado.getElementosSaltar());
        query.setMaxResults(configPaginado.getElementosPorPagina());
        List<Persona> personas = query.getResultList();
        return personas;
    }

    @Override
    public List<Persona> consultarTodos() {
        Query query = entityManager.createQuery("SELECT p FROM Persona p");
        return query.getResultList();
    }
    
}

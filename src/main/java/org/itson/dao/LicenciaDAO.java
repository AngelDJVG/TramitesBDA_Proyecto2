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
 *
 * @author Ángel De Jesús Valenzuela García
 */
public class LicenciaDAO implements ILicencia{
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.itson.tramites");
    private EntityManager entityManager = emf.createEntityManager();

    public LicenciaDAO() {
    }
    
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
    
    @Override
    public void eliminarLicencia(Licencia licencia){
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
    @Override
    public List<Licencia> consultarTodos() {
        Query query = entityManager.createQuery("SELECT l FROM Licencia  l");
        return query.getResultList();
    }

    @Override
    public Licencia consultarLicenciaPersona(String rfc) {
        TypedQuery<Licencia> query = entityManager.createQuery("SELECT l FROM Licencia l WHERE l.persona.rfc = :persona AND l.fechaVencimiento > CURRENT_DATE", Licencia.class);
        query.setParameter("persona", rfc);
        List<Licencia> licencias = query.getResultList();
        return licencias.isEmpty() ? null : licencias.get(0);
    }
    
}

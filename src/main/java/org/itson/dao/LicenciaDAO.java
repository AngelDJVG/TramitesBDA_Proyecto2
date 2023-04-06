/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.itson.dominio.Licencia;
import org.itson.dominio.Persona;
import org.itson.interfaces.ILicencia;

/**
 *
 * @author Ángel De Jesús Valenzuela García
 */
public class LicenciaDAO implements ILicencia{
    
    private EntityManager entityManager;

    public LicenciaDAO() {
    }

    public LicenciaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public void agregarLicencia(Licencia licencia) {
        entityManager.getTransaction().begin();
        entityManager.persist(licencia);
        entityManager.getTransaction().commit();
    }

    @Override
    public void actualizarLicencia(Licencia licencia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Licencia> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Licencia consultarLicenciaPersona(String rfc) {
        TypedQuery<Licencia> query = entityManager.createQuery("SELECT l FROM Licencia l WHERE l.persona.rfc = :persona AND l.fechaVencimiento > CURRENT_DATE", Licencia.class);
        query.setParameter("persona", rfc);
        List<Licencia> licencias = query.getResultList();
        return licencias.isEmpty() ? null : licencias.get(0);
    }
    
}

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
import org.itson.dominio.Placa;
import org.itson.dominio.Vehiculo;
import org.itson.interfaces.IPlaca;

/**
 * Clase que implementa la interfaz IPlaca y utiliza JPA para interactuar con la
 * base de datos.
 *
 * @author Ángel Valenzuela, Luis Durán
 */
public class PlacaDAO implements IPlaca {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.itson.tramites");
    private final EntityManager entityManager = emf.createEntityManager();

    /**
     * Método que agrega una placa a la base de datos.
     *
     * @param placa Objeto de tipo Placa que contiene los datos de la placa a
     * agregar.
     * @throws PersistenceException Si ocurre un error al agregar la placa a la
     * base de datos.
     */
    @Override
    public void agregarPlaca(Placa placa) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(placa);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new PersistenceException("Error al agregar la placa");
        }
    }

    /**
     * Método que actualiza una placa en la base de datos.
     *
     * @param vehiculo Objeto de tipo Vehiculo que contiene los datos del
     * vehículo al que pertenece la placa a actualizar.
     * @throws PersistenceException Si ocurre un error al actualizar la placa en
     * la base de datos.
     */
    @Override
    public void actualizarPlaca(Vehiculo vehiculo) {
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("UPDATE Placa p SET p.esActivo = :esActivo WHERE p.vehiculo = :serie AND p.esActivo = true");
            query.setParameter("esActivo", false);
            query.setParameter("serie", vehiculo);
            query.executeUpdate();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new PersistenceException("Error al actualizar la placa");
        }
    }

    /**
     * Método que elimina una placa de la base de datos.
     *
     * @param placa Objeto de tipo Placa que contiene los datos de la placa a
     * eliminar.
     * @throws PersistenceException Si ocurre un error al eliminar la placa de
     * la base de datos.
     */
    @Override
    public void eliminarPlaca(Placa placa) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(placa);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new PersistenceException("Error al eliminar la placa");
        }
    }

    /**
     * Método que verifica si una placa ya existe en la base de datos.
     *
     * @param placa String que representa el número de la placa a verificar.
     * @return true si la placa ya existe en la base de datos, false en caso
     * contrario.
     */
    @Override
    public boolean verificarExistencia(String placa) {
        TypedQuery<Placa> query = entityManager.createQuery("SELECT p FROM Placa p WHERE p.numero = :numPlaca", Placa.class);
        query.setParameter("numPlaca", placa);
        List<Placa> placas = query.getResultList();
        return !placas.isEmpty();
    }
}

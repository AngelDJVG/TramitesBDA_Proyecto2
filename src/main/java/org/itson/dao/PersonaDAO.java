/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dao;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.itson.dominio.Persona;
import org.itson.interfaces.IPersona;

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
        entityManager.getTransaction().begin();
        entityManager.persist(persona);
        entityManager.getTransaction().commit();
    }

    @Override
    public void actualizarPersona(Persona persona) {
        entityManager.getTransaction().begin();
        entityManager.merge(persona);
        entityManager.getTransaction().commit();
    }
    
    @Override
    public Persona consultarPersona(String RFC) {
        Persona persona = entityManager.find(Persona.class, RFC.trim());
        if (persona != null) {
            return persona;
        }
        return null;
    }
    
//    @Override
//    public void crearListaPersonas() {
//        Persona persona1 = new Persona(  "1", "Jorge", "Sánchez", "Quezada", "6441234567", new GregorianCalendar(1995, 5, 15));
//        Persona persona2 = new Persona(  "2", "Mario", "Díaz", "Padilla", "6442345678", new GregorianCalendar(2003, 11, 25));
//        Persona persona3 = new Persona(  "3", "Gabriel", "Mancinas", "Cota", "6443456789", new GregorianCalendar(1992, 2, 12));
//        Persona persona4 = new Persona(  "4", "Julio", "Chon", "Obeso", "6444567890", new GregorianCalendar(1989, 11, 7));
//        Persona persona5 = new Persona(  "5", "Gibran", "Duran", "Solano", "6445678901", new GregorianCalendar(1998, 6, 30));
//        Persona persona6 = new Persona(  "6", "María", "Pérez", "Rodríguez", "6446789012", new GregorianCalendar(2002, 9, 18));
//        Persona persona7 = new Persona(  "7", "Juan", "Gutiérrez", "Fernández", "6447890123", new GregorianCalendar(1987, 4, 25));
//        Persona persona8 = new Persona(  "8", "Laura", "Díaz", "Sánchez", "6448901234", new GregorianCalendar(1997, 1, 5));
//        Persona persona9 = new Persona(  "9", "Alejandro", "Ramírez", "González", "6449012345", new GregorianCalendar(1990, 7, 19));
//        Persona persona10 = new Persona("10", "Isabel", "Herrera", "Santos", "6444321098", new GregorianCalendar(1999, 12, 3));
//        Persona persona11 = new Persona("11", "Arturo", "Vargas", "Montes", "6445432109", new GregorianCalendar(1996, 10, 29));
//        Persona persona12 = new Persona("12", "Rosa", "Álvarez", "Guzmán", "6446543210", new GregorianCalendar(1991, 8, 17));
//        Persona persona13 = new Persona("13", "Manuel", "Castillo", "Díaz", "6447654321", new GregorianCalendar(2001, 6, 11));
//        Persona persona14 = new Persona("14", "Mónica", "López", "Soto", "6448765432", new GregorianCalendar(1994, 3, 2));
//        Persona persona15 = new Persona("15", "Eduardo", "Flores", "Ortega", "6449876543", new GregorianCalendar(1993, 12, 21));
//        Persona persona16 = new Persona("16", "Lucía", "Peralta", "Romero", "6440987654", new GregorianCalendar(1997, 9, 9));
//        Persona persona17 = new Persona("17", "Diego", "Gómez", "Castro", "6445432109", new GregorianCalendar(1995, 6, 17));
//        Persona persona18 = new Persona("18", "Carmen", "Santos", "García", "6444321098", new GregorianCalendar(1990, 11, 27));
//        Persona persona19 = new Persona("19", "Elena", "Moreno", "Núñez", "6443210987", new GregorianCalendar(1998, 4, 7));
//        Persona persona20 = new Persona("20", "Diego", "Gómez", "Castro", "6445432109", new GregorianCalendar(1995, 6, 17));
//        List<Persona> personas = new ArrayList<>();
//        personas.add(persona1);
//        personas.add(persona2);
//        personas.add(persona3);
//        personas.add(persona4);
//        personas.add(persona5);
//        personas.add(persona6);
//        personas.add(persona7);
//        personas.add(persona8);
//        personas.add(persona9);
//        personas.add(persona10);
//        personas.add(persona11);
//        personas.add(persona12);
//        personas.add(persona13);
//        personas.add(persona14);
//        personas.add(persona15);
//        personas.add(persona16);
//        personas.add(persona17);
//        personas.add(persona18);
//        personas.add(persona19);
//        personas.add(persona20);
//    }


    @Override
    public List<Persona> consultarTodos() {
        Query query = entityManager.createQuery("SELECT p FROM Persona p");
        return query.getResultList();
    }

    @Override
    public List<Persona> consultarPorRFC(String rfc) {
        TypedQuery<Persona> query = entityManager.createQuery("SELECT p FROM Persona p WHERE p.rfc = :rfc", Persona.class);
        query.setParameter("rfc", rfc);
        return query.getResultList();
    }
    
}

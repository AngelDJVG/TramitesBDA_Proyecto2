/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.itson.tramitesbda;

import java.util.Arrays;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.itson.dominio.Automovil;
import org.itson.dominio.Licencia;
import org.itson.dominio.Persona;
import org.itson.dominio.Placa;
import org.itson.dominio.Tramite;
import org.itson.enums.EnumTipoLicencia;

/**
 *
 * @author Ángel De Jesús Valenzuela García
 */
public class TramitesBDA {

    public static void main(String[] args) {
        EntityManagerFactory em = Persistence.createEntityManagerFactory("org.itson.tramites");
        EntityManager entityManager = em.createEntityManager();
        entityManager.getTransaction().begin();
        Persona persona = new Persona("123456", "angel", "angel", "angel", "123", new GregorianCalendar());


        Automovil automovil = new Automovil("123-ABC", "AMG", "Mercedez", "Blanco", "G-63", persona);
        Placa placa = new Placa("abc-123", new GregorianCalendar(), new GregorianCalendar(), true, automovil, persona.getNombre(), 300.f, persona);
        Licencia licencia = new Licencia("Angel", 22.f, persona, 2, new GregorianCalendar(), new GregorianCalendar(), EnumTipoLicencia.NORMAL);
        
        persona.setVehiculos(Arrays.asList(automovil));
        persona.setTramites(Arrays.asList(placa,licencia));
        automovil.setPlacas(Arrays.asList(placa));
        
        entityManager.persist(persona);
        entityManager.persist(automovil);
        entityManager.persist(placa);
        entityManager.persist(licencia);
        
        
        Persona persona2 = entityManager.find(Persona.class, "123456");
        System.out.println(persona2.getTramites());
        entityManager.getTransaction().commit();
    }
}

package org.itson.dominio;

import java.util.Calendar;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itson.dominio.Persona;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-04-14T09:29:22", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Tramite.class)
public class Tramite_ { 

    public static volatile SingularAttribute<Tramite, Calendar> fechaExpedicion;
    public static volatile SingularAttribute<Tramite, Persona> persona;
    public static volatile SingularAttribute<Tramite, Float> costo;
    public static volatile SingularAttribute<Tramite, String> nombrePersona;
    public static volatile SingularAttribute<Tramite, Long> id;

}
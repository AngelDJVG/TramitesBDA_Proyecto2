package org.itson.dominio;

import java.util.Calendar;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-03-29T20:28:48", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Licencia.class)
public class Licencia_ { 

    public static volatile SingularAttribute<Licencia, Integer> vigencia;
    public static volatile SingularAttribute<Licencia, Calendar> fechaExpedicion;
    public static volatile SingularAttribute<Licencia, Calendar> fechaVencimiento;
    public static volatile SingularAttribute<Licencia, Long> id;

}
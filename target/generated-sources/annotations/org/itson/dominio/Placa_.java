package org.itson.dominio;

import java.util.Calendar;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-03-29T20:28:48", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Placa.class)
public class Placa_ extends Tramite_ {

    public static volatile SingularAttribute<Placa, String> numero;
    public static volatile SingularAttribute<Placa, Boolean> esActivo;
    public static volatile SingularAttribute<Placa, Calendar> fechaEmision;
    public static volatile SingularAttribute<Placa, Calendar> fechaRecepcion;

}
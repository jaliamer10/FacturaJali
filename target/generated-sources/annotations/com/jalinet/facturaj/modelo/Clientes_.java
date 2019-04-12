package com.jalinet.facturaj.modelo;

import com.jalinet.facturaj.modelo.Factura;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-11T20:00:52")
@StaticMetamodel(Clientes.class)
public class Clientes_ { 

    public static volatile SingularAttribute<Clientes, String> cLNombre;
    public static volatile SingularAttribute<Clientes, String> cLEmail;
    public static volatile SingularAttribute<Clientes, Long> cLClienteID;
    public static volatile CollectionAttribute<Clientes, Factura> facturaCollection;

}
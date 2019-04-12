package com.jalinet.facturaj.modelo;

import com.jalinet.facturaj.modelo.Factura;
import com.jalinet.facturaj.modelo.Pedidos;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-11T20:00:52")
@StaticMetamodel(Mesas.class)
public class Mesas_ { 

    public static volatile SingularAttribute<Mesas, String> mSUbicacion;
    public static volatile SingularAttribute<Mesas, Long> mSMesaID;
    public static volatile CollectionAttribute<Mesas, Factura> facturaCollection;
    public static volatile CollectionAttribute<Mesas, Pedidos> pedidosCollection;

}
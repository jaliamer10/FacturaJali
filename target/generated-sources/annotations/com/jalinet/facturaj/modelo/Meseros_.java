package com.jalinet.facturaj.modelo;

import com.jalinet.facturaj.modelo.Factura;
import com.jalinet.facturaj.modelo.Pedidos;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-11T20:00:52")
@StaticMetamodel(Meseros.class)
public class Meseros_ { 

    public static volatile SingularAttribute<Meseros, Long> mEMeseroID;
    public static volatile SingularAttribute<Meseros, String> mEHorario;
    public static volatile SingularAttribute<Meseros, String> mENombreMesero;
    public static volatile CollectionAttribute<Meseros, Factura> facturaCollection;
    public static volatile CollectionAttribute<Meseros, Pedidos> pedidosCollection;

}
package com.jalinet.facturaj.modelo;

import com.jalinet.facturaj.modelo.Detallefactura;
import com.jalinet.facturaj.modelo.Factura;
import com.jalinet.facturaj.modelo.Mesas;
import com.jalinet.facturaj.modelo.Meseros;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-11T20:00:52")
@StaticMetamodel(Pedidos.class)
public class Pedidos_ { 

    public static volatile SingularAttribute<Pedidos, Mesas> mESASMSMesaID;
    public static volatile CollectionAttribute<Pedidos, Detallefactura> detallefacturaCollection;
    public static volatile SingularAttribute<Pedidos, Long> pEPedidoID;
    public static volatile SingularAttribute<Pedidos, Meseros> mESEROSMEMeseroID;
    public static volatile SingularAttribute<Pedidos, Boolean> pEFacturado;
    public static volatile CollectionAttribute<Pedidos, Factura> facturaCollection;

}
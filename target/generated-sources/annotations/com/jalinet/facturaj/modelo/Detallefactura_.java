package com.jalinet.facturaj.modelo;

import com.jalinet.facturaj.modelo.Factura;
import com.jalinet.facturaj.modelo.Pedidos;
import com.jalinet.facturaj.modelo.Productos;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-11T20:00:52")
@StaticMetamodel(Detallefactura.class)
public class Detallefactura_ { 

    public static volatile SingularAttribute<Detallefactura, Pedidos> pEDIDOSPEPedidoID;
    public static volatile SingularAttribute<Detallefactura, Long> dFValorPedido;
    public static volatile SingularAttribute<Detallefactura, Long> dFCostoPedido;
    public static volatile SingularAttribute<Detallefactura, Long> dFIndice;
    public static volatile SingularAttribute<Detallefactura, Productos> pRODUCTOSPRProductoID;
    public static volatile SingularAttribute<Detallefactura, Long> dFImpuestoPedido;
    public static volatile SingularAttribute<Detallefactura, Factura> fACTURAFAFacturaID;
    public static volatile SingularAttribute<Detallefactura, Long> dFCantidad;

}
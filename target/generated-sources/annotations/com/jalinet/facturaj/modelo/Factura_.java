package com.jalinet.facturaj.modelo;

import com.jalinet.facturaj.modelo.Clientes;
import com.jalinet.facturaj.modelo.Detallefactura;
import com.jalinet.facturaj.modelo.Mediopago;
import com.jalinet.facturaj.modelo.Mesas;
import com.jalinet.facturaj.modelo.Meseros;
import com.jalinet.facturaj.modelo.Pedidos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-11T20:00:52")
@StaticMetamodel(Factura.class)
public class Factura_ { 

    public static volatile SingularAttribute<Factura, Long> fACostoFactura;
    public static volatile SingularAttribute<Factura, Pedidos> pEDIDOSPEPedidoID;
    public static volatile SingularAttribute<Factura, Date> fAFechaHora;
    public static volatile SingularAttribute<Factura, Mesas> mESASMSMesaID;
    public static volatile CollectionAttribute<Factura, Detallefactura> detallefacturaCollection;
    public static volatile SingularAttribute<Factura, Long> fAFacturaID;
    public static volatile SingularAttribute<Factura, Long> fAImpuestoFactura;
    public static volatile SingularAttribute<Factura, Long> fAValorTotal;
    public static volatile SingularAttribute<Factura, Clientes> cLIENTESCLClienteID;
    public static volatile SingularAttribute<Factura, Mediopago> mEDIOPAGOMPMedioPagoID;
    public static volatile SingularAttribute<Factura, Meseros> mESEROSMEMeseroID;

}
package com.jalinet.facturaj.modelo;

import com.jalinet.facturaj.modelo.Detallefactura;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-11T20:00:52")
@StaticMetamodel(Productos.class)
public class Productos_ { 

    public static volatile SingularAttribute<Productos, Long> pRCostoUnitario;
    public static volatile SingularAttribute<Productos, String> pRUnidadMedida;
    public static volatile SingularAttribute<Productos, Long> pRProductoID;
    public static volatile SingularAttribute<Productos, Long> pRImpuestoUnidad;
    public static volatile CollectionAttribute<Productos, Detallefactura> detallefacturaCollection;
    public static volatile SingularAttribute<Productos, String> pRNombreProducto;

}
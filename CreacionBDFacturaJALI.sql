CREATE DATABASE  IF NOT EXISTS `facturacion_jali` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `facturacion_jali`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: facturacion_jali
-- ------------------------------------------------------
-- Server version	5.6.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `CL_ClienteID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CL_Nombre` varchar(45) DEFAULT NULL,
  `CL_Email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CL_ClienteID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'JOSE AHUMADA','jali2004@gmail.com'),(2,'CARLOS DIAZ','cdiaz@mail.com');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detallefactura`
--

DROP TABLE IF EXISTS `detallefactura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detallefactura` (
  `FACTURA_FA_FacturaID` bigint(20) NOT NULL,
  `PEDIDOS_PE_PedidoID` bigint(20) NOT NULL,
  `PRODUCTOS_PR_ProductoID` bigint(20) NOT NULL,
  `DF_Cantidad` decimal(10,0) NOT NULL,
  `DF_CostoPedido` decimal(10,0) NOT NULL,
  `DF_ImpuestoPedido` decimal(10,0) NOT NULL,
  `DF_ValorPedido` decimal(10,0) NOT NULL,
  `DF_Indice` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`DF_Indice`),
  KEY `fk_DETALLEFACTURA_PEDIDOS1_idx` (`PEDIDOS_PE_PedidoID`),
  KEY `fk_DETALLEFACTURA_PRODUCTOS1_idx` (`PRODUCTOS_PR_ProductoID`),
  KEY `fk_DETALLEFACTURA_FACTURA1_idx` (`FACTURA_FA_FacturaID`),
  CONSTRAINT `fk_DETALLEFACTURA_FACTURA1` FOREIGN KEY (`FACTURA_FA_FacturaID`) REFERENCES `factura` (`FA_FacturaID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_DETALLEFACTURA_PEDIDOS1` FOREIGN KEY (`PEDIDOS_PE_PedidoID`) REFERENCES `pedidos` (`PE_PedidoID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_DETALLEFACTURA_PRODUCTOS1` FOREIGN KEY (`PRODUCTOS_PR_ProductoID`) REFERENCES `productos` (`PR_ProductoID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallefactura`
--

LOCK TABLES `detallefactura` WRITE;
/*!40000 ALTER TABLE `detallefactura` DISABLE KEYS */;
/*!40000 ALTER TABLE `detallefactura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factura` (
  `FA_FacturaID` bigint(20) NOT NULL AUTO_INCREMENT,
  `FA_FechaHora` datetime DEFAULT NULL,
  `CLIENTES_CL_ClienteID` bigint(20) NOT NULL,
  `MESAS_MS_MesaID` bigint(20) NOT NULL,
  `MEDIOPAGO_MP_MedioPagoID` bigint(20) NOT NULL,
  `PEDIDOS_PE_PedidoID` bigint(20) NOT NULL,
  `MESEROS_ME_MeseroID` bigint(20) NOT NULL,
  `FA_CostoFactura` decimal(10,0) DEFAULT NULL,
  `FA_ImpuestoFactura` decimal(10,0) DEFAULT NULL,
  `FA_ValorTotal` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`FA_FacturaID`),
  KEY `fk_FACTURA_CLIENTES_idx` (`CLIENTES_CL_ClienteID`),
  KEY `fk_FACTURA_MEDIOPAGO1_idx` (`MEDIOPAGO_MP_MedioPagoID`),
  KEY `fk_FACTURA_MESAS1_idx` (`MESAS_MS_MesaID`),
  KEY `fk_FACTURA_PEDIDOS1_idx` (`PEDIDOS_PE_PedidoID`),
  KEY `fk_FACTURA_MESEROS1_idx` (`MESEROS_ME_MeseroID`),
  CONSTRAINT `fk_FACTURA_CLIENTES` FOREIGN KEY (`CLIENTES_CL_ClienteID`) REFERENCES `clientes` (`CL_ClienteID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_FACTURA_MEDIOPAGO1` FOREIGN KEY (`MEDIOPAGO_MP_MedioPagoID`) REFERENCES `mediopago` (`MP_MedioPagoID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_FACTURA_MESAS1` FOREIGN KEY (`MESAS_MS_MesaID`) REFERENCES `mesas` (`MS_MesaID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_FACTURA_MESEROS1` FOREIGN KEY (`MESEROS_ME_MeseroID`) REFERENCES `meseros` (`ME_MeseroID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_FACTURA_PEDIDOS1` FOREIGN KEY (`PEDIDOS_PE_PedidoID`) REFERENCES `pedidos` (`PE_PedidoID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mediopago`
--

DROP TABLE IF EXISTS `mediopago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mediopago` (
  `MP_MedioPagoID` bigint(20) NOT NULL AUTO_INCREMENT,
  `MP_Descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`MP_MedioPagoID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mediopago`
--

LOCK TABLES `mediopago` WRITE;
/*!40000 ALTER TABLE `mediopago` DISABLE KEYS */;
INSERT INTO `mediopago` VALUES (1,'Efectivo'),(2,'Tarjeta Crédito'),(3,'Tarjeta Débito'),(4,'Bonos Sodexo');
/*!40000 ALTER TABLE `mediopago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mesas`
--

DROP TABLE IF EXISTS `mesas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mesas` (
  `MS_MesaID` bigint(20) NOT NULL AUTO_INCREMENT,
  `MS_Ubicacion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`MS_MesaID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mesas`
--

LOCK TABLES `mesas` WRITE;
/*!40000 ALTER TABLE `mesas` DISABLE KEYS */;
INSERT INTO `mesas` VALUES (1,'Mesa 1 PP'),(2,'Mesa 2 PP'),(3,'Mesa 3 PP'),(4,'Mesa 1 SP'),(5,'Mesa 2 SP');
/*!40000 ALTER TABLE `mesas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meseros`
--

DROP TABLE IF EXISTS `meseros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meseros` (
  `ME_MeseroID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ME_NombreMesero` varchar(45) DEFAULT NULL,
  `ME_Horario` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ME_MeseroID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meseros`
--

LOCK TABLES `meseros` WRITE;
/*!40000 ALTER TABLE `meseros` DISABLE KEYS */;
INSERT INTO `meseros` VALUES (1,'Mesero 1','Mañana'),(2,'Mesero 2','Tarde'),(3,'Mesero 3','Todo el día'),(4,'Mesero 4','Todo el día'),(5,'Mesero 5','Nocturno'),(6,'Mesero 6','Nocturno');
/*!40000 ALTER TABLE `meseros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedidos` (
  `PE_PedidoID` bigint(20) NOT NULL AUTO_INCREMENT,
  `MESAS_MS_MesaID` bigint(20) NOT NULL,
  `MESEROS_ME_MeseroID` bigint(20) NOT NULL,
  `PE_Facturado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`PE_PedidoID`),
  KEY `fk_PEDIDOS_MESAS1_idx` (`MESAS_MS_MesaID`),
  KEY `fk_PEDIDOS_MESEROS1_idx` (`MESEROS_ME_MeseroID`),
  CONSTRAINT `fk_PEDIDOS_MESAS1` FOREIGN KEY (`MESAS_MS_MesaID`) REFERENCES `mesas` (`MS_MesaID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_PEDIDOS_MESEROS1` FOREIGN KEY (`MESEROS_ME_MeseroID`) REFERENCES `meseros` (`ME_MeseroID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` VALUES (1,1,2,1),(2,1,3,0),(3,2,3,0),(4,1,3,0),(5,3,2,0);
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productos` (
  `PR_ProductoID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PR_NombreProducto` varchar(45) DEFAULT NULL,
  `PR_CostoUnitario` decimal(10,0) DEFAULT NULL,
  `PR_ImpuestoUnidad` decimal(10,0) DEFAULT NULL,
  `PR_UnidadMedida` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`PR_ProductoID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'Ensalada',10000,190,'Plato'),(2,'Sopa',5000,95,'Plato'),(3,'Carne 250gr',25000,4750,'Filete 250gr'),(4,'Carne 350gr',32000,6080,'Filete 500gr'),(5,'Pollo 250gr',22000,4180,'Pechuga 200gr'),(6,'Pollo 300gr',30000,5700,'Pechuga 300gr'),(7,'Mojarra',25000,4750,'Mojarra pequeña'),(8,'Salmón',40000,7600,'Filete 200gr'),(9,'Postre Limon',10000,190,'Porcion'),(10,'Postre Tres Leches',12000,2280,'Porcion'),(11,'Limonada Natural',7000,1330,'Vaso'),(12,'Cerveza Nacional',8000,1520,'Botella'),(13,'Cerveza Importada',10000,190,'Botella');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-07 18:39:14

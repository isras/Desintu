/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.6.31-log : Database - desintu
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`desintu` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `desintu`;

/*Table structure for table `account_record` */

DROP TABLE IF EXISTS `account_record`;

CREATE TABLE `account_record` (
  `account_record_id` bigint(11) NOT NULL,
  `ar_count` int(100) DEFAULT '1',
  `ar_type` int(11) DEFAULT NULL,
  `ar_date` date DEFAULT NULL,
  `ar_description` varchar(255) DEFAULT NULL,
  `ar_value` double(10,2) DEFAULT NULL,
  `ar_receivable_account_id` bigint(11) NOT NULL,
  PRIMARY KEY (`account_record_id`),
  KEY `fk_account_record_receivable_account1_idx` (`ar_receivable_account_id`),
  CONSTRAINT `fk_account_record_receivable_account1` FOREIGN KEY (`ar_receivable_account_id`) REFERENCES `receivable_account` (`receivable_account_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `account_record` */

insert  into `account_record`(`account_record_id`,`ar_count`,`ar_type`,`ar_date`,`ar_description`,`ar_value`,`ar_receivable_account_id`) values (3104,1,0,'2016-09-05','Pago a la cuenta',13.60,1804),(3106,1,0,'2016-09-05','Pago a la cuenta',200.00,1804),(3107,1,0,'2016-09-05','Pago a la cuenta',50.00,1804),(3108,1,0,'2016-09-05','Pago a la cuenta',50.00,1804),(3112,2,0,'2016-09-05','Pago a la cuenta',0.40,1804),(3152,2,0,'2016-09-05','Pago a la cuenta',1.00,1804),(3202,2,0,'2016-09-05','Pago a la cuenta',1.00,1804),(3204,2,0,'2016-09-05','Pago a la cuenta',6.00,1804),(3207,3,0,'2016-09-05','Pago a la cuenta',4.00,1804),(3210,3,0,'2016-09-05','Pago a la cuenta',1.20,1804),(3212,3,1,'2016-09-05','Préstamo al cliente',6.00,1804),(3302,3,1,'2016-09-05','Préstamo al cliente',4.00,1804),(3352,3,1,'2016-09-05','Préstamo al cliente',8.00,1804),(3354,1,0,'2016-09-05','Pago a la cuenta',23.00,3254),(3359,NULL,0,'2016-09-05','Abono a la orden Nro.: 14',30.00,3254),(3360,1,1,'2016-09-05','Préstamo al cliente',10.00,3254),(3402,3,0,'2016-09-06','Pago a la cuenta',5.00,1804),(3404,3,1,'2016-09-06','Préstamo al cliente',2.00,1804),(3452,3,0,'2016-09-06','Pago a la cuenta',3.00,1804),(3454,3,1,'2016-09-06','Préstamo al cliente',3.00,1804),(3502,3,0,'2016-09-06','Pago a la cuenta',5.00,1804),(3552,3,0,'2016-09-06','Pago a la cuenta',10.00,1804),(3554,3,1,'2016-09-06','Préstamo al cliente',5.00,1804),(3602,3,0,'2016-09-06','Pago a la cuenta',30.00,1804),(3604,3,1,'2016-09-06','Préstamo al cliente',5.00,1804),(3654,NULL,0,'2016-09-06','Abono a la orden Nro.: 15',10.00,1804),(3952,1,0,'2016-09-10','Pago a la cuenta',30.00,3254),(3954,1,1,'2016-09-10','Préstamo al cliente',10.00,3254);

/*Table structure for table `accounting_entry` */

DROP TABLE IF EXISTS `accounting_entry`;

CREATE TABLE `accounting_entry` (
  `accounting_entry_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `ae_type` int(2) DEFAULT NULL,
  `ae_created_date` date DEFAULT NULL,
  `ae_description` text,
  `ae_value` double DEFAULT NULL,
  PRIMARY KEY (`accounting_entry_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5554 DEFAULT CHARSET=utf8;

/*Data for the table `accounting_entry` */

insert  into `accounting_entry`(`accounting_entry_id`,`ae_type`,`ae_created_date`,`ae_description`,`ae_value`) values (2254,0,'2016-08-30','pago a trabajador',10),(2803,0,'2016-09-02','Abono a la cuenta de : Vicente Israel Sotomayor Viñan',1),(2853,0,'2016-09-02','Abono a la cuenta de : Vicente Israel Sotomayor Viñan',14),(2905,0,'2016-09-02','Abono a la cuenta de : Vicente Israel Sotomayor Viñan',5),(2907,0,'2016-09-02','Abono a la cuenta de : Vicente Israel Sotomayor Viñan',9),(2909,0,'2016-09-02','Abono a la cuenta de : Vicente Israel Sotomayor Viñan',5),(2952,1,'2016-09-02','Se eliminio pago de : Vicente Israel Sotomayor Viñan',5),(2954,0,'2016-09-02','Abono a la cuenta de : Vicente Israel Sotomayor Viñan',10),(2955,1,'2016-09-02','Se eliminio pago de : Vicente Israel Sotomayor Viñan',5),(2957,0,'2016-09-02','Abono a la cuenta de : Vicente Israel Sotomayor Viñan',10),(3003,0,'2016-09-05','Abono a la cuenta de : Vicente Israel Sotomayor Viñan',6),(3053,0,'2016-09-05','Abono a la cuenta de : Vicente Israel Sotomayor Viñan',3),(3105,0,'2016-09-05','Abono a la cuenta de : Vicente Israel Sotomayor Viñan',50),(3109,0,'2016-09-05','Abono a la cuenta de : Vicente Israel Sotomayor Viñan',50),(3113,0,'2016-09-05','Abono a la cuenta de : Vicente Israel Sotomayor Viñan',0.4),(3153,0,'2016-09-05','Abono a la cuenta de : Vicente Israel Sotomayor Viñan',1),(3203,0,'2016-09-05','Abono a la cuenta de : Vicente Israel Sotomayor Viñan',6),(3208,0,'2016-09-05','Abono a la cuenta de : Vicente Israel Sotomayor Viñan',4),(3211,0,'2016-09-05','Abono a la cuenta de : Vicente Israel Sotomayor Viñan',1.2),(3213,0,'2016-09-05','Abono a la cuenta de : Vicente Israel Sotomayor Viñan',6),(3303,0,'2016-09-05','Abono a la cuenta de : Vicente Israel Sotomayor Viñan',4),(3353,0,'2016-09-05','Abono a la cuenta de : Vicente Israel Sotomayor Viñan',8),(3355,0,'2016-09-05','Abono a la cuenta de : Julio Galán',23),(3361,0,'2016-09-05','Abono a la cuenta de : Julio Galán',10),(3403,1,'2016-09-06','Abono a la cuenta de : Vicente Israel Sotomayor Viñan',2),(3453,1,'2016-09-06','Abono a la cuenta de : Vicente Israel Sotomayor Viñan',3),(3503,0,'2016-09-06','Abono a la cuenta de : Vicente Israel Sotomayor Viñan',5),(3553,0,'2016-09-06','Abono a la cuenta de : Vicente Israel Sotomayor Viñan',10),(3555,1,'2016-09-06','Abono a la cuenta de : Vicente Israel Sotomayor Viñan',5),(3603,0,'2016-09-06','Abono a la cuenta de: Vicente Israel Sotomayor Viñan',30),(3605,1,'2016-09-06','Préstamo al cliente: Vicente Israel Sotomayor Viñan',5),(3655,0,'2016-09-06','Anticipo de la orden de trabajo Nro.: 15',10),(3702,1,'2016-09-07','Compra de vinil mate',200),(3753,0,'2016-09-07','Anticipo de la orden de trabajo Nro.: 15',10),(3953,0,'2016-09-10','Abono a la cuenta de: Julio Galán',30),(3955,1,'2016-09-10','Préstamo al cliente: Julio Galán',10),(4004,0,'2016-09-12','Anticipo de la orden de trabajo Nro.: 16',0),(5053,1,'2016-09-26','Factura de compra de: Andres Glovino',80),(5102,0,'2016-09-26','Se elimino el anticipo de sueldo de: Juan Ruilova',10),(5152,1,'2016-09-26','Anticipo de sueldo de: Juan Ruilova',9),(5202,1,'2016-09-26','Anticipo de sueldo de: Juan Ruilova',10),(5252,1,'2016-09-26','Anticipo de sueldo de: Juan Ruilova',7),(5302,1,'2016-09-26','Anticipo de sueldo de: Juan Ruilova',12),(5353,1,'2016-09-30','Anticipo de sueldo de: Juan Ruilova',4),(5403,0,'2016-09-30','Se elimino el anticipo de sueldo de: Juan Ruilova',2),(5405,1,'2016-09-30','Anticipo de sueldo de: Juan Ruilova',3),(5453,0,'2016-09-30','Se elimino el anticipo de sueldo de: Juan Ruilova',1),(5503,1,'2016-09-30','Anticipo de sueldo de: Juan Ruilova',1),(5504,0,'2016-09-30','Se elimino el anticipo de sueldo de: Juan Ruilova',1),(5506,1,'2016-09-30','Anticipo de sueldo de: Juan Ruilova',1),(5553,1,'2016-10-01','Anticipo de sueldo de: Juan Ruilova',30);

/*Table structure for table `activity` */

DROP TABLE IF EXISTS `activity`;

CREATE TABLE `activity` (
  `activity_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `act_created_date` datetime DEFAULT NULL,
  `act_description` text,
  `history_idhistory` bigint(11) NOT NULL,
  PRIMARY KEY (`activity_id`),
  KEY `fk_activity_history1_idx` (`history_idhistory`),
  CONSTRAINT `fk_activity_history1` FOREIGN KEY (`history_idhistory`) REFERENCES `history` (`history_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `activity` */

/*Table structure for table `buy_invoice` */

DROP TABLE IF EXISTS `buy_invoice`;

CREATE TABLE `buy_invoice` (
  `buy_invoice_id` bigint(11) NOT NULL,
  `bin_number` varchar(45) DEFAULT NULL,
  `bin_reference` varchar(45) DEFAULT NULL,
  `bin_date` date DEFAULT NULL,
  `bin_description` text,
  `bin_total` double(10,2) DEFAULT NULL,
  `bin_supplier_person_id` bigint(11) NOT NULL,
  PRIMARY KEY (`buy_invoice_id`),
  KEY `fk_buy_invoice_person1_idx` (`bin_supplier_person_id`),
  CONSTRAINT `fk_buy_invoice_person1` FOREIGN KEY (`bin_supplier_person_id`) REFERENCES `person` (`person_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `buy_invoice` */

insert  into `buy_invoice`(`buy_invoice_id`,`bin_number`,`bin_reference`,`bin_date`,`bin_description`,`bin_total`,`bin_supplier_person_id`) values (4752,'123124','asdagqw','2016-09-22','Compra de vinil  transparente',130.00,0),(4853,'23123','asdasd','2016-09-22','asdasd',80.00,4802),(4854,'23123','FSDFSDF','2016-09-22','asdasd',90.00,4803),(4902,'324234','SDFSDF','2016-09-22','SDFSDFSGDFGSFSDFADASD',80.00,453),(4952,'123123','fgdfg','2016-09-22','daasdasd',80.00,4802),(5003,'2324','sdfsh','2016-09-23','vompra de asdkaspdjaosdjaosf',100.00,4802),(5052,'23423','sad','2016-09-26','Compra de esferos',80.00,4803);

/*Table structure for table `closing_cash` */

DROP TABLE IF EXISTS `closing_cash`;

CREATE TABLE `closing_cash` (
  `closing_cash_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `cc_date_from` date DEFAULT NULL,
  `cc_date_to` date DEFAULT NULL,
  `cc_initial_cash_value` double(10,2) DEFAULT NULL,
  `cc_total_cash` double(10,2) DEFAULT NULL,
  `cc_total_cheks` double(10,2) DEFAULT NULL,
  `cc_total_credit_card` double(10,2) DEFAULT NULL,
  `cc_total_debit_card` double(10,2) DEFAULT '0.00',
  `cc_total_inflow` double(10,2) DEFAULT '0.00',
  `cc_total_outflow` double(10,2) DEFAULT '0.00',
  `cc_total_receivable_accounts` double(10,2) DEFAULT '0.00',
  `cc_total` double(10,2) DEFAULT '0.00',
  `cc_observation` text,
  PRIMARY KEY (`closing_cash_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `closing_cash` */

/*Table structure for table `detail` */

DROP TABLE IF EXISTS `detail`;

CREATE TABLE `detail` (
  `detail_id` bigint(20) NOT NULL,
  `det_type` varchar(20) DEFAULT NULL,
  `det_description` varchar(100) DEFAULT NULL,
  `det_sale_price` double(10,2) DEFAULT NULL,
  `det_quantity` double(10,2) DEFAULT NULL,
  `det_total` double(10,2) DEFAULT NULL,
  `invoice_invoice_id` bigint(20) DEFAULT NULL,
  `sellnote_sell_note_id` bigint(20) DEFAULT NULL,
  `product_product_id` bigint(11) DEFAULT NULL,
  `petition_petition_id` bigint(11) DEFAULT NULL,
  `work_order_work_order_id` bigint(11) DEFAULT NULL,
  `det_quotation_id` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`detail_id`),
  KEY `fk_detail_invoice1_idx` (`invoice_invoice_id`),
  KEY `fk_detail_sellnote1_idx` (`sellnote_sell_note_id`),
  KEY `fk_detail_product1_idx` (`product_product_id`),
  KEY `fk_detail_petition1_idx` (`petition_petition_id`),
  KEY `fk_detail_work_order1_idx` (`work_order_work_order_id`),
  KEY `fk_detail_quotation1_idx` (`det_quotation_id`),
  CONSTRAINT `fk_detail_invoice1` FOREIGN KEY (`invoice_invoice_id`) REFERENCES `invoice` (`invoice_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detail_petition1` FOREIGN KEY (`petition_petition_id`) REFERENCES `petition` (`petition_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detail_product1` FOREIGN KEY (`product_product_id`) REFERENCES `product` (`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detail_quotation1` FOREIGN KEY (`det_quotation_id`) REFERENCES `quotation` (`quotation_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detail_sellnote1` FOREIGN KEY (`sellnote_sell_note_id`) REFERENCES `sellnote` (`sell_note_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detail_work_order1` FOREIGN KEY (`work_order_work_order_id`) REFERENCES `work_order` (`work_order_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `detail` */

insert  into `detail`(`detail_id`,`det_type`,`det_description`,`det_sale_price`,`det_quantity`,`det_total`,`invoice_invoice_id`,`sellnote_sell_note_id`,`product_product_id`,`petition_petition_id`,`work_order_work_order_id`,`det_quotation_id`) values (3103,'WorkOrderDetail','Impresion Lona 4x10 m2',280.00,1.00,280.00,NULL,NULL,NULL,NULL,3102,NULL),(3111,'WorkOrderDetail','Impresion Lona 0.60x2 m2',8.40,1.00,8.40,NULL,NULL,NULL,NULL,3110,NULL),(3206,'WorkOrderDetail','Impresion Lona 3x4 m2',84.00,1.00,84.00,NULL,NULL,NULL,NULL,3205,NULL),(3209,'WorkOrderDetail','Impresion Lona 0.80x2 m2',11.20,1.00,11.20,NULL,NULL,NULL,NULL,3205,NULL),(3253,'WorkOrderDetail','Impresion Lona 3x4 m2',84.00,1.00,84.00,NULL,NULL,NULL,NULL,3252,NULL),(3357,'WorkOrderDetail','Corte Láser',0.30,1.00,0.30,NULL,NULL,NULL,NULL,3356,NULL),(3358,'WorkOrderDetail','Impresion Vinil 2x4 m2',64.00,1.00,64.00,NULL,NULL,NULL,NULL,3356,NULL),(3653,'WorkOrderDetail','Impresion Lona 2x3 m2',42.00,1.00,42.00,NULL,NULL,NULL,NULL,3652,NULL),(3752,'WorkOrderDetail','Impresion Lona 0.50x2 m2',7.00,1.00,7.00,NULL,NULL,NULL,NULL,3652,NULL),(3803,'QuotationDetail','Impresion Lona 2x3 m2',42.00,1.00,42.00,NULL,NULL,NULL,NULL,NULL,3802),(3852,'WorkOrderDetail','Impresion Vinil 0.2x0.3 m2',0.48,1.00,0.48,NULL,NULL,NULL,NULL,3652,NULL),(3853,'WorkOrderDetail','Impresion Vinil 0.80x0.50 m2',3.20,1.00,3.20,NULL,NULL,NULL,NULL,3652,NULL),(3902,'WorkOrderDetail','Impresion Vinil 0.30x0.90 m2',2.16,1.00,2.16,NULL,NULL,NULL,NULL,3652,NULL),(4003,'WorkOrderDetail','Impresion Lona 0.20x0.80 m2',1.12,1.00,1.12,NULL,NULL,NULL,NULL,4002,NULL);

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `employee_id` bigint(11) NOT NULL,
  `emp_job` varchar(45) DEFAULT NULL,
  `emp_hire_date` date DEFAULT NULL,
  `emp_departure_date` date DEFAULT NULL,
  `emp_first_name` varchar(100) DEFAULT NULL,
  `emp_last_name` varchar(100) DEFAULT NULL,
  `emp_address` text,
  `emp_email` varchar(45) DEFAULT NULL,
  `emp_phone` varchar(30) DEFAULT NULL,
  `emp_identification` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

insert  into `employee`(`employee_id`,`emp_job`,`emp_hire_date`,`emp_departure_date`,`emp_first_name`,`emp_last_name`,`emp_address`,`emp_email`,`emp_phone`,`emp_identification`) values (1,'Vendedor','2016-09-12',NULL,'Juan','Ruilova','Lojana de Turismo','isra@gmail.com','2579413','1102074679'),(4052,'Instalador','2016-09-12',NULL,'Vicente Israel','Sotomayor Viñan','Avenida Gran Colombia','isra19862008@gmail.com','25794163','1104330715'),(4202,'Instalador','2016-09-12',NULL,'Maria Jimena ','Ochoa Cueva','Av Cuxibamba y Latacunga','isra19862008@hotmail.com','2580879','1104330715'),(4252,'Instalador','2016-09-12',NULL,'Jimena','Deep','Av Cuxibamba y Latacunga','isra19862008@hotmail.com','2580879','1104330715');

/*Table structure for table `enterprise` */

DROP TABLE IF EXISTS `enterprise`;

CREATE TABLE `enterprise` (
  `enterprise_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `enterprise_name` varchar(32) DEFAULT NULL,
  `enterprise_ruc` varchar(32) DEFAULT NULL,
  `enterprise_description` text,
  `enterprise_type` varchar(32) DEFAULT NULL,
  `enterprise_first_facture_number` int(11) DEFAULT NULL,
  `enterprise_first_facture_number1` int(11) DEFAULT NULL,
  `enterprise_first_facture_number2` int(11) DEFAULT NULL,
  PRIMARY KEY (`enterprise_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `enterprise` */

/*Table structure for table `history` */

DROP TABLE IF EXISTS `history`;

CREATE TABLE `history` (
  `history_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `his_created_date` datetime DEFAULT NULL,
  `his_type` varchar(45) DEFAULT NULL,
  `id_user_account` bigint(11) NOT NULL,
  PRIMARY KEY (`history_id`),
  KEY `fk_history_user_account1_idx` (`id_user_account`),
  CONSTRAINT `fk_history_user_account1` FOREIGN KEY (`id_user_account`) REFERENCES `user_account` (`user_account_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `history` */

/*Table structure for table `invoice` */

DROP TABLE IF EXISTS `invoice`;

CREATE TABLE `invoice` (
  `invoice_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `in_subtotal` double(10,2) DEFAULT NULL,
  `in_discount` double(10,2) DEFAULT NULL,
  `in_subtotal_ivazero` double(10,2) DEFAULT '0.00',
  `in_subtotal_iva` double(10,2) DEFAULT '0.00',
  `in_iva` double(10,2) DEFAULT NULL,
  `in_total` double(10,2) DEFAULT NULL,
  `in_change` double(10,2) DEFAULT NULL,
  `in_cash` double(10,2) DEFAULT NULL,
  `in_authorization_date` date DEFAULT NULL,
  `in_issue_time` time DEFAULT NULL,
  `in_number` varchar(10) DEFAULT NULL,
  `in_issue_date` date DEFAULT NULL,
  `in_state` varchar(20) DEFAULT NULL,
  `invoice_count` int(11) DEFAULT '1',
  `in_petition_name` varchar(20) DEFAULT NULL,
  `person_person_id` bigint(11) NOT NULL,
  PRIMARY KEY (`invoice_id`),
  KEY `fk_invoice_person1_idx` (`person_person_id`),
  CONSTRAINT `fk_invoice_person1` FOREIGN KEY (`person_person_id`) REFERENCES `person` (`person_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `invoice` */

/*Table structure for table `payroll` */

DROP TABLE IF EXISTS `payroll`;

CREATE TABLE `payroll` (
  `payroll_id` bigint(11) NOT NULL,
  `pr_worked_days` int(11) DEFAULT NULL,
  `pr_basic_salary` double(10,2) DEFAULT NULL,
  `pr_extra_hours` double(10,2) DEFAULT NULL,
  `pr_thirtheen_salary` double(10,2) DEFAULT NULL,
  `pr_fourtteenth_salary` double(10,2) DEFAULT NULL,
  `pr_other_income` double(10,2) DEFAULT NULL,
  `pr_total_income` double(10,2) DEFAULT NULL,
  `pr_iess_contribution` double(10,2) DEFAULT NULL,
  `pr_salary_advance` double(10,2) DEFAULT NULL,
  `pr_total_salary` double(10,2) DEFAULT NULL,
  `pr_employee_id` bigint(11) NOT NULL,
  PRIMARY KEY (`payroll_id`),
  KEY `fk_payroll_employee1_idx` (`pr_employee_id`),
  CONSTRAINT `fk_payroll_employee1` FOREIGN KEY (`pr_employee_id`) REFERENCES `employee` (`employee_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `payroll` */

/*Table structure for table `person` */

DROP TABLE IF EXISTS `person`;

CREATE TABLE `person` (
  `person_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `pr_type` varchar(30) DEFAULT NULL,
  `pr_first_name` varchar(100) DEFAULT NULL,
  `pr_last_name` varchar(100) DEFAULT NULL,
  `pr_address` text,
  `pr_email` varchar(100) DEFAULT NULL,
  `pr_phone` varchar(30) DEFAULT NULL,
  `pr_identification` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4804 DEFAULT CHARSET=utf8;

/*Data for the table `person` */

insert  into `person`(`person_id`,`pr_type`,`pr_first_name`,`pr_last_name`,`pr_address`,`pr_email`,`pr_phone`,`pr_identification`) values (1,'Empleado','Eyetive Agencia','Creativa Digital','Av. Gran Colombia 0308 y Guaranda','info@eyetive.com','072579413','1104330715001'),(52,'Publicista','Vicente Israel','Sotomayor Viñan','Av. Cuxibamba y Latacunga','israel.sotomayor@eyetive.com','2580879','1104330715'),(452,'Cliente','Juan Carlos','Ortega Roman','Av. Gran Colombia 0308','isra19862008@gmail.com','2579413','1102074679'),(453,'Proveedor','Carlos David','Pardo Ochoa','Gran Colombia 0308','ingo@gmail.com','2579413','1102074676'),(1002,'Publicista','Julio','Galán','Loja','','0990221936','1104140650'),(1052,'Cliente','Carlos ','Andrade','Loja','','2579413','1102074675'),(4006,'Empleado','Juan Carlos','Petardo Andrade','Lojano de Turismo','juan@gmail.com','2579413','1102074679'),(4802,'Proveedor','Brad','Pitt','Los Angeles','brad@gmail.com','2579413','1104330765001'),(4803,'Proveedor','Andres','Glovino','Terminal','','2579413','1102074679001');

/*Table structure for table `petition` */

DROP TABLE IF EXISTS `petition`;

CREATE TABLE `petition` (
  `petition_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `pt_name` varchar(32) DEFAULT NULL,
  `pt_issue_date` date DEFAULT NULL,
  `pt_state` tinyint(1) DEFAULT '0',
  `pt_total` double(10,2) DEFAULT NULL,
  `person_person_id` bigint(11) NOT NULL,
  PRIMARY KEY (`petition_id`),
  KEY `fk_order_person1_idx` (`person_person_id`),
  CONSTRAINT `fk_order_person1` FOREIGN KEY (`person_person_id`) REFERENCES `person` (`person_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `petition` */

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `product_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `pd_description` varchar(100) DEFAULT NULL,
  `pd_sale_price` double(10,2) DEFAULT NULL,
  `pd_name` varchar(100) DEFAULT NULL,
  `pd_code` varchar(100) DEFAULT NULL,
  `pd_barcode` varchar(100) DEFAULT NULL,
  `pd_iva_state` int(2) DEFAULT NULL,
  `pd_stock` double(10,2) DEFAULT NULL,
  `pd_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

/*Data for the table `product` */

insert  into `product`(`product_id`,`pd_description`,`pd_sale_price`,`pd_name`,`pd_code`,`pd_barcode`,`pd_iva_state`,`pd_stock`,`pd_type`) values (53,'Impresion Lona',14.00,'Impresion Lona','','scb',0,1.00,'mi');

/*Table structure for table `quotation` */

DROP TABLE IF EXISTS `quotation`;

CREATE TABLE `quotation` (
  `quotation_id` bigint(11) NOT NULL,
  `qo_number` varchar(45) DEFAULT NULL,
  `qo_date` date DEFAULT NULL,
  `qo_subtotal` double(10,2) DEFAULT NULL,
  `qo_iva` double(10,2) DEFAULT NULL,
  `qo_total` double(10,2) DEFAULT NULL,
  `qo_work_order_state` int(2) DEFAULT '0',
  `qo_invoice_state` int(2) DEFAULT '0',
  `qo_person_id` bigint(11) NOT NULL,
  PRIMARY KEY (`quotation_id`),
  KEY `fk_quotation_person1_idx` (`qo_person_id`),
  CONSTRAINT `fk_quotation_person1` FOREIGN KEY (`qo_person_id`) REFERENCES `person` (`person_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `quotation` */

insert  into `quotation`(`quotation_id`,`qo_number`,`qo_date`,`qo_subtotal`,`qo_iva`,`qo_total`,`qo_work_order_state`,`qo_invoice_state`,`qo_person_id`) values (3802,'2','2016-09-07',42.00,5.04,47.04,NULL,NULL,52);

/*Table structure for table `receivable_account` */

DROP TABLE IF EXISTS `receivable_account`;

CREATE TABLE `receivable_account` (
  `receivable_account_id` bigint(11) NOT NULL,
  `ra_count` int(100) DEFAULT '1',
  `ra_date` date DEFAULT NULL,
  `ra_update_date` date DEFAULT NULL,
  `ra_total` double(10,2) DEFAULT NULL,
  `ra_person_id` bigint(11) NOT NULL,
  PRIMARY KEY (`receivable_account_id`),
  KEY `fk_receivable_account_person1_idx` (`ra_person_id`),
  CONSTRAINT `fk_receivable_account_person1` FOREIGN KEY (`ra_person_id`) REFERENCES `person` (`person_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `receivable_account` */

insert  into `receivable_account`(`receivable_account_id`,`ra_count`,`ra_date`,`ra_update_date`,`ra_total`,`ra_person_id`) values (1804,3,'2016-09-12','2016-09-12',103.12,52),(3254,1,'2016-09-05','2016-09-10',85.30,1002);

/*Table structure for table `rol` */

DROP TABLE IF EXISTS `rol`;

CREATE TABLE `rol` (
  `rol_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `rol_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`rol_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `rol` */

insert  into `rol`(`rol_id`,`rol_name`) values (1,'SuperAdmin'),(2,'Administrator');

/*Table structure for table `salary` */

DROP TABLE IF EXISTS `salary`;

CREATE TABLE `salary` (
  `salary_id` bigint(11) NOT NULL,
  `sa_date` date DEFAULT NULL,
  `sa_value` double(10,2) DEFAULT NULL,
  `sa_state` int(2) DEFAULT NULL,
  `sa_balance` double(10,2) DEFAULT NULL,
  `sa_update_date` date DEFAULT NULL,
  `sa_employee_id` bigint(11) NOT NULL,
  PRIMARY KEY (`salary_id`),
  KEY `fk_salary_employee1_idx` (`sa_employee_id`),
  CONSTRAINT `fk_salary_employee1` FOREIGN KEY (`sa_employee_id`) REFERENCES `employee` (`employee_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `salary` */

insert  into `salary`(`salary_id`,`sa_date`,`sa_value`,`sa_state`,`sa_balance`,`sa_update_date`,`sa_employee_id`) values (4005,'2016-09-12',470.00,1,0.00,NULL,1),(4102,'2016-09-12',800.00,0,570.00,NULL,4052);

/*Table structure for table `salary_payment` */

DROP TABLE IF EXISTS `salary_payment`;

CREATE TABLE `salary_payment` (
  `salary_payment_id` bigint(11) NOT NULL,
  `spa_value` double(10,2) DEFAULT NULL,
  `spa_date` date DEFAULT NULL,
  `spa_description` varchar(150) DEFAULT NULL,
  `spa_observation` varchar(45) DEFAULT NULL,
  `spa_salary_id` bigint(11) NOT NULL,
  PRIMARY KEY (`salary_payment_id`),
  KEY `fk_salary_payment_salary1_idx` (`spa_salary_id`),
  CONSTRAINT `fk_salary_payment_salary1` FOREIGN KEY (`spa_salary_id`) REFERENCES `salary` (`salary_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `salary_payment` */

insert  into `salary_payment`(`salary_payment_id`,`spa_value`,`spa_date`,`spa_description`,`spa_observation`,`spa_salary_id`) values (4103,200.00,'2016-09-12','',NULL,4102),(4152,30.00,'2016-09-12','',NULL,4102),(4153,90.00,'2016-09-13','Adelanto sueldo semana 1',NULL,4102),(4302,30.00,'2016-09-12','Adelanto semana 1',NULL,4005),(4303,20.00,'2016-09-12','',NULL,4005),(4352,40.00,'2016-09-12','Adelanto semana 2',NULL,4005),(4353,30.00,'2016-09-12','Adelanto semana 3',NULL,4005),(4354,30.00,'2016-09-12','Adelanto semana 4',NULL,4005),(4402,80.00,'2016-09-12','Adelanto Semana 5',NULL,4005),(4452,90.00,'2016-09-13','',NULL,4005),(4552,30.00,'2016-09-13','adelanto semana 8',NULL,4005),(4602,20.00,'2016-09-13','Pago de sueldo',NULL,4005),(4652,50.00,'2016-09-14','Adelanto de pago',NULL,4005),(4653,30.00,'2016-09-14','kkhfg',NULL,4005),(5303,12.00,'2016-09-26','Nuevo pago',NULL,4005),(5354,4.00,'2016-09-30','prueba',NULL,4005),(5404,3.00,'2016-09-30','hkhjkj',NULL,4005),(5505,1.00,'2016-09-30','asdasd',NULL,4005),(5552,30.00,'2016-10-01','dasdasd','asdasdasd',4005);

/*Table structure for table `sellnote` */

DROP TABLE IF EXISTS `sellnote`;

CREATE TABLE `sellnote` (
  `sell_note_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sn_type` varchar(20) DEFAULT NULL,
  `sn_issue_date` date DEFAULT NULL,
  `sn_payment_method` int(11) DEFAULT NULL,
  `sn_number` varchar(20) DEFAULT NULL,
  `sn_state` varchar(20) DEFAULT NULL,
  `sn_total` double(10,2) DEFAULT NULL,
  `sn_advance` double(10,2) DEFAULT NULL,
  `sn_balance` double(10,2) DEFAULT NULL,
  `person_person_id` bigint(11) NOT NULL,
  PRIMARY KEY (`sell_note_id`),
  KEY `fk_sellnote_person1_idx` (`person_person_id`),
  CONSTRAINT `fk_sellnote_person1` FOREIGN KEY (`person_person_id`) REFERENCES `person` (`person_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sellnote` */

/*Table structure for table `sequence` */

DROP TABLE IF EXISTS `sequence`;

CREATE TABLE `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `sequence` */

insert  into `sequence`(`SEQ_NAME`,`SEQ_COUNT`) values ('SEQ_GEN','5601');

/*Table structure for table `setting` */

DROP TABLE IF EXISTS `setting`;

CREATE TABLE `setting` (
  `setting_id` bigint(11) NOT NULL,
  `pr_first_invoice_number` varchar(25) DEFAULT NULL,
  `pr_iva_value` double(10,2) DEFAULT NULL,
  `pr_second_invoice_number` varchar(25) DEFAULT NULL,
  `pr_third_invoice_number` varchar(25) DEFAULT NULL,
  `pr_quotation_number` int(11) DEFAULT NULL,
  `pr_work_order_number` int(11) DEFAULT NULL,
  `pr_accuracy_value` int(5) DEFAULT NULL,
  `pr_authorization_number` varchar(25) DEFAULT NULL,
  `pr_show_print_preview` tinyint(1) DEFAULT NULL,
  `pr_simple_service_value` int(11) DEFAULT NULL,
  `pr_medium_service_value` int(11) DEFAULT NULL,
  `pr_complex_service_value` int(11) DEFAULT NULL,
  `pr_publicist_finished_discount_value` int(11) DEFAULT NULL,
  `pr_publicist_print_discount_value` int(11) DEFAULT NULL,
  `pr_publicist_service_discount_value` int(11) DEFAULT NULL,
  `pr_personal_insurance_contribution` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`setting_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `setting` */

insert  into `setting`(`setting_id`,`pr_first_invoice_number`,`pr_iva_value`,`pr_second_invoice_number`,`pr_third_invoice_number`,`pr_quotation_number`,`pr_work_order_number`,`pr_accuracy_value`,`pr_authorization_number`,`pr_show_print_preview`,`pr_simple_service_value`,`pr_medium_service_value`,`pr_complex_service_value`,`pr_publicist_finished_discount_value`,`pr_publicist_print_discount_value`,`pr_publicist_service_discount_value`,`pr_personal_insurance_contribution`) values (2,'001',14.00,'001','5',3,17,2,'',0,0,0,0,0,50,0,'9.45');

/*Table structure for table `user_account` */

DROP TABLE IF EXISTS `user_account`;

CREATE TABLE `user_account` (
  `user_account_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `usr_name` varchar(45) DEFAULT NULL,
  `usr_password` varchar(45) DEFAULT NULL,
  `rol_idrol` bigint(11) NOT NULL,
  `usr_employee_id` bigint(11) NOT NULL,
  PRIMARY KEY (`user_account_id`),
  KEY `fk_user_rol1_idx` (`rol_idrol`),
  KEY `fk_user_account_employee1_idx` (`usr_employee_id`),
  CONSTRAINT `fk_user_account_employee1` FOREIGN KEY (`usr_employee_id`) REFERENCES `employee` (`employee_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_rol1` FOREIGN KEY (`rol_idrol`) REFERENCES `rol` (`rol_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user_account` */

insert  into `user_account`(`user_account_id`,`usr_name`,`usr_password`,`rol_idrol`,`usr_employee_id`) values (1,'eyetive','123',1,1);

/*Table structure for table `work_order` */

DROP TABLE IF EXISTS `work_order`;

CREATE TABLE `work_order` (
  `work_order_id` bigint(11) NOT NULL,
  `wo_state` int(2) DEFAULT NULL,
  `wo_count` int(11) DEFAULT '1',
  `wo_number` varchar(45) DEFAULT NULL,
  `wo_issue_date` date DEFAULT NULL,
  `wo_delivery_date` date DEFAULT NULL,
  `wo_total` double(10,2) DEFAULT NULL,
  `wo_balance` double(10,2) DEFAULT NULL,
  `wo_advance` double(10,2) DEFAULT NULL,
  `wo_subtotal` double(10,2) DEFAULT NULL,
  `wo_discount` double(10,2) DEFAULT NULL,
  `wo_iva` double(10,2) DEFAULT NULL,
  `wo_change` double(10,2) DEFAULT '0.00',
  `wo_cash` double(10,2) DEFAULT '0.00',
  `wo_invoice_state` int(2) DEFAULT '0',
  `wo_quotation_state` int(2) DEFAULT '0',
  `wo_payment_state` int(2) DEFAULT '1',
  `person_person_id` bigint(11) NOT NULL,
  `wo_employee_id` bigint(11) NOT NULL,
  PRIMARY KEY (`work_order_id`),
  KEY `fk_work_order_person1_idx` (`person_person_id`),
  KEY `fk_work_order_employee1_idx` (`wo_employee_id`),
  CONSTRAINT `fk_work_order_employee1` FOREIGN KEY (`wo_employee_id`) REFERENCES `employee` (`employee_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_work_order_person1` FOREIGN KEY (`person_person_id`) REFERENCES `person` (`person_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `work_order` */

insert  into `work_order`(`work_order_id`,`wo_state`,`wo_count`,`wo_number`,`wo_issue_date`,`wo_delivery_date`,`wo_total`,`wo_balance`,`wo_advance`,`wo_subtotal`,`wo_discount`,`wo_iva`,`wo_change`,`wo_cash`,`wo_invoice_state`,`wo_quotation_state`,`wo_payment_state`,`person_person_id`,`wo_employee_id`) values (3102,1,1,'10','2016-09-05','2016-09-05',313.60,313.60,0.00,280.00,0.00,33.60,0.00,0.00,0,0,1,52,1),(3110,1,2,'11','2016-09-05','2016-09-05',8.40,8.40,0.00,8.40,0.00,0.00,0.00,0.00,0,0,1,52,1),(3205,1,3,'12','2016-09-05','2016-09-05',95.20,95.20,0.00,95.20,0.00,0.00,0.00,0.00,0,0,1,52,1),(3252,1,1,'13','2016-09-05','2016-09-05',84.00,84.00,0.00,84.00,0.00,0.00,0.00,0.00,0,0,1,1002,1),(3356,1,1,'14','2016-09-05','2016-09-05',64.30,34.30,30.00,64.30,0.00,0.00,0.00,30.00,0,0,1,1002,1),(3652,1,3,'15','2016-09-06','2016-09-06',54.84,44.84,10.00,54.84,0.00,0.00,0.00,10.00,0,0,1,52,1),(4002,1,3,'16','2016-09-12','2016-09-12',1.12,1.12,0.00,1.12,0.00,0.00,0.00,0.00,0,0,1,52,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

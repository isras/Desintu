package controller.resources;



import javax.swing.JOptionPane;


public class Message {

//    public static void exit(Principal p,User user, int minutos,int segundos,String text) {
//        int n = JOptionPane.showConfirmDialog(null, "Desea salir del sistema", "PIRAMIHEAD", JOptionPane.YES_NO_OPTION);        
//        if (n == JOptionPane.YES_OPTION) {            
//            if(!LecturaDeArchivos.dirExiste("config/sysSetting/systemf.dll")){
//                System.exit(0);
//            }            
//            List<String> vs = LecturaDeArchivos.leerArchivo("config/sysSetting/systemf.dll");
//            if(vs.isEmpty()){
//                System.exit(0);
//            }            
//            BaseDeDatosUCC.respaldoAutomaticoBD(p,2,user);
//            if (!vs.get(0).equals("active")) {
//                vs.set(1, minutos + "");
//                vs.set(2, segundos + "");
//                LecturaDeArchivos.escribirArchivo("config/sysSetting/systemf.dll", vs);
//                JOptionPane.showMessageDialog(null, "RECUERDE QUE ESTÁ UTILIZANDO UNA VERSIÓN DE PRUEBA\nPARA OBTENER EL PRODUCTO COMPLETO\nCOMUNÍQUESE CON EL ADMINISTRADOR DEL SW.\nDIR. 10 de Agosto y Bolívar esquina 2do Piso\nOFICINA GOOTLEK.", "DEMO", JOptionPane.INFORMATION_MESSAGE);
//            }
//            System.exit(0);
//        }
//    }

    public static void invalidImage() {
        JOptionPane.showMessageDialog(null, "Formato de imagen no válida", "EYETIVE", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void seleccionarFila() {
        JOptionPane.showMessageDialog(null, "Seleccione una fila de la tabla", "EYETIVE", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void seleccionarFila(String ubicacion) {
        JOptionPane.showMessageDialog(null, "Seleccione un(a) " + ubicacion + " de la tabla", "EYETIVE", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void guardado(String object) {
        JOptionPane.showMessageDialog(null, object + " guardado...", "EYETIVE", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void editado() {
        JOptionPane.showMessageDialog(null, "Editado...", "EYETIVE", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void errorAl(String s) {
        JOptionPane.showMessageDialog(null, "Error al " + s + "...", "EYETIVE", JOptionPane.ERROR_MESSAGE);
    }

    public static void emptyCamps(String s) {
        JOptionPane.showMessageDialog(null, "Existen campos oligatorios vacios: " + s, "EYETIVE", JOptionPane.ERROR_MESSAGE);
    }

    public static void selectIdentification() {
        JOptionPane.showMessageDialog(null, "Seleccione un tipo de identificación", "EYETIVE", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void incorrectReferrer() {
        JOptionPane.showMessageDialog(null, "Contacto referencial incorrecto.", "EYETIVE", JOptionPane.ERROR_MESSAGE);
    }

    public static void identificacionIncorrecta() {
        JOptionPane.showMessageDialog(null, "La identificación ingresada es incorrecta", "EYETIVE", JOptionPane.ERROR_MESSAGE);
    }

    public static void incorrectValue() {
        JOptionPane.showMessageDialog(null, "Valor Incorrecto", "EYETIVE", JOptionPane.ERROR_MESSAGE);
    }

    public static void incorrectCodeBar() {
        JOptionPane.showMessageDialog(null, "Código de barras incorrecto", "EYETIVE", JOptionPane.ERROR_MESSAGE);
    }

    public static void incorrectGroup() {
        JOptionPane.showMessageDialog(null, "Grupo incorrecto", "EYETIVE", JOptionPane.ERROR_MESSAGE);
    }

    public static void incorrectUnitsBox() {
        JOptionPane.showMessageDialog(null, "Unidades por caja, incorrecto", "EYETIVE", JOptionPane.ERROR_MESSAGE);
    }

    public static void incorrectCombo() {
        JOptionPane.showMessageDialog(null, "Combo incorrecto", "EYETIVE", JOptionPane.ERROR_MESSAGE);
    }

    public static void seleccionarCombo() {
        JOptionPane.showMessageDialog(null, "Debe seleccionar un Combo válido", "EYETIVE", JOptionPane.ERROR_MESSAGE);
    }

    public static void invalidPrice() {
        JOptionPane.showMessageDialog(null, "Ingrese solo números", "EYETIVE", JOptionPane.ERROR_MESSAGE);
    }

    public static void repeatCode() {
        JOptionPane.showMessageDialog(null, "Código repetido", "EYETIVE", JOptionPane.ERROR_MESSAGE);
    }

    public static void eliminado() {
        JOptionPane.showMessageDialog(null, "Eliminado...", "EYETIVE", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void cantidadIncorrecta() {
        JOptionPane.showMessageDialog(null, "Debe ingresar una cantidad correcta", "EYETIVE", JOptionPane.ERROR_MESSAGE);
    }

    public static void sinMainEnterprise() {
        JOptionPane.showMessageDialog(null, "Se debe crear una empresa que\nadministre todas las actividades", "EYETIVE", JOptionPane.ERROR_MESSAGE);
    }

    public static void sin(String s) {
        JOptionPane.showMessageDialog(null, "Sin "+s, "EYETIVE", JOptionPane.ERROR_MESSAGE);
    }

    public static void sinItems() {
        JOptionPane.showMessageDialog(null, "La factura está vacía", "EYETIVE", JOptionPane.ERROR_MESSAGE);
    }

    public static void sinProductos(String lugar) {
        JOptionPane.showMessageDialog(null, "No hay productos en el/la " + lugar, "EYETIVE", JOptionPane.ERROR_MESSAGE);
    }

    public static void noPuedeInventarioInicial() {
        JOptionPane.showMessageDialog(null, "Está opción ya no está disponible", "EYETIVE", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void incorrectCode() {
        JOptionPane.showMessageDialog(null, "Código incorrecto, es posible q esté repetido", "EYETIVE", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void ingreseDireccion() {
        JOptionPane.showMessageDialog(null, "Ingrese al menos una dirección", "EYETIVE", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void fechasIncorrectas() {
        JOptionPane.showMessageDialog(null, "Las fechas ingresadas son incorrectas", "EYETIVE", JOptionPane.ERROR_MESSAGE);
    }

    public static void sinNotaDeVenta() {
        JOptionPane.showMessageDialog(null, "La nota de venta seleccionada,\nno tiene reporte de impresión", "EYETIVE", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void supplierIncorrecto() {
        JOptionPane.showMessageDialog(null, "Ingrese un proveedor correcto", "EYETIVE", JOptionPane.ERROR_MESSAGE);
    }

    public static void messageSave() {
        JOptionPane.showMessageDialog(null, "Se ha Guardado Correctamente",
                "Mensaje de Informacion", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void errorReport() {
        JOptionPane.showMessageDialog(null, "No se ha podido Generar el Reporte", "EYETIVE", JOptionPane.ERROR_MESSAGE);
    }

    public static void consumidorFinal() {
        JOptionPane.showMessageDialog(null, "No se puede referenciar al CONSUMIDOR FINAL", "EYETIVE", JOptionPane.ERROR_MESSAGE);
    }

    public static boolean confirmOption(String pregunta) {
        int n = JOptionPane.showConfirmDialog(null, pregunta, "Armoire 2015", JOptionPane.YES_NO_OPTION);
        return n==JOptionPane.YES_OPTION;        
    }

    public static void employeInUse(String departament) {
        JOptionPane.showMessageDialog(null, "El empleado ya está asignado al departamento\n" + departament, "EYETIVE", JOptionPane.ERROR_MESSAGE);
    }

    public static void incorrectPassword() {
        JOptionPane.showMessageDialog(null, "PASSWORD INCORRECTO", "EYETIVE", JOptionPane.ERROR_MESSAGE);
    }

    public static void incorrectUser() {
        JOptionPane.showMessageDialog(null, "NOMBRE DE USUARIO O PASSWORD INCORRECTO", "EYETIVE", JOptionPane.ERROR_MESSAGE);
    }

    public static void fechaNacimientoIncorrecta() {
        JOptionPane.showMessageDialog(null, "Fecha de nacimiento incorrecta", "EYETIVE", JOptionPane.ERROR_MESSAGE);
    }

    public static void totalInvalido() {
        JOptionPane.showMessageDialog(null, "El total debe sobrepasar los 20 dolares\npara poder realizar el crédito", "EYETIVE", JOptionPane.ERROR_MESSAGE);
    }

    public static void repeatBuyFactureNumber() {
        JOptionPane.showMessageDialog(null, "Número de factura de compra existente", "EYETIVE", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void repeatSellFactureNumber() {
        JOptionPane.showMessageDialog(null, "Número de factura de venta existente", "EYETIVE", JOptionPane.ERROR_MESSAGE);
    }

    public static void sinAbonos() {
        JOptionPane.showMessageDialog(null, "La letra seleccionada no tiene abonos", "EYETIVE", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void letraPagada() {
        JOptionPane.showMessageDialog(null, "La letra ha sido cancelada con éxito", "EYETIVE", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void pagoTotalHecho() {
        JOptionPane.showMessageDialog(null, "Se ha cancelado toda la cuenta pendiente con éxito", "EYETIVE", JOptionPane.INFORMATION_MESSAGE);
    }

    static void archivoDanado() {
        JOptionPane.showMessageDialog(null, "El archivo está dañado, no se puede ejecutar la acción", "EYETIVE", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void errorCodigoBarra() {
        JOptionPane.showMessageDialog(null, "Error al crear codigo de barras.\nInformar al Administrador", "EYETIVE", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void barCodeExists() {
        JOptionPane.showMessageDialog(null, "El código de barra ya existe","EYETIVE",JOptionPane.ERROR_MESSAGE);
    }

    public static void conReferencia() {
        JOptionPane.showMessageDialog(null, "El depósito ya ha sido confirmado,elija otro.","EYETIVE",JOptionPane.INFORMATION_MESSAGE);
    }

    public static void depositConfirm() {
        JOptionPane.showMessageDialog(null, "Depósito confirmado","EYETIVE",JOptionPane.INFORMATION_MESSAGE);
    }

    public static void expenditureRealizado() {
        JOptionPane.showMessageDialog(null, "Gasto Realizado","EYETIVE",JOptionPane.INFORMATION_MESSAGE);
    }

    public static void chequeAnulado() {
        JOptionPane.showMessageDialog(null, "Cheque anulado","EYETIVE",JOptionPane.INFORMATION_MESSAGE);
    }

    public static void conDiario() {
        JOptionPane.showMessageDialog(null, "La empresa ya tiene diario","EYETIVE",JOptionPane.INFORMATION_MESSAGE);
    }

    public static void usuarioExistente() {
        JOptionPane.showMessageDialog(null, "Nombre de usuario ya está en uso","EYETIVE",JOptionPane.ERROR_MESSAGE);
    }

    public static void noMasItems() {
        JOptionPane.showMessageDialog(null, "Cierre la factura para agregar más items","CONFIGURACIÓN",JOptionPane.INFORMATION_MESSAGE);
    }

    public static void sinDiario() {
        JOptionPane.showMessageDialog(null, "Cree un diario para llevar los registros","EYETIVE",JOptionPane.INFORMATION_MESSAGE);
    }

    public static void productoInvalido() {
        JOptionPane.showMessageDialog(null, "Escoja un producto para editarlo","EYETIVE",JOptionPane.ERROR_MESSAGE);
    }

    public static void factureNumberExists() {
        JOptionPane.showMessageDialog(null, "Ya existe la factura","EYETIVE",JOptionPane.ERROR_MESSAGE);
    }

    public static void sinSeleccion(String text) {
        JOptionPane.showMessageDialog(null, "Seleccionar "+text,"EYETIVE",JOptionPane.ERROR_MESSAGE);
    }

    public static void mensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje,"EYETIVE",JOptionPane.INFORMATION_MESSAGE);
    }
    public static void mensajeError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje,"EYETIVE",JOptionPane.ERROR_MESSAGE);
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.tableModel;

import controller.resources.GeneralParameter;
import controller.resources.Operaciones;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.WorkOrder;

/**
 *
 * @author Eyetive
 */
public class WorkDiaryTableModel extends AbstractTableModel {

    private List<WorkOrder> list = new ArrayList<>();
    private final double accuracyVal = Math.pow(10, GeneralParameter.ACCURACY_VALUE);

    /**
     * @return the list
     */
    public List<WorkOrder> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<WorkOrder> list) {
        this.list = list;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public int getRowCount() {
        return this.list.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)//son los datos que se saca de la base de datos
    {
        WorkOrder wOrder = this.list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return String.valueOf(rowIndex + 1);
            case 1:
                return wOrder.getPerson().toString();
            case 2:
                return wOrder.getWorkOrderDescription(); //Operaciones.formFechaToLarge(aEntry.getAeCreatedDate());
            case 3:
                return Operaciones.formatDate(wOrder.getWorkOrderIssueDate());
            case 4:
                return Operaciones.formatDate(wOrder.getWorkOrderDeliveryDate());
//                if (aEntry.getAeType() == 0) {//Cuando es un ingreso
//                    return Operaciones.parteDecimal(Math.rint(aEntry.getAeValue() * accuracyVal) / accuracyVal, GeneralParameter.ACCURACY_VALUE);
//                } else {
//                    return "0.00";
//                }
//            case 4:
//                if (null != wOrder.getWorkOrderState()) {
//                    switch (wOrder.getWorkOrderState()) {
//                        case 1:
//                            return "PENDIENTE";
//                        case 2:
//                            return "PAUSADO";
//                        case 3:
//                            return "TERMINADO";
//                        default:
//                            break;
//                    }
//                }
//                if (aEntry.getAeType() == 1) {//Cuando es un egreso
//                    return Operaciones.parteDecimal(Math.rint(aEntry.getAeValue() * accuracyVal) / accuracyVal, GeneralParameter.ACCURACY_VALUE);
//                } else {
//                    return "0.00";
//                }
            default:
                return null;
        }

    }

    @Override
    public String getColumnName(int column) //para poner nombres a las columna 
    {
        switch (column) {
            case 0:
                return "N°.";
            case 1:
                return "CLIENTE";
            case 2:
                return "DESCRIPCIÓN";
            case 3:
                return "FECHA DE INICIO";
            case 4:
                return "FECHA DE FINALIZACIÓN";
//            case 4:
//                return "ESTADO";
            default:
                return null;
        }
    }

}

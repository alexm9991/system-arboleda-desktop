/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VstRecursos;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class RenderTable extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object objeto_renderizable, boolean isSelected, boolean hasFocus, int row, int column) {
       if(objeto_renderizable instanceof JButton){
          JButton boton =(JButton)objeto_renderizable;
          return boton;
       }
        return super.getTableCellRendererComponent(table, objeto_renderizable, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
    }

  
   
   
}

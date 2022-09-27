/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JASPER;

import vista.VstReportUser;
import conexion.conexionMensaje;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 * @author ELCAP
 */
public class ReportGenerator {

    public static final String REPORT_ACTIVE_USERS = "src/UserReports/rpActiveUsers.jasper";
    public static final String REPORT_INACTIVE_USERS = "src/UserReports/rpInactiveUsers.jasper";
    public static final String REPORT_EMPLOYEE_USERS = "src/UserReports/rpEmployeeUsers.jasper";
    public static final String REPORT_CLIENT_USERS = "src/UserReports/rpClientUsers.jasper";

    //reporte de usuarios activos
    public static JasperPrint rpActiveUsers() {
        try {
            JasperPrint reporteLleno = JasperFillManager.fillReport(REPORT_ACTIVE_USERS, new HashMap(), conexionMensaje.nuevaConexion());
            return reporteLleno;
        } catch (JRException ex) {
            Logger.getLogger(VstReportUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //reporte de usuarios eliminados o inactivos
    public static JasperPrint rpIactiveUsers() {
        try {
            JasperPrint reporteLleno = JasperFillManager.fillReport(REPORT_INACTIVE_USERS, new HashMap(), conexionMensaje.nuevaConexion());
            return reporteLleno;
        } catch (JRException ex) {
            Logger.getLogger(VstReportUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //reporte de empleados
    public static JasperPrint rpEmployeeUsers() {
        try {
            JasperPrint reporteLleno = JasperFillManager.fillReport(REPORT_EMPLOYEE_USERS, new HashMap(), conexionMensaje.nuevaConexion());
            return reporteLleno;
        } catch (JRException ex) {
            Logger.getLogger(VstReportUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //reporte de Clientes
    public static JasperPrint rpClientUsers() {
        try {
            JasperPrint reporteLleno = JasperFillManager.fillReport(REPORT_CLIENT_USERS, new HashMap(), conexionMensaje.nuevaConexion());
            return reporteLleno;
        } catch (JRException ex) {
            Logger.getLogger(VstReportUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

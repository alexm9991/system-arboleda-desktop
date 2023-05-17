/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jasperReportsController;

import conexion.ConexionReports;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import vista.VstReports;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;
import net.sf.jasperreports.view.JasperViewer;

/**
 * @author ELCAP
 */
public class ReportGenerator {

    //Usuarios
    public static final String REPORT_ACTIVE_USERS = "src/reports/rpActiveUsers.jasper";
    public static final String REPORT_INACTIVE_USERS = "src/reports/rpInactiveUsers.jasper";
    //Productos
    public static final String REPORT_ACTIVE_PRODUCTS = "src/reports/rpActiveProducts.jasper";
    public static final String REPORT_INACTIVE_PRODUCTS = "src/reports/rpInactiveProducts.jasper";
    //Servicios
    public static final String REPORT_ACTIVE_SERVICES = "src/reports/rpServicesActive.jasper";
    public static final String REPORT_INACTIVE_SERVICES = "src/reports/rpServicesInactive.jasper";
    //Reservas
    public static final String REPORT_ACTIVE_BOOKINGS = "src/reports/rpActiveBookings.jasper";
    public static final String REPORT_INACTIVE_BOOKINGS = "src/reports/rpInactiveBookings.jasper";

    //PQRS
    public static final String REPORT_PQRS_GESTIONADAS = "src/reports/rpPqrsGestionado.jasper";
    public static final String REPORT_PQRS_NO_GESTIONADAS = "src/reports/rpPqrsNoGestionado.jasper";
    public static final String REPORT_PQRS_EN_PROCESO = "src/reports/rpPqrsProceso.jasper";
    
    //REPORTES DE USUARIOS
    public static JasperPrint rpActiveUsers() {
        try {
            JasperPrint reporteLleno = JasperFillManager.fillReport(REPORT_ACTIVE_USERS, new HashMap(), ConexionReports.getMySqlConnection());
            return reporteLleno;
        } catch (JRException ex) {
            Logger.getLogger(VstReports.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static JasperPrint rpInactiveUsers() {
        try {
            JasperPrint reporteLleno = JasperFillManager.fillReport(REPORT_INACTIVE_USERS, new HashMap(), ConexionReports.getMySqlConnection());
            return reporteLleno;
        } catch (JRException ex) {
            Logger.getLogger(VstReports.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //REPORTES DE PRODUCTOS
    public static JasperPrint rpActiveProducts() {
        try {
            JasperPrint reporteLleno = JasperFillManager.fillReport(REPORT_ACTIVE_PRODUCTS, new HashMap(), ConexionReports.getMySqlConnection());
            return reporteLleno;
        } catch (JRException ex) {
            ex.printStackTrace(); // Imprimir la traza de la excepción en la consola
            Logger.getLogger(VstReports.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static JasperPrint rpInactiveProducts() {
        try {
            JasperPrint reporteLleno = JasperFillManager.fillReport(REPORT_INACTIVE_PRODUCTS, new HashMap(), ConexionReports.getMySqlConnection());
            return reporteLleno;
        } catch (JRException ex) {
            ex.printStackTrace(); // Imprimir la traza de la excepción en la consola
            Logger.getLogger(VstReports.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //REPORTE DE SERVICIOS
    public static JasperPrint rpActiveServices() {
        try {
            JasperPrint reporteLleno = JasperFillManager.fillReport(REPORT_ACTIVE_SERVICES, new HashMap(), ConexionReports.getMySqlConnection());
            return reporteLleno;
        } catch (JRException ex) {
            ex.printStackTrace(); // Imprimir la traza de la excepción en la consola
            Logger.getLogger(VstReports.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static JasperPrint rpInactiveServices() {
        try {
            JasperPrint reporteLleno = JasperFillManager.fillReport(REPORT_INACTIVE_SERVICES, new HashMap(), ConexionReports.getMySqlConnection());
            return reporteLleno;
        } catch (JRException ex) {
            ex.printStackTrace(); // Imprimir la traza de la excepción en la consola
            Logger.getLogger(VstReports.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //REPORTES DE RESERVAS
    public static JasperPrint rpActiveBookings() {
        try {
            JasperPrint reporteLleno = JasperFillManager.fillReport(REPORT_ACTIVE_BOOKINGS, new HashMap(), ConexionReports.getMySqlConnection());
            return reporteLleno;
        } catch (JRException ex) {
            ex.printStackTrace(); // Imprimir la traza de la excepción en la consola
            Logger.getLogger(VstReports.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static JasperPrint rpInactiveBookings() {
        try {
            JasperPrint reporteLleno = JasperFillManager.fillReport(REPORT_INACTIVE_BOOKINGS, new HashMap(), ConexionReports.getMySqlConnection());
            return reporteLleno;
        } catch (JRException ex) {
            ex.printStackTrace(); // Imprimir la traza de la excepción en la consola
            Logger.getLogger(VstReports.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //REPORTES DE PQRS
    public static JasperPrint rpPqrsGestionado() {
        try {
            JasperPrint reporteLleno = JasperFillManager.fillReport(REPORT_PQRS_GESTIONADAS, new HashMap(), ConexionReports.getMySqlConnection());
            return reporteLleno;
        } catch (JRException ex) {
            ex.printStackTrace(); // Imprimir la traza de la excepción en la consola
            Logger.getLogger(VstReports.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static JasperPrint rpPqrsNoGestionado() {
        try {
            JasperPrint reporteLleno = JasperFillManager.fillReport(REPORT_PQRS_NO_GESTIONADAS, new HashMap(), ConexionReports.getMySqlConnection());
            return reporteLleno;
        } catch (JRException ex) {
            ex.printStackTrace(); // Imprimir la traza de la excepción en la consola
            Logger.getLogger(VstReports.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
        public static JasperPrint rpPqrsProceso() {
        try {
            JasperPrint reporteLleno = JasperFillManager.fillReport(REPORT_PQRS_EN_PROCESO, new HashMap(), ConexionReports.getMySqlConnection());
            return reporteLleno;
        } catch (JRException ex) {
            ex.printStackTrace(); // Imprimir la traza de la excepción en la consola
            Logger.getLogger(VstReports.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jasperReportsController;
import java.nio.file.Path;
import java.nio.file.Paths;
import conexion.ConexionReports;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
    public static final String REPORT_ACTIVE_USERS = "rpActiveUsers.jasper";
    public static final String REPORT_INACTIVE_USERS = "rpInactiveUsers.jasper";
    
    //Productos
    public static final String REPORT_ACTIVE_PRODUCTS = "rpActiveProducts.jasper";
    public static final String REPORT_INACTIVE_PRODUCTS = "rpInactiveProducts.jasper";
    //Servicios
    public static final String REPORT_ACTIVE_SERVICES = "rpServicesActive.jasper";
    public static final String REPORT_INACTIVE_SERVICES = "rpServicesInactive.jasper";
    //Reservas
    public static final String REPORT_ACTIVE_BOOKINGS = "rpActiveBookings.jasper";
    public static final String REPORT_INACTIVE_BOOKINGS = "rpInactiveBookings.jasper";

    //PQRS
    public static final String REPORT_PQRS_GESTIONADAS = "rpPqrsGestionado.jasper";
    public static final String REPORT_PQRS_NO_GESTIONADAS = "rpPqrsNoGestionado.jasper";
    public static final String REPORT_PQRS_EN_PROCESO = "rpPqrsProceso.jasper";
    
   private static String getReportPath(String reportName) {
    try {
        InputStream inputStream = ReportGenerator.class.getResourceAsStream("/reports/" + reportName);
        if (inputStream == null) {
            throw new RuntimeException("No se encontró el archivo de informe: " + reportName);
        }

        File tempFile = File.createTempFile("report", ".jasper");
        tempFile.deleteOnExit();

        try (OutputStream outputStream = new FileOutputStream(tempFile)) {
            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }

        return tempFile.getAbsolutePath();
    } catch (IOException e) {
        throw new RuntimeException("Error al crear archivo temporal para el informe: " + reportName, e);
    }
}
    
    //REPORTES DE USUARIOS
    public static JasperPrint rpActiveUsers() {
        try {
            String reportPath = getReportPath(REPORT_ACTIVE_USERS);
            JasperPrint reporteLleno = JasperFillManager.fillReport(reportPath, new HashMap(), ConexionReports.getMySqlConnection());
            return reporteLleno;
        } catch (JRException ex) {
            ex.printStackTrace(); // Imprimir la traza de la excepción en la consola
            Logger.getLogger(VstReports.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static JasperPrint rpInactiveUsers() {
        try {
           String reportPath = getReportPath(REPORT_INACTIVE_USERS);
            JasperPrint reporteLleno = JasperFillManager.fillReport(reportPath, new HashMap(), ConexionReports.getMySqlConnection());
            return reporteLleno;
            
        } catch (JRException ex) {
            Logger.getLogger(VstReports.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //REPORTES DE PRODUCTOS
    public static JasperPrint rpActiveProducts() {
        try {
            String reportPath = getReportPath(REPORT_ACTIVE_PRODUCTS);
            JasperPrint reporteLleno = JasperFillManager.fillReport(reportPath, new HashMap(), ConexionReports.getMySqlConnection());
            return reporteLleno;
        } catch (JRException ex) {
            ex.printStackTrace(); // Imprimir la traza de la excepción en la consola
            Logger.getLogger(VstReports.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static JasperPrint rpInactiveProducts() {
        try {
            String reportPath = getReportPath(REPORT_INACTIVE_PRODUCTS);
            JasperPrint reporteLleno = JasperFillManager.fillReport(reportPath, new HashMap(), ConexionReports.getMySqlConnection());
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
            String reportPath = getReportPath(REPORT_ACTIVE_SERVICES);
            JasperPrint reporteLleno = JasperFillManager.fillReport(reportPath, new HashMap(), ConexionReports.getMySqlConnection());
            return reporteLleno;
        } catch (JRException ex) {
            ex.printStackTrace(); // Imprimir la traza de la excepción en la consola
            Logger.getLogger(VstReports.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static JasperPrint rpInactiveServices() {
        try {
            String reportPath = getReportPath(REPORT_INACTIVE_SERVICES);
            JasperPrint reporteLleno = JasperFillManager.fillReport(reportPath, new HashMap(), ConexionReports.getMySqlConnection());
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
             String reportPath = getReportPath(REPORT_ACTIVE_BOOKINGS);
            JasperPrint reporteLleno = JasperFillManager.fillReport(reportPath, new HashMap(), ConexionReports.getMySqlConnection());
            return reporteLleno;
        } catch (JRException ex) {
            ex.printStackTrace(); // Imprimir la traza de la excepción en la consola
            Logger.getLogger(VstReports.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static JasperPrint rpInactiveBookings() {
        try {
             String reportPath = getReportPath(REPORT_INACTIVE_BOOKINGS);
            JasperPrint reporteLleno = JasperFillManager.fillReport(reportPath, new HashMap(), ConexionReports.getMySqlConnection());
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
           String reportPath = getReportPath(REPORT_PQRS_GESTIONADAS);
            JasperPrint reporteLleno = JasperFillManager.fillReport(reportPath, new HashMap(), ConexionReports.getMySqlConnection());
            return reporteLleno;
        } catch (JRException ex) {
            ex.printStackTrace(); // Imprimir la traza de la excepción en la consola
            Logger.getLogger(VstReports.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static JasperPrint rpPqrsNoGestionado() {
        try {
           String reportPath = getReportPath(REPORT_PQRS_NO_GESTIONADAS);
            JasperPrint reporteLleno = JasperFillManager.fillReport(reportPath, new HashMap(), ConexionReports.getMySqlConnection());
            return reporteLleno;
        } catch (JRException ex) {
            ex.printStackTrace(); // Imprimir la traza de la excepción en la consola
            Logger.getLogger(VstReports.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
        public static JasperPrint rpPqrsProceso() {
        try {
            String reportPath = getReportPath(REPORT_PQRS_EN_PROCESO);
            JasperPrint reporteLleno = JasperFillManager.fillReport(reportPath, new HashMap(), ConexionReports.getMySqlConnection());
            return reporteLleno;
        } catch (JRException ex) {
            ex.printStackTrace(); // Imprimir la traza de la excepción en la consola
            Logger.getLogger(VstReports.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

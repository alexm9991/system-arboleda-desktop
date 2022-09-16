package vista;

import com.sun.awt.AWTUtilities;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;

/**
 *
 * @author andres.mora
 */
public class VstBase extends javax.swing.JFrame {

    int x, y;

    public VstBase() {
        this.setUndecorated(true);
        setVisible(true);
        setResizable(false);
        setSize(600, 450);
        setLocationRelativeTo(null);
        ImageIcon icono = new ImageIcon("src/assets/logo.jpg");
        this.setIconImage(icono.getImage());
        
    }

    public void bordePantalla() {
//        this.setUndecorated(true);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 40, 40);
        AWTUtilities.setWindowShape(this, forma);
    }

    //Métodos de la Ventana
    public void moverVentana(java.awt.event.MouseEvent evt) {
        int X = evt.getXOnScreen();
        int Y = evt.getYOnScreen();
        this.setLocation(X - x, Y - y);
    }

    public void presionVentana(java.awt.event.MouseEvent evt) {
        x = evt.getX();
        y = evt.getY();
    }

    public void cerrarVentana(java.awt.event.MouseEvent evt) {
        System.exit(0);
    }

    public void minimizarVentana(java.awt.event.MouseEvent evt) {
        setExtendedState(ICONIFIED);
    }

}

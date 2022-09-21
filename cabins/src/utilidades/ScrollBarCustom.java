package utilidades;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class ScrollBarCustom extends JScrollBar {

    public ScrollBarCustom() {
        setUI(new RSScrollBar());
        setPreferredSize(new Dimension(10, 10));
        setForeground(new Color(48, 144, 216));
        setBackground(new Color (204,217, 210));
    }
}
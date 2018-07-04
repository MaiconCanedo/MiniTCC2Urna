package br.gov.tse.urna.util;

import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 * @author Maicon Canedo
 */
public class AbridorDeJanelas {
    
	//Construtores
    public AbridorDeJanelas() {}

    public AbridorDeJanelas(JInternalFrame janela, JDesktopPane desktop) {
        abrirJanela(janela, desktop);
    }

    public AbridorDeJanelas(JInternalFrame janela, JDesktopPane desktop, int w, int h) {
        abrirJanela(janela, desktop, w, h);
    }

    public  AbridorDeJanelas(JInternalFrame janela, JDesktopPane desktop, Dimension tamanho) {
        abrirJanela(janela, desktop, tamanho);
    }
    
    //Métodos
    public static void abrirJanela(JInternalFrame janela, JDesktopPane desktop) {
        abrirJanela(janela, desktop, desktop.getMinimumSize());
    }

    public static void abrirJanela(JInternalFrame janela, JDesktopPane desktop, int w, int h) {
        abrirJanela(janela, desktop, new Dimension(w, h));
    }

    public static void abrirJanela(JInternalFrame janela, JDesktopPane desktop, Dimension tamanho) {
        desktop.add(janela);
        janela.setSize(tamanho);
        janela.setLocation((desktop.getWidth() / 2) - (janela.getWidth() / 2), (desktop.getHeight() / 2) - (janela.getHeight() / 2));
        janela.setVisible(true);
        janela.toFront();
        janela.show();
    }
}
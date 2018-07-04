package br.gov.tse.urna.util;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;

/**
 * @author Maicon Canedo
 */
public class TesteCapsLock {

    public boolean testar() {
        return Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK);
    }
}
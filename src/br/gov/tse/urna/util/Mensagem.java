package br.gov.tse.urna.util;

import java.awt.Component;

import javax.swing.JOptionPane;

public class Mensagem {
	
	public static void addMsgErr(Component parentComponent, String message, String title) {
		JOptionPane.showMessageDialog(parentComponent, message, title, 0);
	}
	public static void addMsgErr(Component parentComponent, String message) {
		JOptionPane.showMessageDialog(parentComponent, message, null, 0);
	}
	public static void addMsgInf(Component parentComponent, String message, String title) {
		JOptionPane.showMessageDialog(parentComponent, message, title, 1);
	}
	public static void addMsgInf(Component parentComponent, String message) {
		JOptionPane.showMessageDialog(parentComponent, message, null, 1);
	}
}
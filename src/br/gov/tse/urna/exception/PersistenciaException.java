package br.gov.tse.urna.exception;

public class PersistenciaException extends Exception {

	private static final long serialVersionUID = -5519685333098822532L;
	
	public PersistenciaException(String message) {
		super(message);
	}
	public PersistenciaException(String message, Exception exception) {
		super(message, exception);
	}
}
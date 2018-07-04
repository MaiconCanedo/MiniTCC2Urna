package br.gov.tse.urna.dao;

import java.util.List;

import br.gov.tse.urna.exception.PersistenciaException;

public interface GenericoDAO<T> {
	
	void incluir(T Objeto) throws PersistenciaException;
	void atualizar(T Objeto) throws PersistenciaException;
	List<T> listarTodos() throws PersistenciaException;
	void excluir(Integer id) throws PersistenciaException;
	T getById(Integer id) throws PersistenciaException;
}
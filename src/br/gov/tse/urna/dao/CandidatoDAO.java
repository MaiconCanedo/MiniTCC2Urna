package br.gov.tse.urna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.gov.tse.urna.connection.Conexao;
import br.gov.tse.urna.dto.CandidatoDTO;
import br.gov.tse.urna.exception.PersistenciaException;

public class CandidatoDAO implements GenericoDAO<CandidatoDTO> {
	
	private static final String SQL_SELECT = "SELECT * FROM candidato";
	private static final String SQL_DELETE = "DELETE FROM candidato WHERE numero=?";
	private static final String SQL_UPDATE = "UPDATE candidato SET numero=?, nome=?, nome_vice=?, foto=?, foto_vice=? WHERE numero=?";
	private static final String SQL_INSERT = "INSERT INTO candidato (numero, nome, nome_vice, foto, foto_vice) VALUES (?, ?, ?, ?, ?)";
	
	private CandidatoDTO alimentarCandidato(ResultSet resultSet) throws SQLException, PersistenciaException {
		return new CandidatoDTO(new PartidoDAO().getById(resultSet.getInt("numero")) , resultSet.getString("nome"), resultSet.getString("nome_vice"),
				resultSet.getString("foto"), resultSet.getString("foto_vice"));
	}
	
	private PreparedStatement alimentarStatement(CandidatoDTO candidatoDTO, Connection connection, String sql) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, candidatoDTO.getPartidoDTO().getNumero());
		preparedStatement.setString(2, candidatoDTO.getNome());
		preparedStatement.setString(3, candidatoDTO.getNomeVice());
		preparedStatement.setString(4, candidatoDTO.getFoto());
		preparedStatement.setString(5, candidatoDTO.getFotoVice());		
		return preparedStatement;
	}
	
	public void incluir(List<CandidatoDTO> listaCandidatos) throws PersistenciaException {
		for(CandidatoDTO candidatoDTO : listaCandidatos) {
			incluir(candidatoDTO);
		}
	}
	
	@Override
	public void incluir(CandidatoDTO candidatoDTO) throws PersistenciaException {
		try {
			Connection connection = Conexao.getInstance().getConnection();
			alimentarStatement(candidatoDTO, connection, SQL_INSERT).execute();
			connection.close();
		} catch (Exception e) {
			throw new PersistenciaException("incluir ", e);
		}
	}
	
	public void atualizar(List<CandidatoDTO> listaCandidatos) throws PersistenciaException {
		for(CandidatoDTO candidatoDTO : listaCandidatos) {
			atualizar(candidatoDTO);
		}
	}
	
	@Override
	public void atualizar(CandidatoDTO candidatoDTO) throws PersistenciaException {
		try {
			Connection connection = Conexao.getInstance().getConnection();
			PreparedStatement preparedStatement = alimentarStatement(candidatoDTO, connection, SQL_UPDATE);
			preparedStatement.setInt(6, candidatoDTO.getPartidoDTO().getNumero());
			preparedStatement.executeUpdate();
			connection.close();
		} catch (Exception e) {
			throw new PersistenciaException("atualizar ", e);
		}
	}

	@Override
	public ArrayList<CandidatoDTO> listarTodos() throws PersistenciaException {
		ArrayList<CandidatoDTO> lista = null;
		try {
			Connection connection = Conexao.getInstance().getConnection();
			ResultSet resultSet = connection.prepareStatement(SQL_UPDATE).executeQuery();
			lista = new ArrayList<>();
			while(resultSet.next()) {
				lista.add(alimentarCandidato(resultSet));
			}
			connection.close();
		} catch (Exception e) {
			throw new PersistenciaException("listar todos ", e);
		}
		return lista;
	}

	@Override
	public void excluir(Integer numero) throws PersistenciaException {
		try {
			Connection connection = Conexao.getInstance().getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE);
			preparedStatement.setInt(1, numero);
			preparedStatement.execute();
			connection.close();
		} catch (Exception e) {
			throw new PersistenciaException("excluir ", e);
		}
	}

	@Override
	public CandidatoDTO getById(Integer numero) throws PersistenciaException {
		CandidatoDTO candidatoDTO = null;
		try {
			Connection connection = Conexao.getInstance().getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT + " WHERE numero=?");
			preparedStatement.setInt(1, numero);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				candidatoDTO = alimentarCandidato(resultSet);
			}
			connection.close();
		} catch (Exception e) {
			throw new PersistenciaException("get By Id ", e);
		}
		return candidatoDTO;
	}
}
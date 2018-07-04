package br.gov.tse.urna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.gov.tse.urna.connection.Conexao;
import br.gov.tse.urna.dto.PartidoDTO;
import br.gov.tse.urna.exception.PersistenciaException;

public class PartidoDAO implements GenericoDAO<PartidoDTO> {

	private static final String SQL_SELECT = "SELECT * FROM partido";
	private static final String SQL_UPDATE = "UPDATE partido SET numero=?, nome=?, sigla=? WHERE numero=?";
	private static final String SQL_DELETE = "DETELE FROM partido WHERE numero=?";
	private static final String SQL_INSERT = "INSERT INTO partido (numero, nome, sigla) VALUES (?, ?, ?)";

	private PartidoDTO alimentarPartido(ResultSet resultSet) throws SQLException {
		return new PartidoDTO(resultSet.getInt("numero"), resultSet.getString("nome"), resultSet.getString("sigla"));
	}

	private PreparedStatement alimentarStatement(PartidoDTO partidoDTO, Connection connection, String sql)
			throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, partidoDTO.getNumero());
		preparedStatement.setString(2, partidoDTO.getNome());
		preparedStatement.setString(3, partidoDTO.getSigla());
		return preparedStatement;
	}
	
	public void incluir(List<PartidoDTO> listaPartidos) throws PersistenciaException {
		for (PartidoDTO partidoDTO : listaPartidos) {
			incluir(partidoDTO);
		}
	}
	
	@Override
	public void incluir(PartidoDTO partidoDTO) throws PersistenciaException {
		try {
			Connection connection = Conexao.getInstance().getConnection();
			alimentarStatement(partidoDTO, connection, SQL_INSERT).execute();
			connection.close();
		} catch (Exception e) {
			throw new PersistenciaException("incluir ", e);
		}
	}
	
	public void atualizar(List<PartidoDTO> listaPartidos) throws PersistenciaException {
		for(PartidoDTO partidoDTO : listaPartidos) {
			atualizar(partidoDTO);
		}
	}
	
	@Override
	public void atualizar(PartidoDTO partidoDTO) throws PersistenciaException {
		try {
			Connection connection = Conexao.getInstance().getConnection();
			PreparedStatement preparedStatement = alimentarStatement(partidoDTO, connection, SQL_UPDATE);
			preparedStatement.setInt(4, partidoDTO.getNumero());
			preparedStatement.executeUpdate();
			connection.close();
		} catch (Exception e) {
			throw new PersistenciaException("atualizar ", e);
		}
	}

	@Override
	public ArrayList<PartidoDTO> listarTodos() throws PersistenciaException {
		ArrayList<PartidoDTO> lista = null;
		try {
			Connection connection = Conexao.getInstance().getConnection();
			ResultSet resultSet = connection.prepareStatement(SQL_SELECT + " ORDER BY numero").executeQuery();
			lista = new ArrayList<>();
			while (resultSet.next()) {
				lista.add(alimentarPartido(resultSet));
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
	public PartidoDTO getById(Integer numero) throws PersistenciaException {
		return getByIdOrSigla(numero, null);
	}

	public PartidoDTO getBySigla(String sigla) throws PersistenciaException {
		return getByIdOrSigla(null, sigla.toUpperCase());
	}

	private PartidoDTO getByIdOrSigla(Integer idPartido, String sigla) throws PersistenciaException {
		PartidoDTO partidoDTO = null;
		String sql = idPartido != null ? " WHERE numero=?" : " WHERE sigla=?";
		try {
			Connection connection = Conexao.getInstance().getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT + sql);
			if (idPartido != null) {
				preparedStatement.setInt(1, idPartido);
			} else {
				preparedStatement.setString(1, sigla);
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				partidoDTO = alimentarPartido(resultSet);
			}
			connection.close();
		} catch (Exception e) {
			throw new PersistenciaException("get by id ", e);
		}
		return partidoDTO;
	}
}
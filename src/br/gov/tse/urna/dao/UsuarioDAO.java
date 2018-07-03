package br.gov.tse.urna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.gov.tse.urna.connection.Conexao;
import br.gov.tse.urna.dto.UsuarioDTO;
import br.gov.tse.urna.exception.PersistenciaException;

public class UsuarioDAO implements GenericoDAO<UsuarioDTO> {

	private static final String SQL_AUTHENTICATE = "SELECT * FROM usuario WHERE login=? AND senha=MD5(?)";
	private static final String SQL_SELECT = "SELECT * FROM usuario";
	private static final String SQL_DELETE = "DELETE FROM usuario WHERE numero";
	private static final String SQL_INSERT = "INSERT INTO usuario (nome, login, senha, situacao, admin) VALUES (?, ?, MD5(?), ?, ?)";
	private static final String SQL_UPDATE = "UPDATE usuario SET nome=?, login=?, senha=MD5(?), situacao=?, admin=? WHERE id_usuario";

	private UsuarioDTO alimentarUsuario(ResultSet resultSet) throws SQLException {
		return new UsuarioDTO(resultSet.getInt("id_usuario"), resultSet.getString("nome"), resultSet.getString("login"),
				resultSet.getString("senha"), resultSet.getBoolean("situacao"), resultSet.getBoolean("admin"));
	}
	
	private PreparedStatement alimentarStatement(UsuarioDTO usuarioDTO, Connection connection, String sql) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, usuarioDTO.getNome());
		preparedStatement.setString(2, usuarioDTO.getLogin());
		preparedStatement.setString(3, usuarioDTO.getSenha());
		preparedStatement.setBoolean(4, usuarioDTO.isSituacao());
		preparedStatement.setBoolean(5, usuarioDTO.isAdmin());
		return preparedStatement;
	}
	
	public UsuarioDTO logar(String login, String senha) throws PersistenciaException {
		UsuarioDTO usuarioDTO = null;
		try {
			Connection connection = Conexao.getInstance().getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_AUTHENTICATE);
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, senha);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				usuarioDTO = alimentarUsuario(resultSet);
			}
			connection.close();
		} catch (Exception e) {
			throw new PersistenciaException("logar ", e);
		}
		return usuarioDTO;
	}
	
	public void incluir(List<UsuarioDTO> listaUsuarios) throws PersistenciaException {
		for (UsuarioDTO usuarioDTO : listaUsuarios) {
			incluir(usuarioDTO);
		}
	}
	
	@Override
	public void incluir(UsuarioDTO usuarioDTO) throws PersistenciaException {
		try {
			Connection connection = Conexao.getInstance().getConnection();
			alimentarStatement(usuarioDTO, connection, SQL_INSERT).execute();
			connection.close();
		} catch (Exception e) {
			throw new PersistenciaException("incluir ", e);
		}
	}
	
	public void atualizar(List<UsuarioDTO> listaUsuarios) throws PersistenciaException {
		for (UsuarioDTO usuarioDTO : listaUsuarios) {
			atualizar(usuarioDTO);
		}
	}
	
	@Override
	public void atualizar(UsuarioDTO usuarioDTO) throws PersistenciaException {
		try {
			Connection connection = Conexao.getInstance().getConnection();
			PreparedStatement preparedStatement = alimentarStatement(usuarioDTO, connection, SQL_UPDATE);
			preparedStatement.setInt(6, usuarioDTO.getIdUsuario());
			preparedStatement.execute();
			connection.close();
		} catch (Exception e) {
			throw new PersistenciaException("atualizar ", e);
		}
	}

	@Override
	public ArrayList<UsuarioDTO> listarTodos() throws PersistenciaException {
		ArrayList<UsuarioDTO> lista = null;
		try {
			Connection connection = Conexao.getInstance().getConnection();
			ResultSet resultSet = connection.prepareStatement(SQL_SELECT + " ORDER BY situacao").executeQuery();
			lista = new ArrayList<>();
			while (resultSet.next()) {
				lista.add(alimentarUsuario(resultSet));
			}
			connection.close();
		} catch (Exception e) {
			throw new PersistenciaException("listar todos", e);
		}
		return lista;
	}

	@Override
	public void excluir(Integer idUsuario) throws PersistenciaException {
		try {
			Connection connection = Conexao.getInstance().getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE);
			preparedStatement.setInt(1, idUsuario);
			preparedStatement.execute();
			connection.close();
		} catch (Exception e) {
			throw new PersistenciaException("excluir", e);
		}
	}

	@Override
	public UsuarioDTO getById(Integer idUsuario) throws PersistenciaException {
		UsuarioDTO usuarioDTO = null;
		try {
			Connection connection = Conexao.getInstance().getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT + " WHERE id_usuario=?");
			preparedStatement.setInt(1, idUsuario);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				usuarioDTO = alimentarUsuario(resultSet);
			}
			connection.close();
		} catch (Exception e) {
			throw new PersistenciaException("excluir", e);
		}
		return usuarioDTO;
	}
}
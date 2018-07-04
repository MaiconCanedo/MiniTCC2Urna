package br.gov.tse.urna.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import br.gov.tse.urna.connection.Conexao;
import br.gov.tse.urna.dto.EleitorDTO;
import br.gov.tse.urna.exception.PersistenciaException;

public class EleitorDAO implements GenericoDAO<EleitorDTO> {

	private static final String SQL_SELECT = "SELECT * FROM eleitor";
	private static final String SQL_INSERT = "INSERT INTO eleitor (numero_inscricao, nome, cep, rg, cpf, data_nascimento, orgao_emissor, data_emissao) VALUES (?, ?, ?, ?, ?, ?, ?, now())";
	private static final String SQL_UPDATE = "UPDATE eleitor SET data_emissao=?, nome=?, cep=?, rg=?, cpf=?, data_nascimento=?, orgao_emissor=?  WHERE numero_inscricao=?";
	private static final String SQL_DELETE = "DELETE FROM eleitor WHERE numero_inscricao=?";
	
	private EleitorDTO alimentarEleitor(ResultSet resultSet) throws SQLException {
		return new EleitorDTO(resultSet.getString("numero_inscricao"),resultSet.getString("nome"),resultSet.getString("cep"),
			resultSet.getString("rg"), resultSet.getString("orgao_emissor"), resultSet.getString("cpf"), resultSet.getDate("data_nascimento"),
			resultSet.getTimestamp("data_emissao"));
	}
	
	private PreparedStatement alimentarStatement(EleitorDTO eleitorDTO, Connection connection, String sql) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(2, eleitorDTO.getNome());		
		preparedStatement.setString(3, eleitorDTO.getCep());		
		preparedStatement.setString(4, eleitorDTO.getRg());		
		preparedStatement.setString(5, eleitorDTO.getCpf());		
		preparedStatement.setDate(6, new Date(eleitorDTO.getDataNascimento().getTime()));		
		preparedStatement.setString(7, eleitorDTO.getOrgaoEmissor());
		return preparedStatement;		
	}
	
	private String gerarNumeroInscricao() throws PersistenciaException {
		StringBuilder numeroInscricao = new StringBuilder();
		Random random = new Random();
		do {
			numeroInscricao.setLength(0);
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 4; j++) {
					numeroInscricao.append(random.nextInt(10));
				}
				numeroInscricao.append(i == 2 ? "" : " ");
			}
		} while (getById(numeroInscricao.toString()) != null);
		return numeroInscricao.toString();
	}

	@Override
	public void incluir(EleitorDTO eleitorDTO) throws PersistenciaException {
		try {
			Connection connection = Conexao.getInstance().getConnection();		
			PreparedStatement preparedStatement = alimentarStatement(eleitorDTO, connection, SQL_INSERT);
			preparedStatement.setString(1, gerarNumeroInscricao());	
			preparedStatement.execute();
			connection.close();
		} catch (Exception e) {
			throw new PersistenciaException("incluir ", e);
		}
	}

	@Override
	public void atualizar(EleitorDTO eleitorDTO) throws PersistenciaException {
		try {
			Connection connection = Conexao.getInstance().getConnection();
			PreparedStatement preparedStatement = alimentarStatement(eleitorDTO, connection, SQL_UPDATE);
			preparedStatement.setTimestamp(1, eleitorDTO.getDataEmissao());
			preparedStatement.setString(8, eleitorDTO.getNumeroIscricao());
			preparedStatement.execute();
			connection.close();
		} catch (Exception e) {
			throw new PersistenciaException("incluir ", e);
		}
	}

	@Override
	public ArrayList<EleitorDTO> listarTodos() throws PersistenciaException {
		ArrayList<EleitorDTO> lista = null;
		try {
			Connection connection = Conexao.getInstance().getConnection();
			ResultSet resultSet = connection.prepareStatement(SQL_SELECT + " ORDER BY nome").executeQuery();
			lista = new ArrayList<>();
			while(resultSet.next()) {
				lista.add(alimentarEleitor(resultSet));
			}
			connection.close();
		} catch (Exception e) {
			throw new PersistenciaException("listar todos ", e);
		}
		return lista;
	}

	@Override
	public void excluir(Integer numeroInscricao) throws PersistenciaException {
		// TODO Auto-generated method stub
	}
	

	public void excluir(String numeroInscricao) throws PersistenciaException {
		
	}


	public EleitorDTO getById(String numeroInscricao) throws PersistenciaException {
		EleitorDTO eleitorDTO = null;
		try {
			Connection connection = Conexao.getInstance().getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT + " WHERE numero_inscricao=?");
			preparedStatement.setString(1, numeroInscricao);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				eleitorDTO = alimentarEleitor(resultSet);
			}
			connection.close();
		} catch (Exception e) {
			throw new PersistenciaException("get by id ", e);
		}
		return eleitorDTO;
	}

	@Override
	public EleitorDTO getById(Integer numeroInscricao) throws PersistenciaException {
		return null;
	}
}
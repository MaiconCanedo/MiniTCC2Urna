package br.gov.tse.urna.util;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import br.gov.tse.urna.bo.LoginBO;
import br.gov.tse.urna.dao.EleitorDAO;
import br.gov.tse.urna.dao.PartidoDAO;
import br.gov.tse.urna.dao.UsuarioDAO;
import br.gov.tse.urna.dto.EleitorDTO;
import br.gov.tse.urna.dto.PartidoDTO;

public class TesteConexao {

	public static void main(String[] args) {
		try {
//			new PartidoDAO().listarTodos().forEach((partidoDTO) -> System.out.println(partidoDTO));
			new UsuarioDAO().listarTodos().forEach((usuarioDTO) -> System.out.println(usuarioDTO));
//			System.out.println(new UsuarioDAO().getById(1));
//			System.out.println(new PartidoDAO().getById(45));
//			ArrayList<PartidoDTO> lista = new ArrayList<>(Arrays.asList(new PartidoDTO[] {
//				new PartidoDTO(13, "Partido dos Trabalhadores", "PT"), new PartidoDTO(45, "Partido da Social Democracia Brasileira", "PSDB"),
//				new PartidoDTO(15, "Movimento Democrático Brasileiro", "MDB"), new PartidoDTO(40, "Partido Socialista Brasileiro", "PSB")
//			}));
//			PartidoDAO dao = new PartidoDAO();
//			dao.incluir(lista);
//			dao.listarTodos().forEach((partidoDTO) -> System.out.println(partidoDTO));	
//			EleitorDAO eleitorDAO = new EleitorDAO();
//			EleitorDTO eleitorDTO = eleitorDAO.getById("8878 6345 2211");
//			eleitorDTO.setNome("Tássio Auad");
//			eleitorDAO.atualizar(eleitorDTO);
//			ArrayList<EleitorDTO> lista = eleitorDAO.listarTodos();
//			lista.sort((e1, e2) -> e1.getNome().compareTo(e2.getNome()));
//			System.out.println(lista);
//			System.out.println(eleitorDAO.getById("8878 6345 2211"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
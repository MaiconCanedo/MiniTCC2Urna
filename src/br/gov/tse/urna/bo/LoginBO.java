package br.gov.tse.urna.bo;

import br.gov.tse.urna.dao.UsuarioDAO;
import br.gov.tse.urna.dto.UsuarioDTO;
import br.gov.tse.urna.exception.NegocioException;
import br.gov.tse.urna.exception.PersistenciaException;

public class LoginBO {
		
	public UsuarioDTO logar(String login, String senha) throws NegocioException, PersistenciaException {
		UsuarioDTO usuarioDTO = null;
		if(login == null || "".equals(login.trim())) {
			throw new NegocioException("O Login é Obrigatório!");
		} else if(senha == null || "".equals(senha.trim())) {
			throw new NegocioException("A Senha é Obrigatória!");
		} else {
			usuarioDTO = new UsuarioDAO().logar(login, senha);
			if(usuarioDTO == null) {
				throw new NegocioException("Login ou/e Senha Incorreto(s)!");
			}
			if(!usuarioDTO.isSituacao()) {
				throw new NegocioException("Usuário Inativo!");
			}
		}
		return usuarioDTO;
	}
	
	public void logar(UsuarioDTO usuarioDTO) throws NegocioException, PersistenciaException {
		logar(usuarioDTO.getLogin(), usuarioDTO.getSenha());
	}
}
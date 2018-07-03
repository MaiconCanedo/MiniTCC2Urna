package br.gov.tse.urna.dto;

import java.sql.Timestamp;

public class Voto {
	
	private long idVoto;
	private EleitorDTO eleitorDTO;
	private CandidatoDTO candidatoDTO;
	private Timestamp dataHora;
	
	public Voto(long idVoto, EleitorDTO eleitorDTO, CandidatoDTO candidatoDTO, Timestamp dataHora) {
		this.idVoto = idVoto;
		this.eleitorDTO = eleitorDTO;
		this.candidatoDTO = candidatoDTO;
		this.dataHora = dataHora;
	}
	
	public long getIdVoto() {
		return idVoto;
	}

	public void setIdVoto(long idVoto) {
		this.idVoto = idVoto;
	}

	public EleitorDTO getEleitorDTO() {
		return eleitorDTO;
	}

	public void setEleitorDTO(EleitorDTO eleitorDTO) {
		this.eleitorDTO = eleitorDTO;
	}

	public CandidatoDTO getCandidatoDTO() {
		return candidatoDTO;
	}

	public void setCandidatoDTO(CandidatoDTO candidatoDTO) {
		this.candidatoDTO = candidatoDTO;
	}

	public Timestamp getDataHora() {
		return dataHora;
	}

	public void setDataHora(Timestamp dataHora) {
		this.dataHora = dataHora;
	}
}

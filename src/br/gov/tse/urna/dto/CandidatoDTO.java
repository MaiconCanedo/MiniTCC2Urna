package br.gov.tse.urna.dto;

public class CandidatoDTO implements Comparable<CandidatoDTO> {
	
	private PartidoDTO partidoDTO;
	private String nome, nomeVice, foto, fotoVice;
	
	public CandidatoDTO() {}
	
	public CandidatoDTO(PartidoDTO partidoDTO, String nome, String nomeVice, String foto, String fotoVice) {
		this.partidoDTO = partidoDTO;
		this.nome = nome;
		this.nomeVice = nomeVice;
		this.foto = foto;
		this.fotoVice = fotoVice;
	}
	
	public PartidoDTO getPartidoDTO() {
		return partidoDTO;
	}
	public void setPartidoDTO(PartidoDTO partidoDTO) {
		this.partidoDTO = partidoDTO;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeVice() {
		return nomeVice;
	}
	public void setNomeVice(String nomeVice) {
		this.nomeVice = nomeVice;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getFotoVice() {
		return fotoVice;
	}
	public void setFotoVice(String fotoVice) {
		this.fotoVice = fotoVice;
	}
	
	@Override
	public String toString() {
		return "CandidatoDTO [numero=" + partidoDTO.getNumero() + ", nome=" + nome + ", nomeVice=" + nomeVice + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		return partidoDTO.getNumero() == ((CandidatoDTO)obj).partidoDTO.getNumero();
	}
	
	@Override
	public int compareTo(CandidatoDTO candidatoDTO) {
		return partidoDTO.getNumero().compareTo(candidatoDTO.partidoDTO.getNumero());
	}
}
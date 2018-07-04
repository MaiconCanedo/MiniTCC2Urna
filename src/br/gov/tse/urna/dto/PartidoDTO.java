package br.gov.tse.urna.dto;

/**
 * @author Maicon Canedo
 */
public class PartidoDTO implements Comparable<PartidoDTO>{
    
    private Integer numero;
    private String nome, sigla;
    
    public PartidoDTO() {}
    
    public PartidoDTO(Integer numero, String nome, String sigla) {
    	this.numero = numero;
    	this.nome = nome;
    	this.sigla = sigla;
    }
    
    public PartidoDTO(String nome, String sigla) {
    	this(null, nome, sigla);
    }
    
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

	@Override
	public String toString() {
		return "Partido [numero=" + numero + ", nome=" + nome + ", sigla=" + sigla + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		return numero == ((PartidoDTO)obj).numero;
	}
	
	@Override
	public int compareTo(PartidoDTO partidoDTO) {
		return sigla.compareTo(partidoDTO.sigla);
	}
}
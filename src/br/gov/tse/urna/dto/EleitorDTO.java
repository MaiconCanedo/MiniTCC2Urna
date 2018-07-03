package br.gov.tse.urna.dto;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author Maicon Canedo
 */
public class EleitorDTO implements Comparable<EleitorDTO>{
    
    private String numeroIscricao, nome, cep, rg, orgaoEmissor, cpf;
    private Date dataNascimento;
    private Timestamp dataEmissao;
    
    public EleitorDTO() {}
    
    public EleitorDTO(String numeroIscricao, String nome, String cep, String rg, String orgaoEmissor, String cpf,
			Date dataNascimento, Timestamp dataEmissao) {
		super();
		this.numeroIscricao = numeroIscricao;
		this.nome = nome;
		this.cep = cep;
		this.rg = rg;
		this.orgaoEmissor = orgaoEmissor;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.dataEmissao = dataEmissao;
	}
    
    public EleitorDTO(String nome, String cep, String rg, String orgaoEmissor, String cpf, Date dataNascimento) {
    	this(null, nome, cep, rg, orgaoEmissor, cpf, dataNascimento, null);
    }

	public String getNumeroIscricao() {
        return numeroIscricao;
    }

    public void setNumeroIscricao(String numeroIscricao) {
        this.numeroIscricao = numeroIscricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getOrgaoEmissor() {
        return orgaoEmissor;
    }

    public void setOrgaoEmissor(String orgaoEmissor) {
        this.orgaoEmissor = orgaoEmissor;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Timestamp getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Timestamp dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

	@Override
	public String toString() {
		return "EleitorDTO [numeroIscricao=" + numeroIscricao + ", nome=" + nome + ", cep=" + cep + ", rg=" + rg
				+ ", orgaoEmissor=" + orgaoEmissor + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento
				+ ", dataEmissao=" + dataEmissao + "]";
	}

	@Override
	public int compareTo(EleitorDTO eleitorDTO) {
		return eleitorDTO.nome.compareToIgnoreCase(nome);
	}
	
	@Override
	public boolean equals(Object obj) {
		return numeroIscricao.equals(((EleitorDTO)obj).numeroIscricao);
	}
}
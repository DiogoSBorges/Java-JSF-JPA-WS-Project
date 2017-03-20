package br.com.diogo.controller.organizacao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.xml.ws.Endpoint;

import br.com.diogo.model.Organizacao;
import br.com.diogo.repository.OrganizacaoRepository;
import br.com.diogo.ws.WSOrganizacaoImpl;

@ManagedBean
@ViewScoped
public class OrganizacaoController implements Serializable {
	private static final long serialVersionUID = 7999091301085591232L;

	private OrganizacaoRepository organizacaoRepository = null;
	private List<Organizacao> organizacoes;

	// Endpint WS
	// Endpoint ep = null;

	// dadosForm
	private String orgNome;
	private String orgCnpj;
	private String orgTelefone;
	private String orgEndereco;

	@PostConstruct
	public void init() {
		organizacaoRepository = new OrganizacaoRepository();
		organizacoes = organizacaoRepository.buscarTodasOrganizacao();

		// InstanciaWS
		// ep = Endpoint.create(new WSOrganizacaoImpl());

	}

	public void salvaOrg() {
		Organizacao org = new Organizacao();
		org.setNome(orgNome);
		org.setCnpj(orgCnpj);
		org.setTelefone(orgTelefone);
		org.setEndereco(orgEndereco);
		organizacaoRepository.salvarOrganizacao(org);
	}

	// public void iniciaWS() {
	// ep.publish("http://localhost:8085/WS/wsorganizacao");
	// System.out.println("INICIOU WS");
	// }
	//
	// public void pararWS() {
	// ep.stop();
	// System.out.println("Paraou WS");
	// }

	// getters and setters

	public List<Organizacao> getOrganizacoes() {
		return organizacoes;
	}

	public void setOrganizacoes(List<Organizacao> organizacoes) {
		this.organizacoes = organizacoes;
	}

	public String getOrgNome() {
		return orgNome;
	}

	public void setOrgNome(String orgNome) {
		this.orgNome = orgNome;
	}

	public String getOrgCnpj() {
		return orgCnpj;
	}

	public void setOrgCnpj(String orgCnpj) {
		this.orgCnpj = orgCnpj;
	}

	public String getOrgTelefone() {
		return orgTelefone;
	}

	public void setOrgTelefone(String orgTelefone) {
		this.orgTelefone = orgTelefone;
	}

	public String getOrgEndereco() {
		return orgEndereco;
	}

	public void setOrgEndereco(String orgEndereco) {
		this.orgEndereco = orgEndereco;
	}

}

package br.com.diogo.ws;

import java.util.List;

import javax.jws.WebService;

import br.com.diogo.model.Organizacao;
import br.com.diogo.repository.OrganizacaoRepository;

@WebService(endpointInterface = "br.com.diogo.ws.WSOrganizacao")
public class WSOrganizacaoImpl implements WSOrganizacao {

	@Override
	public List<Organizacao> getAllOrganizacao() {
		OrganizacaoRepository organizacaoRepository = new OrganizacaoRepository();

		return organizacaoRepository.buscarTodasOrganizacao();
	}

	@Override
	public String salvarOrganizacao(Organizacao org) {

		OrganizacaoRepository organizacaoRepository = new OrganizacaoRepository();
		organizacaoRepository.salvarOrganizacao(org);

		return "Salvo Com Sucesso !! ID Organização: " + org.getId();
	}

}

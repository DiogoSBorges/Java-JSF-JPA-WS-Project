package br.com.diogo.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import br.com.diogo.model.Organizacao;

@WebService
@SOAPBinding(style = Style.RPC)
public interface WSOrganizacao {
	
	@WebMethod List<Organizacao> getAllOrganizacao();
	
	@WebMethod String salvarOrganizacao(Organizacao org);

}

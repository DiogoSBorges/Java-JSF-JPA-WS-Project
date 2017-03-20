package br.com.diogo.ws;

import javax.xml.ws.Endpoint;

public class IniciaWS {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8085/WS/wsorganizacao", new WSOrganizacaoImpl());
	}

}

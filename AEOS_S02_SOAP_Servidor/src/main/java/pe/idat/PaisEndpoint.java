package pe.idat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import pe.idat.ws.GetPaisResponse;
import pe.idat.ws.GetPaisRequest;

@Endpoint
public class PaisEndpoint {

	private static final String NAMESPACE_URI = "http://idat.pe/ws";
	private PaisRepositorio repo;
	
	@Autowired
	public PaisEndpoint(PaisRepositorio repo) {
		this.repo = repo;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPaisRequest")
	@ResponsePayload
	public GetPaisResponse getCountry(@RequestPayload GetPaisRequest rq) {
		GetPaisResponse rp = new GetPaisResponse();
		rp.setPais(repo.buscarPais(rq.getNombre()));
		return rp;
	}
	
}

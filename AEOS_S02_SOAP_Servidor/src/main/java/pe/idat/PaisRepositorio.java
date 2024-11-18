package pe.idat;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import jakarta.annotation.PostConstruct;
import pe.idat.ws.Pais;
import pe.idat.ws.Moneda;

@Component
public class PaisRepositorio {

	private static final Map<String, Pais> paises = new HashMap<>();
	
	@PostConstruct
	public void initData() {
		Pais peru = new Pais();
		peru.setNombre("Perú");
		peru.setCapital("Lima");
		peru.setPoblacion(34000000);
		peru.setMoneda(Moneda.SOL);
		paises.put(peru.getNombre(), peru);
		
		Pais ecuador = new Pais();
		ecuador.setNombre("Ecuador");
		ecuador.setCapital("Quito");
		ecuador.setPoblacion(18000000);
		ecuador.setMoneda(Moneda.DÓLAR);
		paises.put(ecuador.getNombre(), ecuador);
		
		Pais venezuela = new Pais();
		venezuela.setNombre("Venezuela");
		venezuela.setCapital("Caracas");
		venezuela.setPoblacion(28000000);
		venezuela.setMoneda(Moneda.BOLÍVAR);
		paises.put(venezuela.getNombre(), venezuela);
	}
	
	public Pais  buscarPais(String nombre) {
		Assert.notNull(nombre, "El nombre no debe ser Nulo.");
		return paises.get(nombre);
	}
}

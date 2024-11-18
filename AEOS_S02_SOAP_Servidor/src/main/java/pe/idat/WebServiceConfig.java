package pe.idat;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {
	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> MDS (ApplicationContext ac){
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(ac);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<>(servlet, "/ws/*");
	}
	
	@Bean(name="paises")
	public DefaultWsdl11Definition dw11d(XsdSchema paisesSchema) {
		DefaultWsdl11Definition wsdlD = new DefaultWsdl11Definition();
		wsdlD.setPortTypeName("PaisPort");
		wsdlD.setLocationUri("/ws");
		wsdlD.setTargetNamespace("http://idat.pe/ws");
		wsdlD.setSchema(paisesSchema);
		return wsdlD;
	}
	
	@Bean
	public XsdSchema paisesSchema() {
		return new SimpleXsdSchema(new ClassPathResource("paises.xsd"));
	}
	
}






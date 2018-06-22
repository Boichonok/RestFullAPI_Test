import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import org.jboss.resteasy.util.Base64;

import entitiea.Product;

public class DemoRestClientModel {

	private String username = "acc2";
	private String password = "123";
	
	
	//private String Base_URL_Sequrity = "http://localhost:8080/MyFirstRESTfulAPI/api/demo/";
	private String Base_URL = "http://localhost:8080/MyFirstRESTfulAPI/api/";
	private WebResource webResource;
	private Client client;
	
	public DemoRestClientModel() {
		this.client = Client.create(new DefaultClientConfig());
		this.webResource = this.client.resource(Base_URL).path("demo");
		
	}
	
	public ClientResponse helloWorld() {
		ClientResponse response = null;
		try {
			WebResource resource = this.webResource;
			response = resource.path("helloworld")
					.type(MediaType.TEXT_PLAIN)
					.get(ClientResponse.class);
		} catch (Exception e) {
			response = null;
		}
		return response;
	}
	
	public ClientResponse hello(String fullName) {
		ClientResponse clientResponse = null;
		try {
			WebResource resources = this.webResource;
			clientResponse = resources.path("hello/" + fullName)
					.type(MediaType.TEXT_PLAIN)
					.get(ClientResponse.class);
		} catch (Exception e) {
			clientResponse = null;
		}
		return clientResponse;
	}
	
	public ClientResponse sum(int a, int b) {
		ClientResponse clientResponse = null;
		try {
			WebResource resource = this.webResource;
			clientResponse = resource.path("sum/" + a + "/" + b)
					.type(MediaType.TEXT_PLAIN)
					.get(ClientResponse.class);
		} catch (Exception e) {
			clientResponse = null;
		}
		return clientResponse;
	}
	
	public ClientResponse findProductFromJSON() {
		ClientResponse clientResponse = null;
		try {
			WebResource resource = this.webResource;
			clientResponse = resource.path("findByJson")
					.type(MediaType.APPLICATION_JSON)
					.get(ClientResponse.class);
		} catch(Exception e) {
			clientResponse = null;
		}
		return clientResponse;
	}
	public ClientResponse findProductListFromJSON() {
		ClientResponse clientResponse =  null;
		try {
			WebResource resource = this.webResource;
			clientResponse = resource.path("findListByJson")
					.type(MediaType.APPLICATION_JSON)
					.get(ClientResponse.class);
		} catch (Exception e) {
			// TODO: handle exception
			clientResponse = null;
		}
		return clientResponse;
	}
	
	public ClientResponse findProductFromXML() {
		ClientResponse clientResponse = null;
		try {
			WebResource resource = this.webResource;
			clientResponse = resource.path("findByXML")
					.type(MediaType.APPLICATION_XML)
					.get(ClientResponse.class);
		} catch (Exception e) {
			// TODO: handle exception
			clientResponse = null;
		}
		return clientResponse;
	}
	
	public ClientResponse findProductListFromXML() {
		ClientResponse clientResponse = null;
		try {
			WebResource resource = this.webResource;
			clientResponse = resource.path("findListByXML")
					.type(MediaType.APPLICATION_XML)
					.get(ClientResponse.class);
		} catch (Exception e) {
			// TODO: handle exception
			clientResponse = null;
		}
		return clientResponse;
	}
	
	public ClientResponse creatProduct(Product product) {
		ClientResponse clientResponse = null;
		try {
			WebResource resources = this.webResource;
			clientResponse = resources.path("creatProduct")
					.accept(MediaType.APPLICATION_JSON)
					.post(ClientResponse.class,product);
			
		} catch (Exception e) {
			clientResponse = null;
		}
		return clientResponse;
	}
	
	public ClientResponse updateProductInfo(Product product) {
		ClientResponse clientResponse = null;
		try {
			WebResource resources = this.webResource;
			clientResponse = resources.path("updateProduct")
					.accept(MediaType.APPLICATION_JSON)
					.put(ClientResponse.class, product);
		} catch (Exception e) {
			clientResponse = null;
		}
		return clientResponse;
	}
	
	public ClientResponse deletProductById(String id) {
		ClientResponse clientResponse = null;
		try {
			WebResource resource = this.webResource;
			clientResponse = resource.path("deletProductByID:/" + id)
					.delete(ClientResponse.class);
		} catch (Exception e) {
			// TODO: handle exception
			clientResponse = null;
		}
		return clientResponse;
	}
	
	public ClientResponse work1() {
		ClientResponse cientResponse = null;
		try {
			WebResource resource = this.webResource;
			cientResponse = resource.path("work1")
					.type(MediaType.TEXT_PLAIN)
					.get(ClientResponse.class);
		} catch (Exception e) {
			// TODO: handle exception
			cientResponse = null;
		}
		return cientResponse;
	}
	
	public ClientResponse work2() {
		ClientResponse clientResponse = null;
		try {
			String authStringAccount = new String(Base64.encodeBytes((this.username + ":" + this.password).getBytes()));
			WebResource resource = this.webResource;
			clientResponse = resource.path("work2")
					.type(MediaType.TEXT_PLAIN)
					.header("Authorization", "Basic " + authStringAccount)
					.get(ClientResponse.class);
		} catch (Exception e) {
			// TODO: handle exception
			clientResponse = null;
		}
		return clientResponse;
	}
	public ClientResponse work3() {
		ClientResponse clientResponse = null;
		try {
			String authStringAccount = new String(Base64.encodeBytes((this.username + ":" + this.password).getBytes()));
			WebResource resource = this.webResource;
			clientResponse = resource.path("work3")
					.header("Authorization", "Basic " + authStringAccount)
					.type(MediaType.TEXT_PLAIN)
					.get(ClientResponse.class);
		} catch (Exception e) {
			// TODO: handle exception
			clientResponse = null;
		}
		return clientResponse;
	}
	
	public ClientResponse work4() {
		ClientResponse clientResponse = null;
		try {
			String authStringAccount = new String(Base64.encodeBytes((this.username + ":" + this.password).getBytes()));
			WebResource resource = this.webResource;
			clientResponse = resource.path("work4")
					.header("Authorization", "Basic " + authStringAccount)
					.type(MediaType.TEXT_PLAIN)
					.get(ClientResponse.class);
		} catch (Exception e) {
			// TODO: handle exception
			clientResponse = null;
		}
		return clientResponse;
	}
}

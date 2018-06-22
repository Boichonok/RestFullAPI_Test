import java.util.List;

import javax.ws.rs.core.Response;

import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.ClientResponse;

import entitiea.Product;

public class Main {
	public static void main(String[] args) {
		DemoRestClientModel demoRestClientModel = new DemoRestClientModel();
		
		checkStatus(demoRestClientModel);
		helloPerson(demoRestClientModel, "私は名前をAleksanderです。");
		sumNumbers(demoRestClientModel, 12, 12);
		
		testWork4(demoRestClientModel);
		testWork3(demoRestClientModel);		
		testWork2(demoRestClientModel);
		
		/*checkStatus(demoRestClientModel);
		helloWorld(demoRestClientModel);
		helloPerson(demoRestClientModel, "私は名前をAleksanderです。");
		sumNumbers(demoRestClientModel, 12, 12);
		checkStatus(demoRestClientModel);
		findProductFromJSON(demoRestClientModel);
		checkStatus(demoRestClientModel);
		findProductFromXML(demoRestClientModel);
		checkStatus(demoRestClientModel);
		findProductListFromJSON(demoRestClientModel);
		checkStatus(demoRestClientModel);
		findProductListFromXML(demoRestClientModel);
		creatProduct(demoRestClientModel,"pr5","Fresh Juse",15.5d);
		creatProduct(demoRestClientModel,"pr4","Fresh",5.5d);
		updateProduct(demoRestClientModel, "pr6", "Bear", 25.5d);
		updateProduct(demoRestClientModel, "pr4","Fresh",45.5d);
		deletProductById(demoRestClientModel, "pr5");
		deletProductById(demoRestClientModel, "pr5");
		deletProductById(demoRestClientModel, "pr3");*/
		
	}
	private static void checkStatus(DemoRestClientModel demoRestClientModel) {
		ClientResponse clientResponse = demoRestClientModel.helloWorld();
		if(clientResponse != null) {
			int statusCode = clientResponse.getStatus();
			System.out.println("Respounse Status: " + statusCode);
		} else {
			System.out.println("Can not access checkStatus Method");
		}
	}
	
	private static void helloWorld(DemoRestClientModel demoRestClientModel) {
		ClientResponse clientResponse = demoRestClientModel.helloWorld();
		if(clientResponse != null) {
			
			System.out.println("Result: " + clientResponse.getEntity(String.class));
		} else {
			System.out.println("Can not access helloWorld Method");
		}
	}
	
	private static void helloPerson(DemoRestClientModel demoRestClientModel, String person_s_name) {
		ClientResponse clientResponse = demoRestClientModel.hello(person_s_name);
		if (clientResponse != null) {
			
			System.out.println("Result: " + clientResponse.getEntity(String.class));
		} else {
			System.out.println("Can not access helloPerson Method");
		}
	}
	
	private static void sumNumbers(DemoRestClientModel demoRestClientModel, int firstN, int secondN) {
		ClientResponse clientResponse = demoRestClientModel.sum(firstN, secondN);
		if (clientResponse != null) {
			
			System.out.println("Result: " + clientResponse.getEntity(String.class));
		} else {
			System.out.println("Can not access sumNumbers Method");
		}
	}
	
	private static void findProductFromJSON(DemoRestClientModel demoRestClientModel) {
		ClientResponse clientResponse = demoRestClientModel.findProductFromJSON();
		if(clientResponse != null) {
			Product product = clientResponse.getEntity(Product.class);
			System.out.println("From JSON");
			System.out.println("Product ifno: \n id: " + product.getId() + "\n Name: " + product.getName() + "\n Price: " + product.getPrice() + " UAH" );
		} else {
			System.out.println("Can not access findProductFromJSON Method");
		}
	}
	
	private static void findProductListFromJSON(DemoRestClientModel demoRestClientModel) {
		ClientResponse clientResponse = demoRestClientModel.findProductListFromJSON();
		if(clientResponse != null) {
			GenericType<List<Product>> genericType = new GenericType<List<Product>>(){};
			List<Product> products = clientResponse.getEntity(genericType);
			System.out.println("List From JSON");
			for (Product product : products) {
				
				System.out.println("\n Id: " + product.getId());
				System.out.println("\n Name: " + product.getName());
				System.out.println("\n price: " + product.getPrice());
				System.out.println("===============================");
			}
		} else {
			System.out.println("Can not access findProductListFromJSON Method");
		}
	}
	
	private static void findProductFromXML(DemoRestClientModel demoRestClientModel) {
		ClientResponse clientResponse = demoRestClientModel.findProductFromXML();
		if(clientResponse != null) {
			Product product = clientResponse.getEntity(Product.class);
			System.out.println("From XML");
			System.out.println("Product ifno: \n id: " + product.getId() + "\n Name: " + product.getName() + "\n Price: " + product.getPrice() + " UAH" );
	
		} else {
			System.out.println("Can not access findProductFromXML Method");
		}
	}
	
	private static void findProductListFromXML(DemoRestClientModel demoRestClientModel) {
		ClientResponse clientResponse = demoRestClientModel.findProductListFromXML();
		if(clientResponse != null) {
			GenericType<List<Product>> genericType = new GenericType<List<Product>>() {};
			List<Product> products = clientResponse.getEntity(genericType);
			System.out.println("List From XML");
			for (Product product : products) {
				
				System.out.println("\n Id: " + product.getId());
				System.out.println("\n Name: " + product.getName());
				System.out.println("\n price: " + product.getPrice());
				System.out.println("===============================");
			}
		} else {
			System.out.println("Can not access findProductListFromXML Method");
		}
	}
	
	private static void creatProduct(DemoRestClientModel demoRestClientModel,  String id,String name, double price) {
		Product product = new Product();
		product.setId(id);
		product.setName(name);
		product.setPrice(price);
		ClientResponse clientResponse = demoRestClientModel.creatProduct(product);
		if(clientResponse != null) {
			checkStatus(demoRestClientModel);
		}else {
			System.out.println("Can not access creatProduct web Method");
		}
	}
	
	private static void updateProduct(DemoRestClientModel demoRestClientModel, String id,String name, double price) {
		Product product = new Product();
		product.setId(id);
		product.setName(name);
		product.setPrice(price);
		ClientResponse clientResponse = demoRestClientModel.updateProductInfo(product);
		if(clientResponse != null) {
			checkStatus(demoRestClientModel);
		} else {
			System.out.println("Can not access updateProduct web Method");
		}
	}
	private static void deletProductById(DemoRestClientModel demoRestClientModel,String id) {
		ClientResponse clientResponse = demoRestClientModel.deletProductById(id);
		if(clientResponse != null) {
			checkStatus(demoRestClientModel);
		} else {
			System.out.println("Can not access deletProductById web Method");
		}
	}
	
	private static void testWork1(DemoRestClientModel demoRestClientModel) {
		ClientResponse clientResponse = demoRestClientModel.work1();
		if(clientResponse != null) {
			
			System.out.println("\n Work1 result: " + clientResponse.getEntity(String.class));
		}else {
			System.out.println("Can not access testWork1 web Method");
		}
	}
	
	private static void testWork2(DemoRestClientModel demoRestClientModel) {
		ClientResponse clientResponse = demoRestClientModel.work2();
		if(clientResponse != null) {
			
			
			System.out.println("\n Work2 result: " + clientResponse.getEntity(String.class));
		} else {
			System.out.println("Can not access testWork2 web Method");
		}
	}
	private static void testWork3(DemoRestClientModel demoRestClientModel) {
		ClientResponse clientResponse = demoRestClientModel.work3();
		if(clientResponse != null) {
			
			System.out.println("\n Work3 result: " + clientResponse.getEntity(String.class));
		} else {
			System.out.println("Can not access testWork3 web Method");
		}
	}
	
	private static void testWork4(DemoRestClientModel demoRestClientModel) {
		ClientResponse clientResponse = demoRestClientModel.work4();
		if(clientResponse != null) {
			
			System.out.println("\n Work4 result: " + clientResponse.getEntity(String.class));
		} else {
			System.out.println("Can not access testWork4 web Method");
		}
	}
	
	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}
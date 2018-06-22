package controllers;
import java.util.ArrayList;

import javax.annotation.security.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import java.util.List;
import entities.Product;



@Path("demo")
public class DemoRestController {
	
	@GET
	@Path("helloworld")
	@Produces({MediaType.TEXT_PLAIN})
	public Response helloWorld() {
		try {
			return Response.ok("Hello World").build();
		} catch(Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	
	@GET
	@Path("hello/{fullName}")
	@Produces({MediaType.TEXT_PLAIN})
	public Response hello(@PathParam("fullName") String fullName) {
		try {
			return Response.ok("Hi! " + fullName).build();
		}catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	
	@GET
	@Path("sum/{a}/{b}")
	@Produces({MediaType.TEXT_PLAIN})
	public Response sum(@PathParam("a") int a, @PathParam("b") int b) {
		try {
			return Response.ok(String.valueOf(a + b)).build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	
	@GET
	@Path("findByJson")
	@Produces({MediaType.APPLICATION_JSON})
	public Response findByJson() {
		try {
			Product product = new Product("pr1", "tomato", 150.5d);
			return Response.ok(product,MediaType.APPLICATION_JSON).build();
		}catch(Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	
	@GET
	@Path("findListByJson")
	@Produces({MediaType.APPLICATION_JSON})
	public Response findListByJson() {
		try {
			List<Product> productList = new ArrayList<Product>();
			productList.add(new Product("pr1", "Fresh tomato", 170.7d));
			productList.add(new Product("pr2", "Chiken", 250.05d));
			productList.add(new Product("pr3", "Meat", 357.5d));
			GenericEntity<List<Product>> genericEntity = new GenericEntity<List<Product>>(productList) {};
			return Response.ok(genericEntity,MediaType.APPLICATION_JSON).build();
		}catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	
	@GET
	@Path("findByXML")
	@Produces({MediaType.APPLICATION_XML})
	public Response findByXML() {
		try {
			Product product = new Product("pr1","Stake",235.0d);
			return Response.ok(product).build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	
	@GET
	@Path("findListByXML")
	@Produces({MediaType.APPLICATION_XML})
	public Response findListByXML() {
		try {
			List<Product> productList = new ArrayList<Product>();
			productList.add(new Product("pr1","Fresh Meat",415.0d));
			productList.add(new Product("pr2","Potaito",75.0d));
			productList.add(new Product("pr3","Pig",800.0d));
			productList.add(new Product("pr4","mashrums",97.0d));
			GenericEntity<List<Product>> genericEntity = new GenericEntity<List<Product>>(productList) {};
			return Response.ok(genericEntity,MediaType.APPLICATION_ATOM_XML).build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	
	@POST
	@Path("creatProduct")
	@Consumes({MediaType.APPLICATION_JSON})
	public Response creatProduct(Product product) {
		try {
			System.out.println("Server Info: New Product");
			System.out.println("\n ID: " + product.getId());
			System.out.println("\n Name: " + product.getName());
			System.out.println("\n Price: " + product.getPrice());
			return Response.ok().build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	
	@PUT
	@Path("updateProduct")
	@Consumes({MediaType.APPLICATION_JSON})
	public Response updateProduct(Product product) {
		try {
			System.out.println("Server Info: Update Product information");
			System.out.println("\n Id: " + product.getId());
			System.out.println("\n Name: " + product.getName());
			System.out.println("\n Price: " + product.getPrice());
			return Response.ok().build();
		} catch (Exception e) {
			// TODO: handle exception
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	
	@DELETE
	@Path("deletProductByID:/{id}")
	public Response deletProductById(@PathParam("id") String id) {
		try {
			System.out.println("ID is deleted: " + id);
			return Response.ok().build();
		} catch (Exception e) {
			// TODO: handle exception
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	
	@GET
	@Path("work1")
	@Produces({MediaType.TEXT_PLAIN})
	@PermitAll
	public String work1() {
		return "Work 1";
		/*try {
			return Response.ok("Work 1").build();
		} catch (Exception e) {
			// TODO: handle exception
			return Response.status(Response.Status.BAD_REQUEST).build();
		}*/
	}
	
	@GET
	@Path("work2")
	@Produces({MediaType.TEXT_PLAIN})
	@RolesAllowed({ "employee" })
	public String work2() {
		return "Work 2";
		/*try {
			return Response.ok("Work 2").build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}*/
	}
	
	@GET
	@Path("work3")
	@Produces({MediaType.TEXT_PLAIN})
	@RolesAllowed({ "admin", "employee" })
	public String work3() {
		return "Work 3";
		/*try {
			return Response.ok("Work 3").build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}*/
	}
	
	@GET
	@Path("work4")
	@Produces({MediaType.TEXT_PLAIN})
	@RolesAllowed({ "superadmin", "admin", "employee" })
	public String work4() {
		//try {
			return "Workd 4";//Response.ok("Work 4").build();
		//} catch (Exception e) {
		//	return Response.status(Response.Status.BAD_REQUEST).build();
		//}
	}
}

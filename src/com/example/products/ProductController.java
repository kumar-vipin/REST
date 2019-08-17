package com.example.products;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.example.repo.ProductRepo;

//products/{productId}
@Path("products")
public class ProductController {

	private ProductRepo productRepo = ProductRepo.getRepoInstance();

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Product> getProducts() {
		return productRepo.getProducts();
	}

	@GET
	@Path("/{productId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Product getProductById(@PathParam("productId") int productId) {
		return productRepo.findProductById(productId);
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void saveProduct(Product product) {
		productRepo.saveProduct(product);
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void updateProduct(Product product, @QueryParam("productId") int productId) {
		Product p = productRepo.findProductById(productId);
		if(product.getPrice() != 0) {
			p.setPrice(product.getPrice());	
		}
		if(product.getProductName() != null) {
			p.setProductName(product.getProductName());
		}
		productRepo.saveProduct(p);
	}
	
	@DELETE
	@Path("/{productId}")
	public void deleteProduct(@PathParam("productId") int productId) {
		productRepo.deleteProduct(productId);
	}

	@GET
	@Path("testString")
	@Produces(MediaType.TEXT_PLAIN)
	public String getDemoString() {
		return "Hello REST";
	}

	@GET
	@Path("testString1")
	@Produces(MediaType.TEXT_PLAIN)
	public String getDemoStrings() {
		return "Hello REST 1 ";
	}
}

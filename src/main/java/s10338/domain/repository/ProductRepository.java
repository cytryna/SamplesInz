package s10338.domain.repository;

import s10338.domain.Product;

import java.util.List;
import java.util.Map;

public interface ProductRepository {

    List<Product> getAllProducts();

    List<Product> getProductsByCategory(String category);

    List<Product> getProductsByFilter(Map<String, List<String>> filter);

    Product getProductById(String productID);

    List<Product> getProductsByManufacturer(String manufacturer);

    void addProduct(Product product);
}

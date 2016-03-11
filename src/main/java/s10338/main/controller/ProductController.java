package s10338.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import s10338.main.service.ProductService;

import java.util.Map;


@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping
    public String list(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @RequestMapping("/all")
    public String listAll(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @RequestMapping("/{category}")
    public String listByCategory(Model model, @PathVariable("category") String category) {
        model.addAttribute("products", productService.getProductsByCategory(category));
        return "products";
    }

    @RequestMapping("/filter/{byCryteria}")
    public String listByFilter(Model model, @MatrixVariable(pathVar = "byCryteria") Map filter) {
        model.addAttribute("products", productService.getProductsByFilter(filter));
        return "products";
    }
}

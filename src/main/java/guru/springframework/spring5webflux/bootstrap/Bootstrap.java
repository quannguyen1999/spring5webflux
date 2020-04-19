package guru.springframework.spring5webflux.bootstrap;

import guru.springframework.spring5webflux.domain.Category;
import guru.springframework.spring5webflux.domain.Vendor;
import guru.springframework.spring5webflux.repositories.CategoryRepository;
import guru.springframework.spring5webflux.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {
    private final CategoryRepository categoryRepository;
    private final VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(categoryRepository.count().block()==0){
            //load data
            System.out.println("Loading data on bootstrap");

            categoryRepository.save(Category.builder().description("Fruits").build()).block();

            categoryRepository.save(Category.builder().description("Nuts").build()).block();

            categoryRepository.save(Category.builder().description("Meats").build()).block();

            System.out.println("Loaded categories:"+categoryRepository.count().block());

            vendorRepository.save(Vendor.builder().firstName("quan").lastName("anh").build()).block();

            vendorRepository.save(Vendor.builder().firstName("kim").lastName("quyen").build()).block();

            System.out.println("Loaded vendors:"+vendorRepository.count().block());
        }
    }
}

interface CustomerRepository {
    String findCustomerById(String id);
}

class CustomerRepositoryImpl implements CustomerRepository {
    public String findCustomerById(String id) {
        if (id.equals("C100")) {
            return "John Doe";
        }
        return "Customer Not Found";
    }
}

class CustomerService {
    private CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void displayCustomer(String id) {
        String customerName = repository.findCustomerById(id);
        System.out.println("Customer Found -> ID: " + id + ", Name: " + customerName);
    }
}

public class DependencyInjectionPattern {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();

        CustomerService service = new CustomerService(repository);

        service.displayCustomer("C100");
        service.displayCustomer("C200");
    }
}
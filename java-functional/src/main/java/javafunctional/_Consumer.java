package javafunctional;

import model.Customer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {
        Customer customer = new Customer("Maria", "000009999");
        imperative(customer);
        declarative(customer);
    }

    static void imperative(Customer customer) {
        greetCustomer(customer);
        greetCustomer(customer, true);
    }

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.getName() + "!");
    }

    static void greetCustomer(Customer customer, boolean showName) {
        System.out.println("Hello " + (showName ? customer.getName() : "User") + "!");
    }

    static void declarative(Customer customer) {
        Consumer<Customer> greetCustomerConsumer = customer1 -> System.out.println("Hello " + customer1.getName() + "!");
        greetCustomerConsumer.accept(customer);

        BiConsumer<Customer, Boolean> greetCustomerBiConsumer = (customer1, showName) -> System.out.println("Hello " +
                (showName ? customer1.getName() : "User") + "!");
        greetCustomerBiConsumer.accept(customer, false);
    }
}

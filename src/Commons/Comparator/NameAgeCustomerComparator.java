package Commons.Comparator;

import Model.Customer;

import java.util.Comparator;

public class NameAgeCustomerComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer customer1, Customer customer2) {
        if (customer1.getName() != customer2.getName()) {
            return customer1.getName().compareTo(customer2.getName());
        } else {
            if (customer1.getAge() == customer2.getAge()) {
                return 0;
            } else if (customer1.getAge() > customer2.getAge()) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}

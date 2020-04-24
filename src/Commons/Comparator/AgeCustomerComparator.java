package Commons.Comparator;

import Model.Customer;

import java.util.Comparator;

public class AgeCustomerComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer customer1, Customer customer2) {
        if (customer1.getAge() == customer2.getAge()) {
            return 0;
        } else if (customer1.getAge() > customer2.getAge()) {
            return 1;
        } else {
            return -1;
        }
    }
}

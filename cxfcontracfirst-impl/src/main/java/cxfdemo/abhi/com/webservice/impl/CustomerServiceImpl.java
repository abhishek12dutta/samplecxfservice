package cxfdemo.abhi.com.webservice.impl;

import cxfdemo.abhi.com.Customer;
import cxfdemo.abhi.com.CustomerService;
import cxfdemo.abhi.com.NoSuchCustomerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abhishek on 7/24/2015.
 */
public class CustomerServiceImpl implements CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    private static List<Customer> customerList = new ArrayList<Customer>();

    static{
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        customer1.setName("Pseudo Architect");
        customer1.setCustomerId(12345);
        customer2.setName("Real Architect");
        customer2.setCustomerId(54321);
        customerList.add(customer1);
        customerList.add(customer2);
    }

    public List<Customer> getCustomersByName(String name) throws NoSuchCustomerException {
        logger.debug("Inside getCustomersByName()");
        long now = System.currentTimeMillis();

        logger.debug("Exit getCustomersByName()");
        logger.debug("Total Response Time of getCustomersByName service: [" + (System.currentTimeMillis() - now) + "] milisec");
        return customerList;
    }

    public boolean updateCustomer(Customer customer) throws NoSuchCustomerException {
        logger.debug("Inside getCustomersByName()");
        long now = System.currentTimeMillis();
        boolean customerFound= false;
        for(Customer customers : customerList){
            if(customers.getCustomerId()==customer.getCustomerId()){
                //then update
                customerFound = true;
                logger.debug("Customer updated successfully...");
                break;
            }
        }
        if(!customerFound){
            throw new NoSuchCustomerException("Customer not found");
        }

        logger.debug("Exit getCustomersByName()");
        logger.debug("Total Response Time of getCustomersByName service: [" + (System.currentTimeMillis() - now) + "] milisec");
        return customerFound;
    }
}

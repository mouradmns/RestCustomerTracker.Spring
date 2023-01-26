package com.spring.dao;

import com.spring.entities.Customer;
import org.springframework.stereotype.Repository;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{


            EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    @Override
    public List<Customer> getCustomers() {
        EntityManager em=emf.createEntityManager();
        List<Customer> customers = (List<Customer>)em.createQuery("SELECT c FROM Customer c order by c.firstName  ")
                                                    .getResultList();
        return customers;
    }


    @Override
    public void saveCustomer(Customer theCustomer) {

        EntityManager em =emf.createEntityManager();
        em.getTransaction().begin();

        Customer customer = em.find(Customer.class,theCustomer.getId());

        if (customer==null){
            em.persist(theCustomer);
        }
        else {
            customer.setFirstName(theCustomer.getFirstName());
            customer.setLastName(theCustomer.getLastName());
            customer.setEmail(theCustomer.getEmail());
            em.merge(customer);
                }
        em.getTransaction().commit();
    }

    @Override
    public Customer getCustomer(int theId) {
        EntityManager em =emf.createEntityManager();
        em.getTransaction().begin();
        Customer customer= em.find(Customer.class,theId);
        return customer ;
    }

    @Override
    public void deleteCustomer(int theId) {

        EntityManager em = emf.createEntityManager();
        Customer customer = em.find(Customer.class,theId);
        em.remove(customer);
        em.getTransaction().begin();
        em.getTransaction().commit();

    }
}

package com.shehriyar.SSSpringBootDemo.repository;

import com.shehriyar.SSSpringBootDemo.model.Customer;
import com.shehriyar.SSSpringBootDemo.model.Customer;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {

    private final String FIND_ALL_CUSTOMERS_QUERY = "SELECT * FROM customer";
    private final String FIND_CUSTOMER_BY_ID = "SELECT * FROM customer WHERE id=";
    private final String DELETE_CUSTOMER_BY_ID = "DELETE FROM customer WHERE id=";

    public List<Customer> findAll(Connection db_con) {
        if (db_con != null) {
            List<Customer> customers = new ArrayList<>();

            try {
                Statement statement = db_con.createStatement();
                ResultSet resultSet = statement.executeQuery(FIND_ALL_CUSTOMERS_QUERY);
                while (resultSet.next()) {
                    Customer customer = new Customer();
                    customer.setCustomerFromResultSet(resultSet);
                    customers.add(customer);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return customers;
        }

        return null;
    }

    public Customer findById(Connection db_con, long id) {
        if (db_con != null) {
            Customer customer = new Customer();

            try {
                Statement statement = db_con.createStatement();
                ResultSet resultSet = statement.executeQuery(FIND_CUSTOMER_BY_ID + id);
                if (resultSet.next()) {
                    customer.setCustomerFromResultSet(resultSet);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return customer;
        }

        return null;
    }

    public boolean delete(Connection db_con, long id) {
        if (db_con != null) {
            try {
                Statement statement = db_con.createStatement();
                ResultSet resultSet = statement.executeQuery(DELETE_CUSTOMER_BY_ID + id);

                return resultSet.next();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    public boolean save(Connection db_con, Long id, Customer customer) {
        if (db_con != null) {
            try {
                Statement statement = db_con.createStatement();

                if (id == null) {
                    String CREATE_NEW_CUSTOMER_QUERY = "INSERT INTO customer (email,first_name,last_name,phone_num) VALUES ('%1$s','%2$s','%3$s','%4$s')";
                    CREATE_NEW_CUSTOMER_QUERY = String.format(
                            CREATE_NEW_CUSTOMER_QUERY,
                            customer.getEmail(),
                            customer.getFirstName(),
                            customer.getLastName(),
                            customer.getPhoneNumber()
                    );

                    statement.executeUpdate(CREATE_NEW_CUSTOMER_QUERY);
                    return true;
                } else {
                    ResultSet resultSet = statement.executeQuery(FIND_CUSTOMER_BY_ID + id);
                    if (resultSet.next()) {
                        String UPDATE_EXISTING_CUSTOMER_QUERY = "UPDATE customer SET email = '%1$s', first_name = '%2$s', last_name = '%3$s', phone_num = '%4$s') WHERE id = " + id;
                        UPDATE_EXISTING_CUSTOMER_QUERY = String.format(
                                UPDATE_EXISTING_CUSTOMER_QUERY,
                                customer.getEmail(),
                                customer.getFirstName(),
                                customer.getLastName(),
                                customer.getPhoneNumber()
                        );

                        statement.executeUpdate(UPDATE_EXISTING_CUSTOMER_QUERY);
                        return true;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        return false;
    }
}

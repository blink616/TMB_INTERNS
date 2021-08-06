package com.JDBC.repository;

import com.JDBC.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

    public List<Customer> AllCustomers(Connection con) throws SQLException {
        List<Customer> allCustomers = new ArrayList<Customer>();
        if (con != null) {
            String query = "select * from customer";
            try (Statement stmt = con.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    Customer newCustomer = new Customer();
                    newCustomer.addCustomer(Integer.parseInt(rs.getString("id")), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("phone_num"));
                    allCustomers.add(newCustomer);
                }

            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return allCustomers;
    }

    public Customer getById(Connection con, Long id) {
        String query = "select * from customer where id=" + id;
        Customer customer = new Customer();
        if (con != null) {
            try (Statement stmt = con.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);
                if (rs.next()) {
                    customer.addCustomer(Integer.parseInt(rs.getString("id")), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("phone_num"));
                }

            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return customer;
    }

    public boolean save(Connection con, Long id, Customer customer) {
        if (con != null) {
            try (Statement statement = con.createStatement()) {
                if (id == null) {
                    String query = "INSERT INTO customer (email,first_name,last_name,phone_num) VALUES ('%1$s','%2$s','%3$s','%4$s')";
                    query = String.format(
                            query,
                            customer.getEmail(),
                            customer.getFirstName(),
                            customer.getLastName(),
                            customer.getPhoneNumber()
                    );

                    statement.executeUpdate(query);
                    return true;
                } else {
                    ResultSet resultSet = statement.executeQuery("select * from customer where id = " + id);
                    if (resultSet.next()) {
                        String updateQuery = "UPDATE customer SET email = '%1$s', first_name = '%2$s', last_name = '%3$s', phone_num = '%4$s' WHERE id = " + id;
                        updateQuery = String.format(
                                updateQuery,
                                customer.getEmail(),
                                customer.getFirstName(),
                                customer.getLastName(),
                                customer.getPhoneNumber()
                        );

                        statement.executeUpdate(updateQuery);
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

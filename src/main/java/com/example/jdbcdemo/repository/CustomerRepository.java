package com.example.jdbcdemo.repository;


import com.example.jdbcdemo.DBConnection;
import com.example.jdbcdemo.domain.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerRepository{
    public Customer getById(long id){
            String query = "select * from customer where id="+id;
            Customer customer = null;
            try(Connection conn = DBConnection.make_connection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                customer = new Customer(rs.getLong("id"),rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("phone_num"));
            }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return customer;
            }
    public ArrayList<Customer> getAll(){
            String query = "select * from customer";
            ArrayList<Customer> customers = new ArrayList<>();
            try(Connection conn = DBConnection.make_connection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                customers.add(new Customer(rs.getLong("id"),rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("phone_num")));
            }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return customers;
            }
    public boolean deleteById(long id){
            String query = "delete from customer where id="+id;
            try(Connection conn = DBConnection.make_connection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);) {
            return true;
            } catch (SQLException e) {
            return false;
            }
            }
    public boolean save(String firstName, String lastName, String email, String phoneNumber){
            String query = "insert into customer(first_name,last_name,email,phone_num) values ('%1$s','%2$s','%3$s','%4$s')";
            query = String.format(query,firstName,lastName,email,phoneNumber);
            System.out.println(query);
            try(Connection conn = DBConnection.make_connection();
            Statement stmt = conn.createStatement()) {
                stmt.executeUpdate(query);
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            return false;
            }
            }
    public boolean update(long id,String firstName, String lastName, String email, String phoneNumber){
            String query = "update customer set description='%1$s',model='%2$s',brand='%3$s',color='%4$s',passenger_count=%5$s where id="+id;
            query = String.format(query,firstName,lastName,email,phoneNumber);
            System.out.println(query);
            try(Connection conn = DBConnection.make_connection();
            Statement stmt = conn.createStatement()) {
                stmt.executeUpdate(query);
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

}

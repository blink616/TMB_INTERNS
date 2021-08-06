package com.example.jdbcdemo.repository;

import com.example.jdbcdemo.DBConnection;
import com.example.jdbcdemo.domain.Car;
import com.example.jdbcdemo.domain.Customer;
import com.example.jdbcdemo.domain.Rental;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RentalRepository{

    public Rental getById(long id){
        Rental rental = null;
        Car car = null;
        Customer customer = null;
        try(Connection conn = DBConnection.make_connection()) {
            String query = "select * from rental where id="+id;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            long carId;
            long customerId;
            if (rs.next()) {
                rental = new Rental(rs.getLong("id"), rs.getDouble("amount"), rs.getLong("pick_up_date"), rs.getLong("return_date"), null, null);
                carId = rs.getLong("car_id");
                customerId = rs.getLong("customer_id");
            }
            else{
                return null;
            }
            query = "select * from car where id="+carId;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                car = new Car(rs.getLong("id"), rs.getString("description"), rs.getString("model"), rs.getString("brand"), rs.getString("color"), rs.getInt("passenger_count"));
            }
            query = "select * from customer where id="+customerId;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                customer = new Customer(rs.getLong("id"),rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("phone_num"));
            }
            rental.setCar(car);
            rental.setCustomer(customer);
        }
        catch (SQLException e) {
                e.printStackTrace();
        }
        return rental;
    }
    public ArrayList<Rental> getAll(){
        String query = "select * from rental";
        ArrayList<Rental> rentals = new ArrayList<>();
        try(Connection conn = DBConnection.make_connection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Rental rental = new Rental(rs.getLong("id"), rs.getDouble("amount"), rs.getLong("pick_up_date"), rs.getLong("return_date"), null, null);
                Long carId = rs.getLong("car_id");
                Long customerId = rs.getLong("customer_id");
                query = "select * from car where id="+carId;
                stmt = conn.createStatement();
                rs = stmt.executeQuery(query);
                if (rs.next()) {
                    Car car = new Car(rs.getLong("id"), rs.getString("description"), rs.getString("model"), rs.getString("brand"), rs.getString("color"), rs.getInt("passenger_count"));
                    rental.setCar(car);
                }
                query = "select * from customer where id="+customerId;
                stmt = conn.createStatement();
                rs = stmt.executeQuery(query);
                if (rs.next()) {
                    Customer customer = new Customer(rs.getLong("id"),rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("phone_num"));
                    rental.setCustomer(customer);
                }
                rentals.add(rental);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentals;
    }
    public boolean deleteById(long id){
        System.out.println(123);
        try(Connection conn = DBConnection.make_connection();) {
            String query = "select * from rental where id="+id;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            long carId;
            long customerId;
            if (rs.next()) {
                carId = rs.getLong("car_id");
                customerId = rs.getLong("customer_id");
            }
            else{
                System.out.println("no result");
                return false;
            }
            try {
                query = "delete from rental where id=" + id;
                stmt = conn.createStatement();
                stmt.executeUpdate(query);
            } catch (Exception e){ e.printStackTrace();}
            try {
                query = "delete from car where id=" + carId;
                stmt = conn.createStatement();
                stmt.executeUpdate(query);
            } catch (Exception e){e.printStackTrace();}
            try {
                query = "delete from customer where id=" + customerId;
                stmt = conn.createStatement();
                stmt.executeUpdate(query);
            } catch (Exception e){ e.printStackTrace();}
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean save(double amount, long pickUpDate, long returnDate, long carId, long customerId){
        String query = "insert into rental(amount,pick_up_date,return_date,car_id,customer_id) values ('%1$s','%2$s','%3$s','%4$s','%5$s')";
        query = String.format(query,amount,pickUpDate,returnDate,carId,customerId);
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
    public boolean update(long id, double amount, Long pickUpDate, Long returnDate){
        String query = "update rental set amount=%1$s,pick_up_date=%2$s,return_date=%3$s where id="+id;
        query = String.format(query,amount,pickUpDate,returnDate);
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

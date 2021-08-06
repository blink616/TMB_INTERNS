package com.example.jdbcdemo.repository;

import com.example.jdbcdemo.DBConnection;
import com.example.jdbcdemo.domain.Car;

import java.sql.*;
import java.util.ArrayList;


public class CarRepository {
    public Car getById(long id){
        String query = "select * from car where id="+id;
        Car car = null;
        try(Connection conn = DBConnection.make_connection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                car = new Car(rs.getLong("id"), rs.getString("description"), rs.getString("model"), rs.getString("brand"), rs.getString("color"), rs.getInt("passenger_count"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }
    public ArrayList<Car> getAll(){
        String query = "select * from car";
        ArrayList<Car> cars = new ArrayList<>();
        try(Connection conn = DBConnection.make_connection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                cars.add(new Car(rs.getLong("id"), rs.getString("description"), rs.getString("model"), rs.getString("brand"), rs.getString("color"), rs.getInt("passenger_count")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }
    public boolean deleteById(long id){
        String query = "delete from car where id="+id;
        try(Connection conn = DBConnection.make_connection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);) {
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    public boolean save(String description, String model, String brand, String color, int passengerCount){
        String query = "insert into car(description,model,brand,color,passenger_count) values ('%1$s','%2$s','%3$s','%4$s',%5$s)";
        query = String.format(query,description,model,brand,color,passengerCount);
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
    public boolean update(long id, String description, String model, String brand, String color, int passengerCount){
        String query = "update car set description='%1$s',model='%2$s',brand='%3$s',color='%4$s',passenger_count=%5$s where id="+id;
        query = String.format(query,description,model,brand,color,passengerCount);
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

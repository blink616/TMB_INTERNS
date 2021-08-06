package com.shehriyar.SSSpringBootDemo.repository;

import com.shehriyar.SSSpringBootDemo.model.Car;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepository {

    private final String FIND_ALL_CARS_QUERY = "SELECT * FROM car";
    private final String FIND_CAR_BY_ID = "SELECT * FROM car WHERE id=";
    private final String DELETE_CAR_BY_ID = "DELETE FROM car WHERE id=";

    public List<Car> findAll(Connection db_con) {
        if (db_con != null) {
            List<Car> cars = new ArrayList<>();

            try {
                Statement statement = db_con.createStatement();
                ResultSet resultSet = statement.executeQuery(FIND_ALL_CARS_QUERY);
                while (resultSet.next()) {
                    Car car = new Car();
                    car.setCarFromResultSet(resultSet);
                    cars.add(car);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return cars;
        }

        return null;
    }

    public Car findById(Connection db_con, long id) {
        if (db_con != null) {
            Car car = new Car();

            try {
                Statement statement = db_con.createStatement();
                ResultSet resultSet = statement.executeQuery(FIND_CAR_BY_ID + id);
                if (resultSet.next()) {
                    car.setCarFromResultSet(resultSet);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return car;
        }

        return null;
    }

    public boolean delete(Connection db_con, long id) {
        if (db_con != null) {
            try {
                Statement statement = db_con.createStatement();
                ResultSet resultSet = statement.executeQuery(DELETE_CAR_BY_ID + id);

                return resultSet.next();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    public boolean save(Connection db_con, Long id, Car car) {
        if (db_con != null) {
            try {
                Statement statement = db_con.createStatement();

                if (id == null) {
                    String CREATE_NEW_CAR_QUERY = "INSERT INTO car (brand,color,description,model,passenger_count) VALUES ('%1$s','%2$s','%3$s','%4$s','%5$d')";
                    CREATE_NEW_CAR_QUERY = String.format(
                        CREATE_NEW_CAR_QUERY,
                        car.getBrand(),
                        car.getColor(),
                        car.getDesc(),
                        car.getModel(),
                        car.getPassengerCount()
                    );

                    statement.executeUpdate(CREATE_NEW_CAR_QUERY);
                    return true;
                } else {
                    ResultSet resultSet = statement.executeQuery(FIND_CAR_BY_ID + id);
                    if (resultSet.next()) {
                        String UPDATE_EXISTING_CAR_QUERY = "UPDATE car SET brand = '%1$s', color = '%2$s', description = '%3$s', model = '%4$s', passenger_count = '%5$d') WHERE id = " + id;
                        UPDATE_EXISTING_CAR_QUERY = String.format(
                                UPDATE_EXISTING_CAR_QUERY,
                                car.getBrand(),
                                car.getColor(),
                                car.getDesc(),
                                car.getModel(),
                                car.getPassengerCount()
                        );

                        statement.executeUpdate(UPDATE_EXISTING_CAR_QUERY);
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

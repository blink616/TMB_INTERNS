package com.shehriyar.SSSpringBootDemo.repository;

import com.shehriyar.SSSpringBootDemo.model.Rental;
import com.shehriyar.SSSpringBootDemo.model.Rental;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RentalRepository {

    private final String FIND_ALL_RENTALS_QUERY = "SELECT * FROM rental";
    private final String FIND_RENTAL_BY_ID = "SELECT * FROM rental WHERE id=";
    private final String FIND_RENTAL_BY_CAR_ID = "SELECT * FROM rental WHERE car_id=";
    private final String FIND_RENTAL_BY_CUSTOMER_ID = "SELECT * FROM rental WHERE customer_id=";
    private final String DELETE_RENTAL_BY_ID = "DELETE FROM rental WHERE id=";

    public List<Rental> findAll(Connection db_con) {
        if (db_con != null) {
            List<Rental> rentals = new ArrayList<>();

            try {
                Statement statement = db_con.createStatement();
                ResultSet resultSet = statement.executeQuery(FIND_ALL_RENTALS_QUERY);
                while (resultSet.next()) {
                    Rental rental = new Rental();
                    rental.setRentalFromResultSet(resultSet);
                    rentals.add(rental);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return rentals;
        }

        return null;
    }

    public Rental findById(Connection db_con, long id) {
        if (db_con != null) {
            Rental rental = new Rental();

            try {
                Statement statement = db_con.createStatement();
                ResultSet resultSet = statement.executeQuery(FIND_RENTAL_BY_ID + id);
                if (resultSet.next()) {
                    rental.setRentalFromResultSet(resultSet);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return rental;
        }

        return null;
    }

    public List<Rental> findByCarId(Connection db_con, long id) {
        if (db_con != null) {
            List<Rental> rentals = new ArrayList<>();

            try {
                Statement statement = db_con.createStatement();
                ResultSet resultSet = statement.executeQuery(FIND_RENTAL_BY_CAR_ID + id);
                while (resultSet.next()) {
                    Rental rental = new Rental();
                    rental.setRentalFromResultSet(resultSet);
                    rentals.add(rental);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return rentals;
        }

        return null;
    }

    public List<Rental> findByCustomerId(Connection db_con, long id) {
        if (db_con != null) {
            List<Rental> rentals = new ArrayList<>();

            try {
                Statement statement = db_con.createStatement();
                ResultSet resultSet = statement.executeQuery(FIND_RENTAL_BY_CUSTOMER_ID + id);
                while (resultSet.next()) {
                    Rental rental = new Rental();
                    rental.setRentalFromResultSet(resultSet);
                    rentals.add(rental);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return rentals;
        }

        return null;
    }

    public boolean delete(Connection db_con, long id) {
        if (db_con != null) {
            try {
                Statement statement = db_con.createStatement();
                ResultSet resultSet = statement.executeQuery(DELETE_RENTAL_BY_ID + id);

                return resultSet.next();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    public boolean save(Connection db_con, Long id, Rental rental) {
        if (db_con != null) {
            try {
                Statement statement = db_con.createStatement();

                if (id == null) {
                    String CREATE_NEW_RENTAL_QUERY = "INSERT INTO rental (amount,pick_up_date,return_date,car_id,customer_id) VALUES ('%1$d','%2$d','%3$d','%4$d','%5$d')";
                    CREATE_NEW_RENTAL_QUERY = String.format(
                            CREATE_NEW_RENTAL_QUERY,
                            rental.getAmount(),
                            rental.getPickUpDate(),
                            rental.getReturnDate(),
                            rental.getCarId(),
                            rental.getCustomerId()
                    );

                    statement.executeUpdate(CREATE_NEW_RENTAL_QUERY);
                    return true;
                } else {
                    ResultSet resultSet = statement.executeQuery(FIND_RENTAL_BY_ID + id);
                    if (resultSet.next()) {
                        String UPDATE_EXISTING_RENTAL_QUERY = "UPDATE rental SET amount = '%1$d', pick_up_date = '%2$d', return_date = '%3$d') WHERE id = " + id;
                        UPDATE_EXISTING_RENTAL_QUERY = String.format(
                                UPDATE_EXISTING_RENTAL_QUERY,
                                rental.getAmount(),
                                rental.getPickUpDate(),
                                rental.getReturnDate()
                        );

                        statement.executeUpdate(UPDATE_EXISTING_RENTAL_QUERY);
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

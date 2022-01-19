package com.revature.repos;

import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClerkDAOImple implements ClerkDAO{
    @Override
    public List<Customer> findAllCustomers() {
        try (Connection conn = ConnectionUtil.connectToDB()){
            String sql = "SELECT * FROM customer_table;";

            Statement statement = conn.createStatement();
            ResultSet cell = statement.executeQuery(sql);

            List<Customer> result = new ArrayList<>();

            while(cell.next()) {
                Customer customer = new Customer();
                customer.setCustomerID(cell.getInt("customer_ID"));
                customer.setFirstName(cell.getString("first_name"));
                customer.setLastName(cell.getString("last_name"));
                customer.setAddress(cell.getString("address"));
                customer.setCity(cell.getString("city"));
                result.add(customer);
            }

            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<Customer>();
    }

    @Override
    public Customer findCustomerByID(int customerID) {
        try (Connection conn = ConnectionUtil.connectToDB()){

            String sql = "SELECT * FROM customer_table WHERE customer_id = "+customerID+";";

            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            Customer customer = new Customer();

            while(result.next()){
                customer.setCustomerID(result.getInt("customer_id"));
                customer.setFirstName(result.getString("first_name"));
                customer.setLastName(result.getString("last_name"));
                customer.setAddress(result.getString("address"));
                customer.setCity(result.getString("city"));
            }
            return customer;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean closeAccount(int customerID) {
        try (Connection conn = ConnectionUtil.connectToDB()){
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean transferMoney(int accountNumber, int amount) {
        try (Connection conn = ConnectionUtil.connectToDB()){
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

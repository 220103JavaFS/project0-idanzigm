package com.revature.repos;

import com.revature.models.Customer;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerDAOImple implements CustomerDAO{

    @Override
    public Customer seePersonalInfo(String username) {
        try (Connection conn = ConnectionUtil.connectToDB()){
            String sql = "SELECT * FROM login_table WHERE username = " + username + ";";

            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            if((result.getInt("customer_ID")) != 0) {
                ClerkDAO singleUse = new ClerkDAOImple();
                int customerID = result.getInt("customer_ID");

                return singleUse.findCustomerByID(customerID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean updatePersonalInfo(Customer customer) {
        try (Connection conn = ConnectionUtil.connectToDB()){
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean depositMoney(int amount) {
        try (Connection conn = ConnectionUtil.connectToDB()){
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean withdrawMoney(int amount) {
        try (Connection conn = ConnectionUtil.connectToDB()){
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

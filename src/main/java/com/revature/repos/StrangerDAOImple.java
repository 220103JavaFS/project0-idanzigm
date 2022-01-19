package com.revature.repos;

import com.revature.models.Customer;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StrangerDAOImple implements StrangerDAO{

    @Override
    public Boolean signUp(Customer customer) {
        try (Connection conn = ConnectionUtil.connectToDB()){

            String sql = "INSERT INTO  customer_table (first_name, last_name, address, city) VALUES (?,?,?,?);";

            PreparedStatement statement = conn.prepareStatement(sql);

            int count = 0;
            statement.setString(++count, customer.getFirstName());
            statement.setString(++count, customer.getLastName());
            statement.setString(++count, customer.getAddress());
            statement.setString(++count, customer.getCity());

            statement.execute();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

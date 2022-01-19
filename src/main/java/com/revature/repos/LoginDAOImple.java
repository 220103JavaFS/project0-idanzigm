package com.revature.repos;

import com.revature.models.Employee;
import com.revature.models.UserDTO;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAOImple implements LoginDAO {
    @Override
    public UserDTO findLogin(String username) {
        try (Connection conn = ConnectionUtil.connectToDB()){

            String sql = "SELECT * FROM login_table WHERE username = "+username+";";

            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            UserDTO storedLogin = new UserDTO();

            while(result.next()){
                storedLogin.setUsername(result.getString("username"));
                storedLogin.setPassword(result.getString("password"));
            }
            return storedLogin;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object displayInfo(String username) {
        try (Connection conn = ConnectionUtil.connectToDB()) {

            String sql = "SELECT * FROM login_table WHERE username = " + username + ";";

            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            if((result.getInt("employee_ID")) != 0){
                AdminDAO singleUse = new AdminDAOImple();
                int employeeID = result.getInt("employee_ID");

                return singleUse.findEmployeeByID(employeeID);

//                instanceUser.setEmployeeID(result.getEmployeeID("employee_ID"));
//                instanceUserID = getEmplyeeID.intanceUser();
//
//                String sql2 = "SELECT * FROM employee_table WHERE employeeID = " +instanceUserID+ ";";
//                Statement statement2 = conn.createStatement();
//                ResultSet result2 = statement.executeQuery(sql2);
//
//                while(result.next()){
//                    instanceUser.setAccessLevel(result2.getAccessLevel("access_level"));
//                }
//
//                return instanceUser;

            }else {
                ClerkDAO singleUse = new ClerkDAOImple();
                int customerID = result.getInt("customer_ID");

                return singleUse.findCustomerByID(customerID);

//                instanceUserID.setCustomerID(result.getInt("customer_ID"));
//                instanceUserID = getCustomerID.intanceUser();
//
//                String sql2 = "SELECT * FROM customer_table WHERE employeeID = " +instanceUserID+ ";";
//                Statement statement2 = conn.createStatement();
//                ResultSet result2 = statement.executeQuery(sql2);
//
//                while(result.next()){
//                    instanceUser.setFirstName(result2.getString("first_name"));
//                    instanceUser.setLastName(result2.getString("last_name"));
//                    instanceUser.setAddress(result2.getString("address"));
//                    instanceUser.setCity(result2.getString("city"));
                }
            } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }
}

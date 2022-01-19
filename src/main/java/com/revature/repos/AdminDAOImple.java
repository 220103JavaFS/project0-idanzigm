package com.revature.repos;

import com.revature.models.Employee;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAOImple implements AdminDAO{
    @Override
    public List<Employee> findAllEmployees() {
        try (Connection conn = ConnectionUtil.connectToDB()) {
            String sql = "SELECT * FROM employee_table;";

            Statement statement = conn.createStatement();
            ResultSet cell = statement.executeQuery(sql);

            List<Employee> result = new ArrayList<>();

            while(cell.next()) {
                Employee employee = new Employee();
                employee.setEmployeeID(cell.getInt("employee_ID"));
                employee.setAccessLevel(cell.getString("access_level"));
                result.add(employee);
            }

            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

        @Override
    public Employee findEmployeeByID(int employeeID) {
            try (Connection conn = ConnectionUtil.connectToDB()){

                String sql = "SELECT * FROM employee_table WHERE employee_id = "+employeeID+";";

                Statement statement = conn.createStatement();

                ResultSet result = statement.executeQuery(sql);

                Employee employee = new Employee();

                while(result.next()){
                    employee.setEmployeeID(result.getInt("employee_id"));
                    employee.setAccessLevel(result.getString("access_level"));
                }
                return employee;

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

    @Override
    public Boolean changeAccessLevel(Employee employee) {
            try (Connection conn = ConnectionUtil.connectToDB()){

                String sql = "UPDATE employee_table SET access_level = ? WHERE employee_ID = ?;";

                PreparedStatement statement = conn.prepareStatement(sql);

                int count = 0;
                statement.setInt(++count, employee.getEmployeeID());
                statement.setString(++count, employee.getAccessLevel());

                statement.execute();

                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return null;
    }

    @Override
    public Boolean hireClerk(Employee employee) {
        try (Connection conn = ConnectionUtil.connectToDB()){

            String sql = "INSERT INTO  employee_table (access_level) VALUES (?);";

            PreparedStatement statement = conn.prepareStatement(sql);

            int count = 0;
            statement.setString(++count, employee.getAccessLevel());

            statement.execute();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean fireClerk(int employeeID) {
        try (Connection conn = ConnectionUtil.connectToDB()){
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

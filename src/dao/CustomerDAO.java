package dao;

import db.DBConnection;
import model.Customer;
import java.sql.*;
import java.util.*;

public class CustomerDAO {
    public List<Customer> getAllCustomers() throws SQLException {
        Connection conn = DBConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM customers");

        List<Customer> list = new ArrayList<>();
        while (rs.next()) {
            Customer c = new Customer();
            c.setId(rs.getInt("id"));
            c.setName(rs.getString("name"));
            c.setEmail(rs.getString("email"));
            c.setAddress(rs.getString("address"));
            list.add(c);
        }

        stmt.close();
        conn.close();
        return list;
    }
}

package dao;

import db.DBConnection;
import model.Order;
import java.sql.*;
import java.util.*;

public class OrderDAO {
    public List<Order> getAllOrders() throws SQLException {
        Connection conn = DBConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM orders");

        List<Order> list = new ArrayList<>();
        while (rs.next()) {
            Order o = new Order();
            o.setId(rs.getInt("id"));
            o.setCustomerId(rs.getInt("customer_id"));
            o.setProductId(rs.getInt("product_id"));
            o.setQuantity(rs.getInt("quantity"));
            o.setStatus(rs.getString("status"));
            list.add(o);
        }

        stmt.close();
        conn.close();
        return list;
    }
}
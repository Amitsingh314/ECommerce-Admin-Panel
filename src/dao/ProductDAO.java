package dao;

import db.DBConnection;
import model.Product;
import java.sql.*;
import java.util.*;

public class ProductDAO {
    public void addProduct(Product product) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO products (name, description, price, stock) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, product.getName());
        stmt.setString(2, product.getDescription());
        stmt.setDouble(3, product.getPrice());
        stmt.setInt(4, product.getStock());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public List<Product> getAllProducts() throws SQLException {
        Connection conn = DBConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM products");

        List<Product> list = new ArrayList<>();
        while (rs.next()) {
            Product p = new Product();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setDescription(rs.getString("description"));
            p.setPrice(rs.getDouble("price"));
            p.setStock(rs.getInt("stock"));
            list.add(p);
        }

        stmt.close();
        conn.close();
        return list;
    }
}
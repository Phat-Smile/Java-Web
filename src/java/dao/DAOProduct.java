/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Category;
import model.Product;

/**
 *
 * @author ACER
 */
public class DAOProduct implements Accessible<Product> {

    @Override
    public int insert(Product obj) {
        int res = 0;
        try {
            Connection con = ConnectDB.getConnection();
            String sql = "INSERT INTO [dbo].[products] "
                    + "([productId], "
                    + "[productName], "
                    + "[productImage], "
                    + "[brief], "
                    + "[postedDate], "
                    + "[typeId], "
                    + "[account], "
                    + "[unit], "
                    + "[price], "
                    + "[discount]) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, obj.getProductId());
            st.setString(2, obj.getProductName());
            st.setString(3, obj.getProductImage());
            st.setString(4, obj.getBrief());
            st.setDate(5, obj.getPostedDate());
            st.setInt(6, obj.getTypeId().getTypeId());
            st.setString(7, obj.getAccount().getAccount());
            st.setString(8, obj.getUnit());
            st.setInt(9, obj.getPrice());
            st.setInt(10, obj.getDiscount());
            res = st.executeUpdate();
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public List<Product> listAll() {
        List<Product> listPro = new ArrayList<>();
        try {
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT [productId], [productName], [productImage], [brief], [postedDate], [typeId], [account], [unit], [price], [discount] "
                    + "FROM [dbo].[products]";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category category = new DAOCategory().searchById(rs.getString("typeId"));
                Account account = new DAOAccount().searchById(rs.getString("account"));
                Product pro = new Product(rs.getString("productId"),
                        rs.getString("productName"),
                        rs.getString("productImage"),
                        rs.getString("brief"),
                        rs.getDate("postedDate"),
                        category,
                        account,
                        rs.getString("unit"),
                        rs.getInt("price"),
                        rs.getInt("discount"));
                listPro.add(pro);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listPro;
    }

    @Override
    public int update(Product obj) {
        int res = 0;
        try {
            Connection con = ConnectDB.getConnection();
            String sql = "UPDATE [dbo].[products] "
                    + "SET [productName] = ?, "
                    + "[productImage] = ?, "
                    + "[brief] = ?, "
                    + "[postedDate] = ?, "
                    + "[typeId] = ?, "
                    + "[account] = ?, "
                    + "[unit] = ?, "
                    + "[price] = ?, "
                    + "[discount] = ? "
                    + "WHERE productId = ?";
            PreparedStatement st = con.prepareStatement(sql);
            
            st.setString(1, obj.getProductName());
            st.setString(2, obj.getProductImage());
            st.setString(3, obj.getBrief());
            st.setDate(4, obj.getPostedDate());
            st.setInt(5, obj.getTypeId().getTypeId());
            st.setString(6, obj.getAccount().getAccount());
            st.setString(7, obj.getUnit());
            st.setInt(8, obj.getPrice());
            st.setInt(9, obj.getDiscount());
            st.setString(10, obj.getProductId());
            res = st.executeUpdate();
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public int delete(Product obj) {
        int res = 0;
        try {
            Connection con = ConnectDB.getConnection();
            String sql = "DELETE FROM [dbo].[products] "
                    + " WHERE productId = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, obj.getProductId());
            res = st.executeUpdate();
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public Product searchById(String id) {
        Product pro = null;
        try {
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT [productId], [productName], [productImage], [brief], [postedDate], [typeId], [account], [unit], [price], [discount] "
                    + "FROM [dbo].[products] where productId = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Category category = new DAOCategory().searchById(rs.getString("typeId"));
                Account account = new DAOAccount().searchById(rs.getString("account"));
                pro = new Product(rs.getString("productId"),
                        rs.getString("productName"),
                        rs.getString("productImage"),
                        rs.getString("brief"),
                        rs.getDate("postedDate"),
                        category,
                        account,
                        rs.getString("unit"),
                        rs.getInt("price"),
                        rs.getInt("discount"));
            }
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pro;
    }

}

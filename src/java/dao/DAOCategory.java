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
import model.Category;

/**
 *
 * @author ACER
 */
public class DAOCategory implements Accessible<Category> {

    @Override
    public int insert(Category obj) {
        int res = 0;
        try {
            Connection con = ConnectDB.getConnection();
            String sql = "INSERT INTO [dbo].[categories]([categoryName],[memo]) "
                    + "VALUES(?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, obj.getCategoryName());
            st.setString(2, obj.getMemo());
            res = st.executeUpdate();
            con.close();
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public List<Category> listAll() {
        List<Category> listCate = new ArrayList<>();
        Category category = null;
        try {
            Connection con = ConnectDB.getConnection();
            String sql = "select typeId,categoryName,memo from categories";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                category = new Category(rs.getInt("typeId"),
                        rs.getString("categoryName"),
                        rs.getString("memo"));
                listCate.add(category);
            }
            con.close();
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCate;
    }

    @Override
    public int update(Category obj) {
        int res = 0;
        try {
            Connection con = ConnectDB.getConnection();
            String sql = "UPDATE [dbo].[categories] "
                    + " SET [categoryName] = ? "
                    + ",[memo] =? "
                    + " WHERE typeId = ? ";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, obj.getCategoryName());
            st.setString(2, obj.getMemo());
            st.setInt(3, obj.getTypeId());
            res = st.executeUpdate();
            con.close();
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public int delete(Category obj) {
        int res = 0;
        try {
            Connection con = ConnectDB.getConnection();
            String sql = "delete from categories where typeId =?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, obj.getTypeId());
            res = st.executeUpdate();
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public Category searchById(String id) {
        Category category = null;
        try {
            Connection con = ConnectDB.getConnection();
            String sql = "select typeId,categoryName,memo from categories where typeId = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, Integer.parseInt(id));
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                category = new Category(rs.getInt("typeId"),
                        rs.getString("categoryName"),
                        rs.getString("memo"));
            }
            con.close();
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return category;
    }

}

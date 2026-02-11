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

/**
 *
 * @author ACER
 */
public class DAOAccount implements Accessible<Account> {

    @Override
    public int insert(Account obj) {
        int res = 0;
        try {
            Connection con = ConnectDB.getConnection();
            String sql = "insert into [dbo].[accounts] ([account],[pass],[lastName],[firstName],[birthday],[gender],[phone],[isUse],[roleInSystem]) "
                    + " values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, obj.getAccount());
            st.setString(2, obj.getPass());
            st.setString(3, obj.getLastName());
            st.setString(4, obj.getFirstName());
            st.setDate(5, obj.getBirthday());
            st.setBoolean(6, obj.isGender());
            st.setString(7, obj.getPhone());
            st.setBoolean(8, obj.isUse());
            st.setInt(9, obj.getRoleInSystem());
            res = st.executeUpdate();
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public List<Account> listAll() {
        List<Account> listAcc = new ArrayList<>();
        try {
            Connection con = ConnectDB.getConnection();
            String sql = "select [account],[pass],[lastName],[firstName],[birthday],[gender],[phone],[isUse],[roleInSystem] "
                    + "from accounts ";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Account account = new Account(rs.getString("account"),
                        rs.getString("pass"),
                        rs.getString("lastName"),
                        rs.getString("firstName"),
                        rs.getDate("birthday"),
                        rs.getBoolean("gender"),
                        rs.getString("phone"),
                        rs.getBoolean("isUse"),
                        rs.getInt("roleInSystem"));
                listAcc.add(account);
            }
            con.close();
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listAcc;
    }

    @Override
    public int update(Account obj) {
        int res = 0;
        try {
            Connection con = ConnectDB.getConnection();
            String sql = "UPDATE [dbo].[accounts] "
                    + "   SET [pass] = ? "
                    + "      ,[lastName] = ? "
                    + "      ,[firstName] = ? "
                    + "      ,[birthday] = ? "
                    + "      ,[gender] = ? "
                    + "      ,[phone] = ? "
                    + "      ,[isUse] = ? "
                    + "      ,[roleInSystem] = ? "
                    + " WHERE account = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(9, obj.getAccount());
            st.setString(1, obj.getPass());
            st.setString(2, obj.getLastName());
            st.setString(3, obj.getFirstName());
            st.setDate(4, obj.getBirthday());
            st.setBoolean(5, obj.isGender());
            st.setString(6, obj.getPhone());
            st.setBoolean(7, obj.isUse());
            st.setInt(8, obj.getRoleInSystem());
            res = st.executeUpdate();
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public int delete(Account obj) {
        int res = 0;
        try {
            Connection con = ConnectDB.getConnection();
            String sql = "DELETE FROM [dbo].[accounts] "
                    + "  WHERE account = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, obj.getAccount());
            res = st.executeUpdate();
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public Account searchById(String id) {
        Account account = null;
        try {
            Connection con = ConnectDB.getConnection();
            String sql = "select [account],[pass],[lastName],[firstName],[birthday],[gender],[phone],[isUse],[roleInSystem] "
                    + "from accounts where account = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                account = new Account(rs.getString("account"),
                        rs.getString("pass"),
                        rs.getString("lastName"),
                        rs.getString("firstName"),
                        rs.getDate("birthday"),
                        rs.getBoolean("gender"),
                        rs.getString("phone"),
                        rs.getBoolean("isUse"),
                        rs.getInt("roleInSystem"));
            }
            con.close();
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return account;
    }

    public Account getLogin(String account, String pass) {
        Account acc = null;
        try {
            Connection con = ConnectDB.getConnection();
            String sql = "select [account],[pass],[lastName],[firstName],[birthday],[gender],[phone],[isUse],[roleInSystem] "
                    + "from accounts where account = ? and pass = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, account);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                acc = new Account(rs.getString("account"),
                        rs.getString("pass"),
                        rs.getString("lastName"),
                        rs.getString("firstName"),
                        rs.getDate("birthday"),
                        rs.getBoolean("gender"),
                        rs.getString("phone"),
                        rs.getBoolean("isUse"),
                        rs.getInt("roleInSystem"));
            }
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return acc;
    }

}

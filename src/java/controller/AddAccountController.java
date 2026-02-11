/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DAOAccount;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import utils.Validation;

/**
 *
 * @author ACER
 */
public class AddAccountController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        RequestDispatcher rd = request.getRequestDispatcher("/view/add-account.jsp");
        rd.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String user = request.getParameter("user");
        DAOAccount dAOAccount = new DAOAccount();
        Account check = dAOAccount.searchById(user);
        if (check == null) {
            String pass = request.getParameter("pass");
            String firstName = request.getParameter("firstName");
            System.out.println("FIRSTNAME = " + firstName);
            String lastName = request.getParameter("lastName");
            String phone = request.getParameter("phone");
            if (!Validation.isValid(phone, Validation.PHONE)) {
                request.setAttribute("error",
                        "Phone must start with 03, 05, 07, 08 or 09 and contain 10 digits.");
                RequestDispatcher rd = request.getRequestDispatcher("/view/add-account.jsp");
                rd.forward(request, response);
                return;
            }
            String dob = request.getParameter("dob");
            java.sql.Date birthday = java.sql.Date.valueOf(dob);
            boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
            int roleInSystem = Integer.parseInt(request.getParameter("role"));
            boolean isUse = request.getParameter("isUse") != null;
            int res = dAOAccount.insert(new Account(user, pass, lastName, firstName, birthday, gender, phone, isUse, roleInSystem));
            response.sendRedirect(request.getContextPath() + "/account");
        } else {
            request.setAttribute("error", "User is exits!");
            RequestDispatcher rd = request.getRequestDispatcher("/view/add-account.jsp");
            rd.forward(request, response);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

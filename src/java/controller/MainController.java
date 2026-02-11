/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author ACER
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        String url = "/view/login.jsp";
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("account");
        if (action == null) {
            request.getRequestDispatcher(url).forward(request, response);
            return;
        }

        if (acc != null && acc.getRoleInSystem() == 1) {
            if (!"product-list".equals(action)) {
                response.sendRedirect("MainController?action=product-list");
                return;
            }
        }

        switch (action.toLowerCase()) {
            //Index
            case "index":
                url = "index.jsp";
                break;
            //Account
            case "account-add":
                if (acc != null) {
                    url = "add_account";
                }
                break;
            case "account-upd":
                if (acc != null) {
                    url = "update_account";
                }
                break;
            case "account-del":
                if (acc != null) {
                    url = "delete_account";
                }
                break;
            case "account-list":
                if (acc != null) {
                    url = "account";
                }
                break;
            //Login
            case "login":
                url = "login";
                break;
            //Category
            case "category-add":
                if (acc != null) {
                    url = "add_category";
                }
                break;
            case "category-list":
                if (acc != null) {
                    url = "category";
                }
                break;
            case "category-upd":
                if (acc != null) {
                    url = "update_category";
                }
                break;
            case "category-del":
                if (acc != null) {
                    url = "delete_category";
                }
                break;

            //Product
            case "product-add":
                if (acc != null) {
                    url = "add_product";
                }
                break;
            case "product-upd":
                if (acc != null) {
                    url = "update_product";
                }
                break;
            case "product-del":
                if (acc != null) {
                    url = "delete_product";
                }
                break;
            case "product-list":
                url = "product";
                break;
            default:
                throw new AssertionError();
        }
        request.getRequestDispatcher(url).forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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

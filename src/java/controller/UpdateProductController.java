/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DAOCategory;
import dao.DAOProduct;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Category;
import model.Product;

/**
 *
 * @author ACER
 */
public class UpdateProductController extends HttpServlet {

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
        String productId = request.getParameter("productId");
        DAOProduct dAOProduct = new DAOProduct();
        Product pro = dAOProduct.searchById(productId);
        List<Category> listCate = new DAOCategory().listAll();
        if (pro != null) {
            request.setAttribute("p", pro);
            request.setAttribute("listCate", listCate);
            request.getRequestDispatcher("/view/update-product.jsp").forward(request, response);
        }
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
        request.setCharacterEncoding("UTF-8");
        String productId = request.getParameter("productId");
        DAOProduct dAOProduct = new DAOProduct();
        if (dAOProduct.searchById(productId) != null) {
            String productName = request.getParameter("productName");
            String brief = request.getParameter("brief");
            String productImage = request.getParameter("productImage");
            java.sql.Date postedDate = java.sql.Date.valueOf(request.getParameter("postedDate"));
            Category category = new Category();
            category.setTypeId(Integer.parseInt(request.getParameter("typeId")));
            request.setAttribute("c", category);
            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("account");
            if (acc == null) {
                response.sendRedirect("login");
            }
            String unit = request.getParameter("unit");
            int price = Integer.parseInt(request.getParameter("price"));
            int discount = Integer.parseInt(request.getParameter("discount"));
            Product product = new Product(productId, productName, productImage, brief, postedDate, category, acc, unit, price, discount);
            dAOProduct.update(product);
            response.sendRedirect("product");
        } else {
            request.setAttribute("error", "Invalid ProductID");
            request.getRequestDispatcher("/view/update-product.jsp").forward(request, response);
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

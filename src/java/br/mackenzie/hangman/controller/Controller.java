/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.hangman.controller;

import br.mackenzie.hangman.DAO.PlayerDAO;
import br.mackenzie.hangman.exception.PersistenceException;
import br.mackenzie.hangman.model.Player;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 31281354
 */
@WebServlet(name = "controller", urlPatterns = {"/controller"})
public class Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlller</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("Test0");
            out.println("<h1>Servlet Controlller at " + request.getContextPath() + " " + request.getParameter("nickname") + "</h1>");
            if (request.getParameter("opcao") != null && "player.auth".equalsIgnoreCase(request.getParameter("opcao"))) {
                out.println("Test1");
                if("true".equalsIgnoreCase(request.getParameter("signup"))) {
                    try {
                        out.println("Test2");
                        PlayerDAO playerDAO = new PlayerDAO();
                        out.println(playerDAO.buscarPorNome("Test"+request.getParameter("nickname")).getNickname());
                        //if((request.getParameter("nickname") != null) && 
                          //      (playerDAO.buscarPorNome(request.getParameter("nickname")).getNickname()).equalsIgnoreCase(request.getParameter("nickname"))) {
                            out.println("Test3");
                            playerDAO.inserir(new Player(request.getParameter("nickname"), request.getParameter("passowrd")));
                            RequestDispatcher requestDispatcher = request.getRequestDispatcher("./welcome");
                            requestDispatcher.forward(request, response);
                        //}
                        
                    } catch (PersistenceException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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

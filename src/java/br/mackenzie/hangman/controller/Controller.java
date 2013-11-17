/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.hangman.controller;

import br.mackenzie.hangman.DAO.PlayerDAO;
import br.mackenzie.hangman.DAO.WordDAO;
import br.mackenzie.hangman.exception.PersistenceException;
import br.mackenzie.hangman.model.Player;
import br.mackenzie.hangman.model.Session;
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
import javax.servlet.http.HttpSession;

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
        HttpSession session = null; 
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlller</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlller at " + request.getContextPath() + " " + request.getParameter("nickname") + " In:" + request.getParameter("signin")+ " Up:" + request.getParameter("signup") + "</h1>");
            
            if (request.getParameter("opcao") != null && "count".equalsIgnoreCase(request.getParameter("opcao"))) {
                //new WordDAO().buscarPorNome(request.getParameter("word"));
                out.println(request.getParameter("player"));
                out.println(request.getParameter("gameover"));
            }
            
            if (request.getParameter("opcao") != null && "player.auth".equalsIgnoreCase(request.getParameter("opcao"))) {
                if("true".equalsIgnoreCase(request.getParameter("signin"))) {
                    try {
                        PlayerDAO playerDAO = new PlayerDAO();
                        Player busca = playerDAO.buscarPorNome(request.getParameter("nickname"));
                            if(busca != null) {
                                //Session session;
                                session.setAttribute("username", request.getParameter("nickname"));
                                response.sendRedirect("./mainMenu.jsp");
                            } 
                                //response.sendRedirect("./mainMenu.jsp");
                            //}
                    } catch (PersistenceException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                if("true".equalsIgnoreCase(request.getParameter("signup"))) {
                    try {
                        PlayerDAO playerDAO = new PlayerDAO();
                            if(playerDAO.buscarPorNome(request.getParameter("nickname")) == null) {
                                playerDAO.inserir(new Player(request.getParameter("nickname"), request.getParameter("password")));
                            }
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

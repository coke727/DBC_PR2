/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controlador.controladorAbonadoRemote;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author coke
 */
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    @EJB
    private controladorAbonadoRemote controladorAbonado;
    
    private boolean errorLogin = false;

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if(!errorLogin) {
                out.println(getLogin());
            } else {
                out.println(getLoginError());
            }
        }
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
        doPost(request, response);
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
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String intentoLogin = request.getParameter("commit");
        
        if(intentoLogin != null) { //Si el acceso anterior ha sido un login
            boolean isEmpleado = (null != request.getParameter( "is_empleado" ));
            errorLogin = false;
            if(!controladorAbonado.isAbonado(login)) { //El usuario no existe
                errorLogin = true;
                processRequest(request, response);
            } else if (!controladorAbonado.isPasswdOK(login, password)){ //Password incorrecto
                errorLogin = true;
                processRequest(request, response);
            } else {
                if(isEmpleado) { //Si el usuario es un empleado
                    response.sendRedirect("consultarPedidos");
                } else { //usuario es un abonado
                    HttpSession session = request.getSession();
                    session.setAttribute("user",login);
                    RequestDispatcher rd = request.getRequestDispatcher("CrearPedido");
                    rd.forward(request,response);
                }
            }
        } else { //Acceso por url
            errorLogin = false;
        }
        
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
    
    /**
     * Devuelve la página de login en caso de haber un error de login.
     * @return login : String
     */
    private String getLoginError(){
        return "<!DOCTYPE html>"
                    +"<html>"
                    +"<head>"
                    +"<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>"
                    +"<title>Login</title>"
                    +"</head>"
                    +"<body>"
                    +"<h1>Login Vinoteca</h1>"
                    +"<form method='post' action='Login'>"
                    +"<p><input name='login' value='' placeholder='Username' type='text'></p>"
                    +"<p><input name='password' value='' placeholder='Password' type='password'></p>"
                    +"<p> Error en los datos introducidos </p>"
                    +"<p class='remember_me'>"
                      +"<label>"
                      +"  <input name='is_empleado' id='is_empleado' type='checkbox'>"
                      +"  Soy Empleado"
                      +"</label>"
                    +"</p>"
                    +"<p class='submit'><input name='commit' value='Login' type='submit'></p>"
                    +"</form>"
                    +"</body>"
                    +"</html>";
    }
    
    /**
     * Devuelve la página de login
     * @return login : string
     */
    private String getLogin(){
        return "<!DOCTYPE html>"
                    +"<html>"
                    +"<head>"
                    +"<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>"
                    +"<title>Login</title>"
                    +"</head>"
                    +"<body>"
                    +"<h1>Login Vinoteca</h1>"
                    +"<form method='post' action='Login'>"
                    +"<p><input name='login' value='' placeholder='Username' type='text'></p>"
                    +"<p><input name='password' value='' placeholder='Password' type='password'></p>"
                    +"<p class='remember_me'>"
                      +"<label>"
                      +"  <input name='is_empleado' id='is_empleado' type='checkbox'>"
                      +"  Soy Empleado"
                      +"</label>"
                    +"</p>"
                    +"<p class='submit'><input name='commit' value='Login' type='submit'></p>"
                    +"</form>"
                    +"</body>"
                    +"</html>";
    }

}

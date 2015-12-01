<%-- 
    Document   : vistaEmpleado
    Created on : 01-dic-2015, 1:43:22
    Author     : coke
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Administración de pedidos:</h1>
        <h3>Aquí puede cambiar el estado de los pedidos.</h3>
        <div>
          <ul>
              <li>
                  Pedido 1
                  <select name="OS">
                    <option value="1">Pendiente</option> 
                    <option value="2">Completado</option> 
                    <option value="3">Tramitado</option>
                    <option value="4">Facturado</option> 
                    <option value="5">Pagado</option>
                  </select>
              </li>
              <li>
                  Pedido 2
                  <select name="OS">
                    <option value="1">Pendiente</option> 
                    <option value="2">Completado</option> 
                    <option value="3">Tramitado</option>
                    <option value="4">Facturado</option> 
                    <option value="5">Pagado</option>
                  </select>
              </li>
              <li>
                  Pedido 3
                  <select name="OS">
                    <option value="1">Pendiente</option> 
                    <option value="2">Completado</option> 
                    <option value="3">Tramitado</option>
                    <option value="4">Facturado</option> 
                    <option value="5">Pagado</option>
                  </select>
              </li>
          </ul>
        </div>
    </body>
</html>

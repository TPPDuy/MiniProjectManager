/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam.qlphongban.bus;

import com.sam.qlphongban.dao.ProjectDAO;
import com.sam.qlphongban.dto.Project;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class CreateProjectServlet extends HttpServlet {

    private ProjectDAO objectDao = new ProjectDAO();

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try{
           RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/project/createproject.jsp");
           rd.forward(request, response);
       } catch(Exception ex)
       {
           //Logger.getLogger(CreateEmpServlet.class.getName().log(Level.SEVERE, null, ex));
       }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try{
           String name = request.getParameter("txtName");
           String location = request.getParameter("txtLocation");
           int numOfEmp = Integer.parseInt(request.getParameter("txtNoE"));
           double cost = Double.parseDouble(request.getParameter("txtCost"));
           String begin = request.getParameter("txtBegin");
           String end = request.getParameter("txtEnd");
           Project item = new Project(name, location, numOfEmp, cost, begin, end);
           objectDao.create(item);
           response.sendRedirect(request.getContextPath() + "/trangchuproject");
       } catch(Exception ex)
       {
           //Logger.getLogger(CreateEmpServlet.class.getName().log(Level.SEVERE, null, ex));
       }
    }
}

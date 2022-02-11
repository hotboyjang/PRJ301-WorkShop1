/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.fptuni.prj301.demo.servlet;

import com.fptuni.prj301.demo.utils.DBUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DUNGHUYNH
 */
public class PostServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int check = 0;
        int id = 0;
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String image_link = request.getParameter("image_link");
        String category = request.getParameter("category");
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        if (!image_link.isEmpty()) {
            try {
                //Set up the id
                String getID = "SELECT top 1 id FROM photo ORDER BY id DESC";
                Connection conn = DBUtils.getConnection();
                PreparedStatement ps;
                ps = conn.prepareStatement(getID);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    id = rs.getInt("id") + 1;
                }
                if (id == 0) {
                    id++;
                }

                String sql = "INSERT INTO photo VALUES(?,?,?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setString(3, description);
                ps.setString(4, image_link);
                ps.setString(5, category);
                ps.setDate(6, date);

                check = ps.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try (PrintWriter out = response.getWriter()) {
            String annouce = "<!DOCTYPE html>\n"
                    + "<html lang=\"en\">\n"
                    + "    <head>\n"
                    + "        <meta charset=\"UTF-8\">\n"
                    + "        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
                    + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                 //   + "        <meta http-equiv=\"refresh\" content=\"3;url=home\" />\n"
                    + "        <title>Document</title>\n"
                    + "        <link rel=\"stylesheet\" href=\"assets/css/app.css\">\n"
                    + "        <link rel=\"stylesheet\" href=\"assets/css/theme.css\">\n"
                    + "        <style>\n"
                    + "            input{\n"
                    + "                width: 200px; \n"
                    + "                height: 25px; \n"
                    + "                margin-bottom: 10px;\n"
                    + "            }\n"
                    + "            \n"
                    + "            .subBtn:hover{\n"
                    + "                background-color: green;\n"
                    + "            }\n"
                    + "\n"
                    + "        </style>\n"
                    + "    </head>\n"
                    + "    <body style=\"text-align: center;\">\n"
                    + "<nav class=\"navbar navbar-expand-lg navbar-light bg-white fixed-top\">\n"
                    + "            <a class=\"navbar-brand font-weight-bolder mr-3\" href=\"home\"><img src=\"assets/img/logo.png\"></a>\n"
                    + "            <button class=\"navbar-light navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarsDefault\" aria-controls=\"navbarsDefault\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n"
                    + "                <span class=\"navbar-toggler-icon\"></span>\n"
                    + "            </button>\n"
                    + "            <div class=\"collapse navbar-collapse\" id=\"navbarsDefault\">\n"
                    + "                \n"
                    + "                <ul class=\"navbar-nav ml-auto align-items-center\">\n"
                    + "                    <li class=\"nav-item\">   \n"
                    + "                        <a class=\"nav-link active\" href=\"home\">Home</a>\n"
                    + "                    </li>\n"
                    + "                    <li class=\"nav-item\">\n"
                    + "                        <a class=\"nav-link\" href=\"post.html\">Post</a>\n"
                    + "                    </li>\n"
                    + "\n"
                    + "                </ul>\n"
                    + "            </div>\n"
                    + "        </nav>\n";
            if (check > 0) {
                annouce += "<h1>Upload successfully</h1>\n";
            } else {
                annouce += "<h1>Upload fail</h1>\n";
            }
     //       annouce += "<h2>You will be sendirect to home page after 3s</h2>\n";
            annouce += "</body>\n"
                    + "</html>";
            out.println(annouce);

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

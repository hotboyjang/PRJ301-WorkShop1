/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.prj301.demo.servlet;

import com.fptuni.prj301.demo.utils.DBUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MyPC
 */
public class MoreServlet extends HttpServlet {

    String id = "";

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>\n"
                    + "    <meta charset=\"utf-8\">\n"
                    + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n"
                    + "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n"
                    + "    <title>More</title>\n"
                    + "    <script type=\"text/javascript\"> (function() { var css = document.createElement('link'); css.href = 'https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'; css.rel = 'stylesheet'; css.type = 'text/css'; document.getElementsByTagName('head')[0].appendChild(css); })(); </script>\n"
                    + "    <link rel=\"stylesheet\" href=\"assets/css/app.css\">\n"
                    + "    <link rel=\"stylesheet\" href=\"assets/css/theme.css\">\n"
                    + "\n"
                    + "</head>");
            out.println("<body>");
            id = request.getParameter("id");

            String sql = "select id, name , description, image_link, category, last_modified from photo";
            if (id != null && id != "") {
                sql += " Where id = " + id;
            }
            try {
                Connection conn = DBUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    out.println(" <nav class=\"navbar navbar-expand-lg navbar-light bg-white fixed-top\">\n"
                            + "    <a class=\"navbar-brand font-weight-bolder mr-3\" href=\"home\"><img src=\"assets/img/logo.png\"></a>\n"
                            + "    <button class=\"navbar-light navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarsDefault\" aria-controls=\"navbarsDefault\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n"
                            + "    <span class=\"navbar-toggler-icon\"></span>\n"
                            + "    </button>\n"
                            + "    <div class=\"collapse navbar-collapse\" id=\"navbarsDefault\">\n"
                            + "    	<ul class=\"navbar-nav ml-auto align-items-center\">\n"
                            + "    		<li class=\"nav-item\">\n"
                            + "    		<a class=\"nav-link active\" href=\"index.html\">Home</a>\n"
                            + "    		</li>\n"
                            + "    		<li class=\"nav-item\">\n"
                            + "    		<a class=\"nav-link\" href=\"post.html\">Post</a>\n"
                            + "    		</li>\n"
                            + "    		<li class=\"nav-item\">\n"
                            + "    		<a class=\"nav-link\" href=\"#\"><img class=\"rounded-circle mr-2\" src=\"assets/img/av.png\" width=\"30\"><span class=\"align-middle\">Author</span></a>\n"
                            + "    		</li>\n"
                            + "    		<li class=\"nav-item dropdown\">\n"
                            + "    		<a class=\"nav-link\" href=\"#\" id=\"dropdown02\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n"
                            + "    		<svg style=\"margin-top:10px;\" class=\"_3DJPT\" version=\"1.1\" viewbox=\"0 0 32 32\" width=\"21\" height=\"21\" aria-hidden=\"false\" data-reactid=\"71\"><path d=\"M7 15.5c0 1.9-1.6 3.5-3.5 3.5s-3.5-1.6-3.5-3.5 1.6-3.5 3.5-3.5 3.5 1.6 3.5 3.5zm21.5-3.5c-1.9 0-3.5 1.6-3.5 3.5s1.6 3.5 3.5 3.5 3.5-1.6 3.5-3.5-1.6-3.5-3.5-3.5zm-12.5 0c-1.9 0-3.5 1.6-3.5 3.5s1.6 3.5 3.5 3.5 3.5-1.6 3.5-3.5-1.6-3.5-3.5-3.5z\" data-reactid=\"22\"></path></svg>\n"
                            + "    		</a>\n"
                            + "    		<div class=\"dropdown-menu dropdown-menu-right shadow-lg\" aria-labelledby=\"dropdown02\">\n"
                            + "    			<h4 class=\"dropdown-header display-4\">Download Pintereso<br/> HTML Bootstrap Template</h4>\n"
                            + "    			<div class=\"dropdown-divider\">\n"
                            + "    			</div>\n"
                            + "    			<span class=\"dropdown-item\"><a href=\"https://github.com/wowthemesnet/template-pintereso-bootstrap-html/archive/master.zip\" class=\"btn btn-primary d-block\"><i class=\"fa fa-download\"></i> Download</a></span>\n"
                            + "    		</div>\n"
                            + "    		</li>\n"
                            + "    	</ul>\n"
                            + "    </div>\n"
                            + "    </nav>    \n"
                            + "    <main role=\"main\">\n"
                            + "        \n"
                            + "    \n"
                            + "    <section class=\"bg-gray200 pt-5 pb-5\">\n"
                            + "    <div class=\"container\">\n"
                            + "    	<div class=\"row justify-content-center\">\n"
                            + "    		<div class=\"col-md-7\">\n"
                            + "    			<article class=\"card\">\n"
                            + "    			<img class=\"card-img-top mb-2\" src=\"" + rs.getString("image_link") + "\" alt=\"Card image\">\n"
                            + "    			<div class=\"card-body\">\n"
                            + "    				<h1 class=\"card-title display-4\">\n"
                            + "    				" + rs.getString("name") + " </h1>\n"
                            + "    				<h2>" + rs.getString("description") + "</h2>\n"
                            + "    				<small class=\"d-block\"><a class=\"btn btn-sm btn-gray200\" href=\"#\"><i class=\"fa fa-external-link\"></i> Visit Website</a></small>\n"
                            + "    				\n"
                            + "    			</div>\n"
                            + "                        \n"
                            + "                        <form class=\"bd-search hidden-sm-down\">\n"
                            + "    			<input type=\"text\" class=\"form-control bg-graylight border-0 font-weight-bold\" id=\"search-input\" placeholder=\"Search...\" autocomplete=\"off\">\n"
                            + "    			<div class=\"dropdown-menu bd-search-results\" id=\"search-results\">\n"
                            + "    			</div>\n"
                            + "    		</form>\n"
                            + "                        \n"
                            + "    			</article>\n"
                            + "    		</div>\n"
                            + "    	</div>\n"
                            + "    </div>\n"
                            + "   \n"
                            + "    </section>\n"
                            + "        \n"
                            + "    </main>\n"
                            + "\n"
                            + "    <script src=\"assets/js/app.js\"></script>\n"
                            + "    <script src=\"assets/js/theme.js\"></script>\n"
                            + "    \n"
                            + "    <footer class=\"footer pt-5 pb-5 text-center\">\n"
                            + "        \n"
                            + "    <div class=\"container\">\n"
                            + "        \n"
                            + "          <div class=\"socials-media\">\n"
                            + "    \n"
                            + "            <ul class=\"list-unstyled\">\n"
                            + "              <li class=\"d-inline-block ml-1 mr-1\"><a href=\"#\" class=\"text-dark\"><i class=\"fa fa-facebook\"></i></a></li>\n"
                            + "              <li class=\"d-inline-block ml-1 mr-1\"><a href=\"#\" class=\"text-dark\"><i class=\"fa fa-twitter\"></i></a></li>\n"
                            + "              <li class=\"d-inline-block ml-1 mr-1\"><a href=\"#\" class=\"text-dark\"><i class=\"fa fa-instagram\"></i></a></li>\n"
                            + "              <li class=\"d-inline-block ml-1 mr-1\"><a href=\"#\" class=\"text-dark\"><i class=\"fa fa-google-plus\"></i></a></li>\n"
                            + "              <li class=\"d-inline-block ml-1 mr-1\"><a href=\"#\" class=\"text-dark\"><i class=\"fa fa-behance\"></i></a></li>\n"
                            + "              <li class=\"d-inline-block ml-1 mr-1\"><a href=\"#\" class=\"text-dark\"><i class=\"fa fa-dribbble\"></i></a></li>\n"
                            + "            </ul>\n"
                            + "    \n"
                            + "          </div>\n"
                            + "        \n"
                            + "            <!--\n"
                            + "              All the links in the footer should remain intact.\n"
                            + "              You may remove the links only if you donate:\n"
                            + "              https://www.wowthemes.net/freebies-license/\n"
                            + "            -->\n"
                            + "          <p>©  <span class=\"credits font-weight-bold\">        \n"
                            + "            <a target=\"_blank\" class=\"text-dark\" href=\"https://www.wowthemes.net/pintereso-free-html-bootstrap-template/\"><u>Pintereso Bootstrap HTML Template</u> by WowThemes.net.</a>\n"
                            + "          </span>\n"
                            + "          </p>\n"
                            + "    \n"
                            + "    \n"
                            + "        </div>\n"
                            + "        \n"
                            + "    </footer>");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            out.println("</body>");
            out.println("</html>");
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

package com.wildcodeschool.jdbcmysql;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;



@WebServlet("/")
public class Servlet2 extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public Servlet2() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Sql result = new Sql();



        List<Jedi> jediList = result.getJediMaster();
        int nbJedi = jediList.size();
        String[] jediName = new String[nbJedi];
        String[] jediSurname = new String[nbJedi];

       for (int i = 0; i < jediList.size(); i++ ) {
            jediName[i] = jediList.get(i).getName();
            jediSurname[i] = jediList.get(i).getSurname();

        }

        request.setAttribute("names", jediName);
        request.setAttribute("surnames", jediSurname);

        this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

    }
}

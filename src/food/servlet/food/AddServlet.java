package food.servlet.food;


import com.google.gson.Gson;
import food.dao.FoodDao;
import food.dao.impl.FoodDaoImpl;
import food.entity.Food;
import food.service.FoodService;
import food.service.impl.FoodServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet({"/AddServlet"})
@MultipartConfig
public class AddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("1");
        request.setCharacterEncoding("UTF-8");
        int tid = Integer.parseInt(request.getParameter("tid"));
        String fname = request.getParameter("fname");
        Double fprice = Double.parseDouble(request.getParameter("fprice"));
        String fdesc = request.getParameter("fdesc");
        Part part = request.getPart("file");
        System.out.println(fprice);
        String path = request.getSession().getServletContext().getRealPath("/foods");
        System.out.println(path);
        part.write(path + "\\" + part.getSubmittedFileName());
        Food info = new Food(-1, tid, fname, part.getSubmittedFileName(),fprice, 0, fdesc,"");
        FoodDaoImpl dao = new FoodDaoImpl();
        if (dao.insert(info) > 0) {
            response.getWriter().append("OK");
        } else {
            response.getWriter().append("NG");
        }


        }

    }


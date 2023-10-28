package food.servlet.food;


import com.google.gson.Gson;
import food.dao.impl.FoodDaoImpl;
import food.entity.Food;
import food.service.FoodService;
import food.service.impl.FoodServiceImpl;

import java.io.File;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.UUID;
@WebServlet({"/ChangeServlet"})
@MultipartConfig
public class ChangeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private FoodService foodService = new FoodServiceImpl();
    public ChangeServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("222");
        request.setCharacterEncoding("UTF-8");
        int fid = Integer.parseInt(request.getParameter("fid"));
        int tid = Integer.parseInt(request.getParameter("tid"));
        String fname = request.getParameter("fname");
        Double fprice = Double.parseDouble(request.getParameter("fprice"));
        String fdesc = request.getParameter("fdesc");
        Part part = request.getPart("file");
        System.out.println(fprice);
        String path = request.getSession().getServletContext().getRealPath("/foods");
        System.out.println(path);
        part.write(path + "\\" + part.getSubmittedFileName());
        Food info = new Food(fid, tid, fname, part.getSubmittedFileName(),fprice, 0, fdesc,"");
        FoodDaoImpl dao = new FoodDaoImpl();
        if (this.foodService.change(info) !=false) {
            response.getWriter().append("OK");
        } else {
            response.getWriter().append("NG");
        }


    }
}

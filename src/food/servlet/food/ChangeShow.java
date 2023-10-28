package food.servlet.food;


import food.entity.Food;
import food.service.FoodService;
import food.service.FtypeService;
import food.service.impl.FoodServiceImpl;
import food.service.impl.FtypeServiceImpl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ChangeShow extends HttpServlet {
    private FoodService foodService = new FoodServiceImpl();
    private FtypeService ftypeService = new FtypeServiceImpl();

    public ChangeShow() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int fid = Integer.parseInt(request.getParameter("fid"));
        Food food = this.foodService.getByFid(fid);
        request.setAttribute("food", food);
        request.setAttribute("typeList", this.ftypeService.getAll());
        request.getRequestDispatcher("/ShowChange.jsp").forward(request, response);
    }
}

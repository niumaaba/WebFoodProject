package food.servlet.food;

import com.google.gson.Gson;
import food.entity.Food;
import food.service.FoodService;
import food.service.impl.FoodServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetAllServlet extends HttpServlet {
    private FoodService foodService = new FoodServiceImpl();

    public GetAllServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset= utf-8");
        List<Food> list = this.foodService.getAllWithFtype();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("list",list);
       // request.setAttribute("list", list);
        response.getWriter().write((new Gson()).toJson(map));
       // request.getRequestDispatcher("/Show.jsp").forward(request, response);
    }
}
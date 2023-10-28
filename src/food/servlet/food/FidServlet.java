package food.servlet.food;

import com.google.gson.Gson;
import food.dao.impl.FoodDaoImpl;
import food.entity.Food;
import food.service.FoodService;
import food.service.impl.FoodServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "FidServlet", value = "/FidServlet")
public class FidServlet extends HttpServlet {
    private FoodService foodService = new FoodServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset= utf-8");
        System.out.println("999");
        int fid = Integer.parseInt(request.getParameter("fid"));
        Food fidfood=new Food();
        FoodDaoImpl dao = new FoodDaoImpl();
        fidfood=this.foodService.getByFid(fid);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("list",fidfood);
        // request.setAttribute("list", list);
        response.getWriter().write((new Gson()).toJson(map));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

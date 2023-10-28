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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FoodlikeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private FoodService foodService = new FoodServiceImpl();
    public FoodlikeServlet() {
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset= utf-8");
        String fname = request.getParameter("fname");
        String fprice=request.getParameter("fprice");
        System.out.println(fname);
        FoodDaoImpl dao = new FoodDaoImpl();
        List<Food> infolist = new ArrayList();
        infolist= this.foodService.getlikesFood(fname,fprice);
        System.out.println(infolist.size());
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("list",infolist);
        // request.setAttribute("list", list);
        response.getWriter().write((new Gson()).toJson(map));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

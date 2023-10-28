package food.servlet.food;

import com.google.gson.Gson;
import food.service.FoodService;
import food.service.impl.FoodServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RemoveServlet extends HttpServlet {
    private FoodService foodService = new FoodServiceImpl();
    private Gson gson = new Gson();

    public RemoveServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset= utf-8");
        Map<String, Object> map = new HashMap();
        map.put("isOK", this.foodService.remove(Integer.parseInt(request.getParameter("tid"))));
        response.getWriter().write((new Gson()).toJson(map));
    }
}

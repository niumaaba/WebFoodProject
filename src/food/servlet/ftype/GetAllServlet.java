package food.servlet.ftype;

import com.google.gson.Gson;
import food.service.FtypeService;
import food.service.impl.FtypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GetAllServlet extends HttpServlet {
    private FtypeService ftypeService = new FtypeServiceImpl();

    public GetAllServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset= utf-8");
        Map<String, Object> map = new HashMap();
        map.put("list", this.ftypeService.getAll());
        response.getWriter().write((new Gson()).toJson(map));
    }
}

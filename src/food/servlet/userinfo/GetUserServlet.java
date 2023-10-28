package food.servlet.userinfo;

import com.google.gson.Gson;
import food.entity.Userinfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GetUserServlet extends HttpServlet {
    public GetUserServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset= utf-8");
        Map<String, Object> map = new HashMap();
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("loginUser");
        map.put("isOK", false);
        map.put("msg", "not login");
        if (obj != null) {
            map.put("isOK", true);
            map.put("msg", "already login");
            map.put("loginUser", (Userinfo)obj);
        }

        response.getWriter().write((new Gson()).toJson(map));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

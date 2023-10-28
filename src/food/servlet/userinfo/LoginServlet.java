package food.servlet.userinfo;

import com.google.gson.Gson;
import food.entity.Userinfo;
import food.service.UserinfoService;
import food.service.impl.UserinfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginServlet extends HttpServlet {
    private UserinfoService userinfoService = new UserinfoServiceImpl();

    public LoginServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset= utf-8");
        String usercode = request.getParameter("usercode");
        String userpwd = request.getParameter("userpwd");
        Userinfo user = this.userinfoService.login(new Userinfo((Integer)null, usercode, userpwd, (String)null));
        Map<String, Object> map = new HashMap();
        map.put("isOK", false);

        if (user != null) {
            map.put("isOK", true);
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", user);
        }

        response.getWriter().write((new Gson()).toJson(map));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

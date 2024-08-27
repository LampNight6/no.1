package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/courierconfirmOrder")
public class Ordermessage_courierServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String param = req.getParameter("param");
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("参数值: " + param);
        // 获取表单参数
        String orderid = req.getParameter("orderid");
        String username = req.getParameter("username");
        String address = req.getParameter("address");
        String goodsName = req.getParameter("goodsName");

        // 可以在这里添加更多的处理逻辑，比如保存订单状态等

        // 设置请求属性，传递给 JSP
        req.setAttribute("orderid", orderid);
        req.setAttribute("username", username);
        req.setAttribute("address", address);
        req.setAttribute("goodsName", goodsName);

        // 转发请求到 order_confirm.jsp
        req.getRequestDispatcher("courier_confirm.jsp").forward(req, resp);
    }
}

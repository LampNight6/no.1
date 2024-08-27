package servlet;

import mapper.OrderMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet("/ordermessage1") // 定义 Servlet 的 URL 路径
public class OrdermessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); // 设置请求字符编码
        String param = req.getParameter("param");
        resp.setContentType("text/html;charset=UTF-8"); // 设置响应内容类型和编码
        resp.getWriter().write("参数值: " + param); // 返回参数值

        // 加载 MyBatis 配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取 SqlSession 对象
        SqlSession session = sqlSessionFactory.openSession();

        OrderMapper orderMapper = session.getMapper(OrderMapper.class); // 获取 OrderMapper
        List<Order> orderlist = orderMapper.selectOrderList(); // 查询订单列表

        req.setAttribute("orderlist", orderlist); // 设置请求属性
        req.getRequestDispatcher("order_message_courier.jsp").forward(req, resp); // 转发到 JSP 页面
    }
}

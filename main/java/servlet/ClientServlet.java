package servlet;

import mapper.ClientMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet("/client") // 定义 Servlet 的 URL 路径
public class ClientServlet extends HttpServlet {
    private static final long serialVersionUID = 1L; // 序列化版本号

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); // 设置请求字符编码
        resp.setContentType("text/html;charset=UTF-8"); // 设置响应内容类型和编码

        String resource = "mybatis-config.xml"; // MyBatis 配置文件路径
        InputStream inputStream = Resources.getResourceAsStream(resource); // 读取配置文件
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); // 创建 SqlSessionFactory

        try (SqlSession session = sqlSessionFactory.openSession()) { // 获取 SqlSession
            ClientMapper clientMapper = session.getMapper(ClientMapper.class); // 获取 Mapper
            List<Client> clientList = clientMapper.selectAll(); // 查询所有客户端信息

            req.setAttribute("clientList", clientList); // 设置请求属性
            req.getRequestDispatcher("user_message.jsp").forward(req, resp); // 转发到 JSP 页面
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp); // 处理 GET 请求
    }
}

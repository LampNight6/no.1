package servlet;

import mapper.SendMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Send;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/send") // 定义 Servlet 的 URL 路径
public class SendServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(SendServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); // 设置请求字符编码
        resp.setContentType("text/html;charset=UTF-8"); // 设置响应内容类型和编码

        // 加载 MyBatis 配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        SqlSessionFactory sqlSessionFactory = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            logger.info("SqlSessionFactory created successfully");
        } catch (Exception e) {
            logger.severe("Error creating SqlSessionFactory: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        // 获取 SqlSession 对象
        try (SqlSession session = sqlSessionFactory.openSession()) {
            SendMapper sendMapper = session.getMapper(SendMapper.class); // 获取 SendMapper
            List<Send> sendList = sendMapper.selectAll(); // 查询所有配送员
            logger.info("Send list size: " + sendList.size());

            // 打印每个配送员信息
            for (Send send : sendList) {
                logger.info(send.toString());
            }

            req.setAttribute("sendList", sendList); // 设置请求属性
            req.getRequestDispatcher("deliver_message.jsp").forward(req, resp); // 转发到 JSP 页面
        } catch (Exception e) {
            logger.severe("Error fetching send data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp); // 处理 GET 请求
    }
}

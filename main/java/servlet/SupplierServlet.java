package servlet;

import mapper.SupplierMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Supplier;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/supplier") // 定义 Servlet 的 URL 路径
public class SupplierServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(SupplierServlet.class.getName());

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
            SupplierMapper supplierMapper = session.getMapper(SupplierMapper.class); // 获取 SupplierMapper
            List<Supplier> supplierList = supplierMapper.selectAll(); // 查询所有供应商
            logger.info("Supplier list size: " + supplierList.size());

            // 打印每个供应商信息
            for (Supplier supplier : supplierList) {
                logger.info(supplier.toString());
            }

            req.setAttribute("supplierList", supplierList); // 设置请求属性
            req.getRequestDispatcher("supplier_message.jsp").forward(req, resp); // 转发到 JSP 页面
        } catch (Exception e) {
            logger.severe("Error fetching supplier data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp); // 处理 GET 请求
    }
}

package servlet;

import mapper.GoodsMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet("/store") // 定义 Servlet 的 URL 路径
public class StoreServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); // 设置请求字符编码
        resp.setContentType("text/html;charset=UTF-8"); // 设置响应内容类型和编码

        String storeIdStr = req.getParameter("storeId");
        int storeId = Integer.parseInt(storeIdStr); // 获取供应商 ID

        // 加载 MyBatis 配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取 SqlSession 对象
        try (SqlSession session = sqlSessionFactory.openSession()) {
            GoodsMapper goodsMapper = session.getMapper(GoodsMapper.class); // 获取 GoodsMapper
            List<Goods> goodsList = goodsMapper.selectByStoreId(storeId); // 根据供应商 ID 查询商品列表
            req.setAttribute("goodsList", goodsList); // 设置请求属性
            req.setAttribute("storeId", storeId); // 设置供应商 ID
            req.getRequestDispatcher("store.jsp").forward(req, resp); // 转发到 JSP 页面
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp); // 处理 GET 请求
    }
}

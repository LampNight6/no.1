package servlet;

import mapper.ClientMapper;
import mapper.GoodsMapper;
import mapper.OrderMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Client;
import pojo.Goods;
import pojo.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet("/billSelect")
public class
billSelectServlet extends HttpServlet {


    @Override
    protected void doGet
            (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //防止中文乱码
        req.setCharacterEncoding("UTF-8");
        String param = req.getParameter("param");
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("参数值: " + param);


        //获取请求参数
        HttpSession session1=req.getSession();
        Client client = (Client) session1.getAttribute("client");
        String userId= client.getUserid();


        //1.加载mybatis的配置文件
        String resource = "mybatis-config.xml";
        //2.准备sqlSessionFactory
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.获取SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();

        OrderMapper orderMapper=session.getMapper(OrderMapper.class);

        List<Order> orderList = orderMapper.selectOrdersWithGoodsInfo(userId);
        for (Order order : orderList) {
            System.out.println(order.getGoodName() + "," + order.getBillStatus() + ", " + order.getDistributionStatus());
        }

        req.setAttribute("orderList", orderList);
        req.getRequestDispatcher("table-datatable.jsp").forward(req, resp);

    }
}



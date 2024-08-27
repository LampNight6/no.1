package servlet;

//import com.sun.deploy.panel.ITreeNode;
import mapper.ClientMapper;
import mapper.GoodsMapper;
import mapper.OrderMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Client;
import pojo.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/billInsert")
public class
billInsertServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //防止中文乱码
        req.setCharacterEncoding("UTF-8");
        String param = req.getParameter("param");
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("参数值: " + param);

        //1.加载mybatis的配置文件
        String resource = "mybatis-config.xml";
        //2.准备sqlSessionFactory
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.获取SqlSession对象z
        SqlSession session = sqlSessionFactory.openSession();

        String userid = req.getParameter("userid");
        String address = req.getParameter("address");
        String goodsid = req.getParameter("goodsid");
        String num1 = req.getParameter("num");
        Integer num = Integer.valueOf(num1);

        OrderMapper orderMapper=session.getMapper(OrderMapper.class);

        //订单表插入一个订单
        try {
            // 创建Order对象时，如果orderId是自增的，可以省略不填
            Order order = new Order(userid,address,goodsid);

            int insert = orderMapper.insert(order);
            if (insert > 0) {

                System.out.println("插入成功");
            } else {
                session.rollback();
                System.out.println("插入失败");
            }
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
            System.out.println("发生异常，事务已回滚");
        }

        //货物表减去购买的数量
        GoodsMapper goodsMapper =session.getMapper(GoodsMapper.class);
        Map<String, Object> params = new HashMap<>();
        params.put("goodsid", goodsid);
        params.put("num", num);
        int update = goodsMapper.update_good_been_sold(params);

        resp.sendRedirect("/goods");

//        req.getRequestDispatcher("/goods").forward(req, resp);
        session.commit();
        session.close();





        }


    }



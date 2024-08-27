package servlet;

//import com.sun.glass.ui.Size;
import mapper.ClientMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Client;
import pojo.Goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet("/billCreate")
public class
billCreateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //防止中文乱码
        req.setCharacterEncoding("UTF-8");
        String param = req.getParameter("param");
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("参数值: " + param);

        //获取信息
        String goodsId = req.getParameter("goodsId");
        String goodsName = req.getParameter("goodsName");
        String type = req.getParameter("type");
        String amount = req.getParameter("amount");
        String size =req.getParameter("size");


        //创建订单
        HttpSession session = req.getSession();
        session.setAttribute("goodsId", goodsId);
        session.setAttribute("goodsName", goodsName);
        session.setAttribute("type", type);
        session.setAttribute("amount", amount);
        session.setAttribute("size", size);

        // 转发到确认订单页面
        req.getRequestDispatcher("confirm_order.jsp").forward(req, resp);
        }



    }



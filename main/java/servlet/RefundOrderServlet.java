package servlet;

import mapper.DeliveryInformationMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/refundOrder")
public class
RefundOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//  点击退单后，remove页面里面的这一行
            int orderId = Integer.parseInt(request.getParameter("orderId"));
            // 这里可以调用你的业务逻辑，例如从数据库中删除或更新订单状态
            // 假设业务逻辑处理成功
            boolean success = true; // 这里应该替换为真实的业务逻辑处理结果
            // 设置响应头，告知客户端响应类型为JSON
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            // 根据处理结果生成JSON响应
            if (success) {
                out.print("{\"success\":true}");
            } else {
                out.print("{\"success\":false}");
            }
            // 关闭PrintWriter
            ((PrintWriter) out).close();

//  点击退单后，数据库里面订单状态改变

        //防止中文乱码
        request.setCharacterEncoding("UTF-8");
        String param = request.getParameter("param");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("参数值: " + param);

        //1.加载mybatis的配置文件
        String resource = "mybatis-config.xml";
        //2.准备sqlSessionFactory
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.获取SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();


        DeliveryInformationMapper deliveryInformationMapper=session.getMapper(DeliveryInformationMapper.class);
        int update=deliveryInformationMapper.updateByPrimaryKey(orderId);
        System.out.println(update);

        session.commit();
        session.close();







        }

    }




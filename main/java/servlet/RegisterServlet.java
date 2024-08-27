package servlet;

import mapper.ClientMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Client;
import utils.JdbcUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/register")
public class
RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //防止中文乱码
        req.setCharacterEncoding("UTF-8");
        String param = req.getParameter("param");
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("参数值: " + param);


        //获取请求参数
        String userId = req.getParameter("id");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String pwd = req.getParameter("password");
        String phone = req.getParameter("phone");
        int status = 0;

        //1.加载mybatis的配置文件
        String resource = "mybatis-config.xml";
        //2.准备sqlSessionFactory
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.获取SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();

        ClientMapper clientMapper = session.getMapper(ClientMapper.class);

        //插入用户信息
        int insert = clientMapper.insert(new Client(userId, name, pwd, phone, address, status));
        session.commit();
        resp.sendRedirect("index.html");
        session.close();

    }
}



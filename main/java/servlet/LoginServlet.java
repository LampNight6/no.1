package servlet;

//import javafx.scene.control.Alert;
import mapper.ClientMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Client;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Objects;

@WebServlet("/login")
public class LoginServlet extends HttpServlet  {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String userId = req.getParameter("userId"); //*******!!!!!!*********************

        String pwd = req.getParameter("password");

        //1.加载mybatis的配置文件
        String resource = "mybatis-config.xml";
        //2.准备sqlSessionFactory
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.获取SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();

//        User user = session.selectOne("getUserById", 1);
        ClientMapper clientMapper=session.getMapper(ClientMapper.class);
        Client client =clientMapper.selectByPrimaryKey(userId);
        if(client==null){
            //没找到账号,回到登录页面
            req.getRequestDispatcher("index.html").forward(req,resp);
        }
        else{
            //成功了
            if(Objects.equals(client.getPassword(), pwd)){
                //到用户界面
                if(client.getStatus()==0){
                    HttpSession session1 = req.getSession();
                    session1.setAttribute("client", client);
                    req.getRequestDispatcher("user_information.jsp").forward(req, resp);
                }
                //到管理员界面
                else {
                    HttpSession session1 = req.getSession();
                    session1.setAttribute("client", client);
                    req.getRequestDispatcher("/client").forward(req, resp);
                }


//                req.getRequestDispatcher("client.html").forward(req,resp);
            }
            else{
                //密码错误，返回登录页面
                resp.sendRedirect("index.html");
            }
        }
    }
}


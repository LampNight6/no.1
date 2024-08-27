package servlet;

import mapper.CommentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Comment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/editor") // 定义 Servlet 的 URL 路径
public class editorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); // 设置请求字符编码
        String param = req.getParameter("param");
        resp.setContentType("text/html;charset=UTF-8"); // 设置响应内容类型和编码
        resp.getWriter().write("参数值: " + param); // 返回参数值

        // 加载 MyBatis 配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取 SqlSession 对象
        SqlSession session = sqlSessionFactory.openSession();

        // 获取请求参数
        String userid = req.getParameter("userid");
        String sendsid = req.getParameter("dsid");
        String orderid = req.getParameter("orderid");
        String content = req.getParameter("content");
        String grand = req.getParameter("grand");

        System.out.println(userid);
        System.out.println(content);
        System.out.println(grand);

        CommentMapper commentMapper = session.getMapper(CommentMapper.class); // 获取 CommentMapper

        try {
            Comment comment = new Comment(orderid, sendsid, userid, content, grand); // 创建 Comment 对象
            int insert = commentMapper.insert(comment); // 插入评论
            if (insert > 0) {
                System.out.println("插入成功");
                req.getRequestDispatcher("user_information.jsp").forward(req, resp); // 插入成功，转发到 JSP 页面
            } else {
                session.rollback(); // 插入失败，回滚事务
                System.out.println("插入失败");
            }
        } catch (Exception e) {
            session.rollback(); // 异常，回滚事务
            e.printStackTrace();
            System.out.println("发生异常，事务已回滚");
        }

        session.commit(); // 提交事务
        session.close(); // 关闭 SqlSession
    }
}

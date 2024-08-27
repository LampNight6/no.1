package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {
    private static  SqlSessionFactory factory=null;
    static {

        //1.加载mybatis的配置文件
        String resource = "mybatis-config.xml";
        //2.准备sqlSessionFactory
        InputStream inputStream = null;               //连接多个库，连接product库
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        factory = new SqlSessionFactoryBuilder().build(inputStream);
    }

//    //3.获取SqlSession对象
    public static SqlSession getSqlSession(){
        SqlSession sqlSession =null;
        if (factory!=null){
            sqlSession=factory.openSession();
        }
        return sqlSession;
    }


}

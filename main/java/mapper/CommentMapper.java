package mapper;


import pojo.Comment;

import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(String orderid);

    int insert(Comment record);

    Comment selectByPrimaryKey(String orderid);

    List<Comment> selectAll();

    int updateByPrimaryKey(Comment record);
}
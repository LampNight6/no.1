package org.tg.book.dal.mapper.mbg;

import java.util.List;
import org.tg.book.dal.po.mbg.Comment;

public interface CommentMapper {
    int deleteByPrimaryKey(String orderid);

    int insert(Comment record);

    Comment selectByPrimaryKey(String orderid);

    List<Comment> selectAll();

    int updateByPrimaryKey(Comment record);
}
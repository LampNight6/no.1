package org.tg.book.dal.mapper.mbg;

import java.util.List;
import org.tg.book.dal.po.mbg.Send;

public interface SendMapper {
    int deleteByPrimaryKey(String sendid);

    int insert(Send record);

    Send selectByPrimaryKey(String sendid);

    List<Send> selectAll();

    int updateByPrimaryKey(Send record);
}
package org.tg.book.dal.mapper.mbg;

import java.util.List;
import org.tg.book.dal.po.mbg.Order;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer orderid);

    int insert(Order record);

    Order selectByPrimaryKey(Integer orderid);

    List<Order> selectAll();

    int updateByPrimaryKey(Order record);
}
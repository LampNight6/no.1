package mapper;


import pojo.Order;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(int orderid);

    int insert(Order record);

//    List<Order> selectByPrimaryKey(String userId);
    List<Order> selectOrdersWithGoodsInfo(String userid);

    List<Order> selectAll();


    int updateByPrimaryKey(Order record);

    List<Order> selectOrderList();


}
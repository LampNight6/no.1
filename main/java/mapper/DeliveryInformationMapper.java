package mapper;


import pojo.DeliveryInformation;

import java.util.List;

public interface DeliveryInformationMapper {
    int deleteByPrimaryKey(String orderid);

    int insert(DeliveryInformation record);

    DeliveryInformation selectByPrimaryKey(String orderid);

    List<DeliveryInformation> selectAll();
//   确认退单
    int updateByPrimaryKey(int orderid);
//   确认收货
    int updateByPrimaryKey2(int orderid);
}
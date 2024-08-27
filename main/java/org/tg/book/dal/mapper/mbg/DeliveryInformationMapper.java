package org.tg.book.dal.mapper.mbg;

import java.util.List;
import org.tg.book.dal.po.mbg.DeliveryInformation;

public interface DeliveryInformationMapper {
    int deleteByPrimaryKey(String orderid);

    int insert(DeliveryInformation record);

    DeliveryInformation selectByPrimaryKey(String orderid);

    List<DeliveryInformation> selectAll();

    int updateByPrimaryKey(DeliveryInformation record);
}
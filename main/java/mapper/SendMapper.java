package mapper;


import pojo.Send;

import java.util.List;

public interface SendMapper {
    int deleteByPrimaryKey(String sendid);

    int insert(Send record);

    Send selectByPrimaryKey(String sendid);

    List<Send> selectAll();

    int updateByPrimaryKey(Send record);
}
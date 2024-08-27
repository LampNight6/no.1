package mapper;


import pojo.Client;

import java.util.List;

public interface ClientMapper {
    int deleteByPrimaryKey(String userid);

    int insert(Client record);

    Client selectByPrimaryKey(String userid);

    List<Client> selectAll();

    int updateByPrimaryKey(Client record);
}
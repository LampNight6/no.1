package org.tg.book.dal.mapper.mbg;

import java.util.List;
import org.tg.book.dal.po.mbg.Client;

public interface ClientMapper {
    int deleteByPrimaryKey(String userid);

    int insert(Client record);

    Client selectByPrimaryKey(String userid);

    List<Client> selectAll();

    int updateByPrimaryKey(Client record);
}
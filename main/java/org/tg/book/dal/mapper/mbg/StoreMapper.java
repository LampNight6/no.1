package org.tg.book.dal.mapper.mbg;

import java.util.List;
import org.tg.book.dal.po.mbg.Store;

public interface StoreMapper {
    int deleteByPrimaryKey(Integer storeid);

    int insert(Store record);

    Store selectByPrimaryKey(Integer storeid);

    List<Store> selectAll();

    int updateByPrimaryKey(Store record);
}
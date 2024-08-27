package mapper;

import pojo.Store;

import java.util.List;

public interface StoreMapper {
    int deleteByPrimaryKey(Integer storeid);

    int insert(Store record);

    Store selectByPrimaryKey(Integer storeid);

    List<Store> selectAll();

    int updateByPrimaryKey(Store record);
}
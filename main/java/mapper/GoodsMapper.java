package mapper;


import pojo.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsMapper {
    int deleteByPrimaryKey(String goodsid);

    int insert(Goods record);

    Goods selectByPrimaryKey(String goodsid);

    List<Goods> selectAll();

    int update_good_been_sold(Map<String, Object> params);

    List<Goods> selectByStoreId(int storeId);
}
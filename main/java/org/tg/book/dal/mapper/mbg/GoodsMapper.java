package org.tg.book.dal.mapper.mbg;

import java.util.List;
import org.tg.book.dal.po.mbg.Goods;

public interface GoodsMapper {
    int deleteByPrimaryKey(String goodsid);

    int insert(Goods record);

    Goods selectByPrimaryKey(String goodsid);

    List<Goods> selectAll();

    int updateByPrimaryKey(Goods record);
}
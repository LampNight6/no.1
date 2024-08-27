package org.tg.book.dal.mapper.mbg;

import java.util.List;
import org.tg.book.dal.po.mbg.Supplier;

public interface SupplierMapper {
    int deleteByPrimaryKey(String id);

    int insert(Supplier record);

    Supplier selectByPrimaryKey(String id);

    List<Supplier> selectAll();

    int updateByPrimaryKey(Supplier record);
}
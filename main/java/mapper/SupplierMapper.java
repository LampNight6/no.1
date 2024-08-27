package mapper;

import pojo.Supplier;

import java.util.List;

public interface SupplierMapper {
    int deleteByPrimaryKey(String id);

    int insert(Supplier record);

    Supplier selectByPrimaryKey(String id);

    List<Supplier> selectAll();

    int updateByPrimaryKey(Supplier record);
}
package com.leyou.item.mapper;

import com.leyou.item.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BrandMapper extends Mapper<Brand> {
    @Insert("insert into tb_category_brand (category_id,brand_id) values(#{cid},#{brandId})")
    int insertBrandAndCategory(@Param("cid") Long cid, @Param("brandId") Long id);

    List<Brand> queryByKey(@Param("key") String key,@Param("sortBy") String sortBy,
                           @Param("descOrAsc") String descOrAsc);
}

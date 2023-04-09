package com.leyou.item.mapper;

import com.leyou.item.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BrandMapper extends Mapper<Brand> {
    /**
     * 新增品牌分类
     * @param cid
     * @param id
     * @return
     */
    @Insert("insert into tb_category_brand (category_id,brand_id) values(#{cid},#{brandId})")
    int insertBrandAndCategory(@Param("cid") Long cid, @Param("brandId") Long id);

    /**
     * 查询品牌
     * @param key
     * @param sortBy
     * @param descOrAsc
     * @return
     */
    List<Brand> queryByKey(@Param("key") String key,@Param("sortBy") String sortBy,
                           @Param("descOrAsc") String descOrAsc);

    /**
     * 修改品牌
     *
     * @param brand
     * @return
     */
    int updateBrand(Brand brand);

    /**
     * 删除关联关系
     *
     * @param brandId
     */
    void deleteBrandAndCategory(Long brandId);
}

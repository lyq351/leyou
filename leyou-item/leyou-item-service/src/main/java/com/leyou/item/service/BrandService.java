package com.leyou.item.service;

import com.leyou.item.pojo.Brand;
import com.leyou.pojo.PageResult;

import java.util.List;

public interface BrandService {
    /**
     * 分页查询
     *
     * @param key
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @return
     */
    PageResult queryByPage(String key, Integer page, Integer rows, String sortBy, Boolean desc);

    /**
     * 保存品牌
     *
     * @param brand
     * @param cids
     */
    void saveBrand(Brand brand, List<Long> cids);

    /**
     * 品牌删除
     * @param id
     */
    void deleteBrand(String id);

    /**
     * 修改品牌
     *
     * @param brand
     * @param cids
     */
    void updateBrand(Brand brand, List<Long> cids);
}

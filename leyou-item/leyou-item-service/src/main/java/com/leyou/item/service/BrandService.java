package com.leyou.item.service;

import com.leyou.item.pojo.Brand;
import com.leyou.pojo.PageResult;

import java.util.List;

public interface BrandService {

    PageResult queryByPage(String key, Integer page, Integer rows, String sortBy, Boolean desc);

    void saveBrand(Brand brand, List<Long> cids);

    /**
     * 品牌删除
     * @param id
     */
    void deleteBrand(String id);
}

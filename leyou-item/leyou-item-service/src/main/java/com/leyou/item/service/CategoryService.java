package com.leyou.item.service;

import com.leyou.item.pojo.Category;

import java.util.List;

public interface CategoryService {

    /**
     * 根据父节点查看子集
     * @param pid
     * @return
     */
    List<Category> queryCategoryByPid(Long pid);

    /**
     * 通过品牌id获取分类信息
     * @param id
     * @return
     */
    List<Category> queryCategoryByBrandId(int id);
}

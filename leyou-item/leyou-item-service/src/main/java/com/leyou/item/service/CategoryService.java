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
}

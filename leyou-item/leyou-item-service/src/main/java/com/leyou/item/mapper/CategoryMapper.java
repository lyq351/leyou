package com.leyou.item.mapper;

import com.leyou.item.pojo.Category;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CategoryMapper extends Mapper<Category> {
    /**
     * 通过品牌id获取分类信息
     * @param id
     * @return
     */
    List<Category> queryByBrandId(int id);
}

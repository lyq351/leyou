package com.leyou.item.service;

import com.leyou.item.pojo.SpecGroup;
import java.util.List;

public interface SpecificationService {

    /**
     * 根据分类id查询分组
     * @param cId
     * @return
     */
    List<SpecGroup> querySpecGroupByCid(Long cId);
}

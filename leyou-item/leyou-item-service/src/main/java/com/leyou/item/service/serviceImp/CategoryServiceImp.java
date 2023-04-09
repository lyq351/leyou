package com.leyou.item.service.serviceImp;

import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {
    Logger logger = LoggerFactory.getLogger(CategoryServiceImp.class);
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public List<Category> queryCategoryByPid(Long pid) {
        Category category = new Category();
        category.setParentId(pid);
        return categoryMapper.select(category);
    }

    @Override
    public List<Category> queryCategoryByBrandId(int id) {
        return categoryMapper.queryByBrandId(id);
    }
}

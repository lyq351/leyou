package com.leyou.item.controller;

import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 格局父节点查看子集
     * @param pid
     * @return
     */
    @GetMapping("list")
    public ResponseEntity<List<Category>> queryCategoriesByPid(Long pid){

        List<Category> result = categoryService.queryCategoryByPid(pid);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/bid/{id}")
    public ResponseEntity<List<Category>> queryByBrandId(@PathVariable int id){
        List<Category> category = categoryService.queryCategoryByBrandId(id);
        return ResponseEntity.ok(category);
    }
}

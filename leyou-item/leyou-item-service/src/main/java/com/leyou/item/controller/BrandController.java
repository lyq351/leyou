package com.leyou.item.controller;

import com.leyou.item.pojo.Brand;
import com.leyou.item.service.BrandService;
import com.leyou.pojo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@RequestMapping("/brand")
@Controller
public class BrandController {
    @Autowired
    private BrandService brandService;
    @GetMapping("/page")
    public ResponseEntity<PageResult> queryByPage(
            @RequestParam(value = "key", required = false)String key,
            @RequestParam(value = "page", defaultValue = "1")Integer page,
            @RequestParam(value = "rows", defaultValue = "5")Integer rows,
            @RequestParam(value = "sortBy", required = false)String sortBy,
            @RequestParam(value = "desc", required = false)Boolean desc
    ){
        PageResult pageResult = this.brandService.queryByPage(key, page, rows, sortBy, desc);
        //校验，若是结果为空，返回错误信息
        if(null == pageResult || CollectionUtils.isEmpty(pageResult.getItems())){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pageResult);
    }
    @PostMapping
    public ResponseEntity<PageResult> addBrand(Brand brand, @RequestParam("cids") List<Long> cids){

        this.brandService.saveBrand(brand,cids);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

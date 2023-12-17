package com.leyou.item.controller;

import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.service.SpecificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("spec")
public class SpecificationController {

    @Resource
    private SpecificationService specificationService;

    /**
     * 根据分类id查询分组
     * @param cId
     * @return
     */
    @GetMapping("groups/{cId}")
    public ResponseEntity querySpecGroupByCid(@PathVariable(("cId")) Long cId){
        List<SpecGroup> specGroupList = specificationService.querySpecGroupByCid(cId);
        return ResponseEntity.ok(specGroupList);
    }
}

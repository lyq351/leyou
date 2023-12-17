package com.leyou.item.service.serviceImp;

import com.leyou.item.mapper.SpecGroupMapper;
import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.service.SpecificationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SpecificationServiceImpl implements SpecificationService {

    @Resource
    private SpecGroupMapper specGroupMapper;


    @Override
    public List<SpecGroup> querySpecGroupByCid(Long cId) {
        SpecGroup specGroup = new SpecGroup();
        specGroup.setCid(cId);
        return specGroupMapper.select(specGroup);
    }
}

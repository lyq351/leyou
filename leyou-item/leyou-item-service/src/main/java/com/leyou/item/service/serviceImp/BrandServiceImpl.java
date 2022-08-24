package com.leyou.item.service.serviceImp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.pojo.Brand;
import com.leyou.item.service.BrandService;
import com.leyou.pojo.PageResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public PageResult queryByPage(String key, Integer page, Integer rows, String sortBy, Boolean desc) {
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        //添加分页条件
        Page page1 = PageHelper.startPage(page,rows);
        if(StringUtils.isNotEmpty(key)){
            criteria.andLike("name","%"+key+"%")
            .orEqualTo("letter",key);
        }
        if(StringUtils.isNotBlank(sortBy)){
            example.setOrderByClause(sortBy+" "+(desc?"desc":"asc"));
        }
        List<Brand> brands = this.brandMapper.selectByExample(example);
        // 包装成pageInfo
        PageInfo<Brand> pageInfo = new PageInfo<>(brands);

        //return  new PageResult(pageInfo.getTotal(),pageInfo.getPageSize(),brands);
        return  new PageResult(page1.getTotal(),page1.getPageSize(),brands);
    }

    @Override
    public void saveBrand(Brand brand,List<Long> cids) {
        this.brandMapper.insertSelective(brand);
        //插入中间表值
        cids.forEach(cid -> this.brandMapper.insertBrandAndCategory(cid,brand.getId()));
    }
}

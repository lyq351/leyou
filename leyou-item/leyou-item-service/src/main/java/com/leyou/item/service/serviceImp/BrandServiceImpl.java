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
        //添加分页条件
        Page page1 = PageHelper.startPage(page,rows);
        String descOrAsc = desc ? "desc" : "asc";
        List<Brand> brandList = this.brandMapper.queryByKey(key,sortBy,descOrAsc);
        // 包装成pageInfo
        //PageInfo<Brand> pageInfo = new PageInfo<>(brandList);
        //new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
        return  new PageResult(page1.getTotal(),page1.getPageSize(),brandList);

//        Example example = new Example(Brand.class);
//        Example.Criteria criteria = example.createCriteria();
//        //添加分页条件
//        Page page1 = PageHelper.startPage(page,rows);
//        if(StringUtils.isNotEmpty(key)){
//            criteria.andLike("name","%"+key+"%")
//            .orEqualTo("letter",key);
//        }
//        if(StringUtils.isNotBlank(sortBy)){
//            example.setOrderByClause(sortBy+" "+(desc?"desc":"asc"));
//        }
//        List<Brand> brands = this.brandMapper.selectByExample(example);
//        // 包装成pageInfo
//        PageInfo<Brand> pageInfo = new PageInfo<>(brands);
//
//        //return  new PageResult(pageInfo.getTotal(),pageInfo.getPageSize(),brands);
//        return  new PageResult(page1.getTotal(),page1.getPageSize(),brands);
    }

    /**
     * 逻辑分页
     * @param key
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @return
     */
    private PageResult getPageResult(String key, Integer page, Integer rows, String sortBy, Boolean desc){
        String descOrAsc = desc ? "desc" : "asc";
        List<Brand> brandList = this.brandMapper.queryByKey(key,sortBy,descOrAsc);
        page = Math.max(page, 0);
        // 默认至少返回5行
        rows = Math.max(rows, 5);
        int startRow = 0;
        int endRow = 0;
        if (brandList == null || brandList.size() == 0) {
            return new PageResult(0L,brandList);
        }
        int totalCount = brandList.size();
        startRow = page > 0 ? (page-1) * rows : 0;
        endRow = startRow + rows;
        endRow = Math.min(endRow, totalCount);
        brandList = brandList.subList(startRow, endRow);
        return  new PageResult((long)totalCount,rows,brandList);
    }

    @Override
    public void saveBrand(Brand brand,List<Long> cids) {
        int result =  this.brandMapper.insertSelective(brand);
        System.out.println(result);
        //插入中间表值
        cids.forEach(cid -> this.brandMapper.insertBrandAndCategory(cid,brand.getId()));
    }

    @Override
    public void deleteBrand(String id) {
        Brand brand = new Brand();
        brand.setId(Long.parseLong(id));
        this.brandMapper.delete(brand);
    }
}

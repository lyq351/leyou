package com.leyou.item.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * 规格参数分组表
 *
 * @Author yql
 * @Date 2023-12-17 18:19
 **/
@Table(name = "tb_spec_group")
@Getter
@Setter
public class SpecGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 主键',

    private Long cid; // 商品分类id，一个分类下有多个规格组

    private String name; // 规格组的名称

    @Transient
    private List<SpecParam> params;
}

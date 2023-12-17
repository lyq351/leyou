package com.leyou.item.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 规格参数表
 *
 * @Author yql
 * @Date 2023-12-17 18:20
 **/
@Table(name = "tb_spec_param")
@Setter
@Getter
public class SpecParam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自动递增。
    private Long id; // 主键
    private Long cid; // 商品分类id
    private Long groupId;  // 分组id
    private String name; // 参数名
    @Column(name = "`numeric`")
    private Boolean numeric; // 是否是数字类型参数，true或false
    private String unit; // 数字类型参数的单位，非数字类型可以为空
    private Boolean generic; // 是否是sku通用属性，true或false
    private Boolean searching; // 是否用于搜索过滤，true或false
    private String segments; //数值类型参数，如果需要搜索，则添加分段间隔值，如CPU频率间隔：0.5-1.0

    // getter和setter ...
}

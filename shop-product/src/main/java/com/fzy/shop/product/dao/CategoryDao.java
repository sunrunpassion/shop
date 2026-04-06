package com.fzy.shop.product.dao;

import com.fzy.shop.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author fzy
 * @email fzy@gmail.com
 * @date 2025-11-10 14:05:15
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}

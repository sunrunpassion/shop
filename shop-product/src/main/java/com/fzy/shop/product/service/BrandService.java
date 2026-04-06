package com.fzy.shop.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fzy.common.utils.PageUtils;
import com.fzy.shop.product.entity.BrandEntity;

import java.util.List;
import java.util.Map;

/**
 * 品牌
 *
 * @author fzy
 * @email fzy@gmail.com
 * @date 2025-11-10 14:05:15
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void updateDetail(BrandEntity brand);

    List<BrandEntity> getBrandsById(List<Long> brandIds);
}


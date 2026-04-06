package com.fzy.shop.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fzy.common.to.SkuReductionTo;
import com.fzy.common.utils.PageUtils;
import com.fzy.shop.coupon.entity.SkuFullReductionEntity;

import java.util.Map;

/**
 * 商品满减信息
 *
 * @author fzy
 * @email fzy@gmail.com
 * @date 2025-10-29 20:51:33
 */
public interface SkuFullReductionService extends IService<SkuFullReductionEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveSkuReduction(SkuReductionTo skuReductionTo);
}


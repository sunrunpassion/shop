package com.fzy.shop.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fzy.common.utils.PageUtils;
import com.fzy.shop.coupon.entity.MemberPriceEntity;

import java.util.Map;

/**
 * 商品会员价格
 *
 * @author fzy
 * @email fzy@gmail.com
 * @date 2025-10-29 20:51:33
 */
public interface MemberPriceService extends IService<MemberPriceEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


package com.fzy.shop.coupon.dao;

import com.fzy.shop.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author fzy
 * @email fzy@gmail.com
 * @date 2025-10-29 20:51:34
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}

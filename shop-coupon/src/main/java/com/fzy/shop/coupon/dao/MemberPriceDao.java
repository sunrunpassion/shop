package com.fzy.shop.coupon.dao;

import com.fzy.shop.coupon.entity.MemberPriceEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品会员价格
 * 
 * @author fzy
 * @email fzy@gmail.com
 * @date 2025-10-29 20:51:33
 */
@Mapper
public interface MemberPriceDao extends BaseMapper<MemberPriceEntity> {
	
}

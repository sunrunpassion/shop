package com.fzy.shop.order.dao;

import com.fzy.shop.order.entity.OrderReturnReasonEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 退货原因
 * 
 * @author fzy
 * @email fzy@gmail.com
 * @date 2025-10-31 20:00:26
 */
@Mapper
public interface OrderReturnReasonDao extends BaseMapper<OrderReturnReasonEntity> {
	
}

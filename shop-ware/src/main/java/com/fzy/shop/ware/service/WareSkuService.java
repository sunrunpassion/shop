package com.fzy.shop.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fzy.common.to.OrderTo;
import com.fzy.common.to.mq.StockLockedTo;
import com.fzy.common.utils.PageUtils;
import com.fzy.shop.ware.entity.WareSkuEntity;
import com.fzy.shop.ware.vo.SkuHasStockVo;
import com.fzy.shop.ware.vo.WareSkuLockVo;

import java.util.List;
import java.util.Map;

/**
 * 商品库存
 *
 * @author fzy
 * @email fzy@gmail.com
 * @date 2025-10-31 20:04:06
 */
public interface WareSkuService extends IService<WareSkuEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 添加库存
     * @param skuId
     * @param wareId
     * @param skuNum
     */
    void addStock(Long skuId, Long wareId, Integer skuNum);

    /**
     * 判断是否有库存
     * @param skuIds
     * @return
     */
    List<SkuHasStockVo> getSkuHasStock(List<Long> skuIds);

    /**
     * 锁定库存
     * @param vo
     * @return
     */
    boolean orderLockStock(WareSkuLockVo vo);


    /**
     * 解锁库存
     * @param to
     */
    void unlockStock(StockLockedTo to);

    /**
     * 解锁订单
     * @param orderTo
     */
    void unlockStock(OrderTo orderTo);
}



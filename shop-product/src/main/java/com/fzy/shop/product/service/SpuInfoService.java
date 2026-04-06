package com.fzy.shop.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fzy.common.utils.PageUtils;
import com.fzy.shop.product.entity.SpuInfoEntity;
import com.fzy.shop.product.vo.SpuSaveVo;

import java.util.Map;

/**
 * spu信息
 *
 * @author fzy
 * @email fzy@gmail.com
 * @date 2025-11-10 14:05:15
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void savesupInfo(SpuSaveVo vo);

    void saveBaseSpuInfo(SpuInfoEntity spuInfoEntity);

    PageUtils queryPageByCondtion(Map<String, Object> params);

    void up(Long spuId);

    SpuInfoEntity getSpuInfoBySkuId(Long skuId);
}


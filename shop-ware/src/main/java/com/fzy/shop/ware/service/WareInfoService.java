package com.fzy.shop.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fzy.common.utils.PageUtils;
import com.fzy.shop.ware.entity.WareInfoEntity;
import com.fzy.shop.ware.vo.FareVo;

import java.util.Map;

/**
 * 仓库信息
 *
 * @author fzy
 * @email fzy@gmail.com
 * @date 2025-10-31 20:04:06
 */
public interface WareInfoService extends IService<WareInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 获取运费和收货地址信息
     * @param addrId
     * @return
     */
    FareVo getFare(Long addrId);
}


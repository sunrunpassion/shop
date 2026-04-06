package com.fzy.shop.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fzy.common.utils.PageUtils;
import com.fzy.shop.ware.entity.WareOrderTaskDetailEntity;

import java.util.Map;

/**
 * 库存工作单
 *
 * @author fzy
 * @email fzy@gmail.com
 * @date 2025-10-31 20:04:06
 */
public interface WareOrderTaskDetailService extends IService<WareOrderTaskDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


package com.fzy.shop.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fzy.common.utils.PageUtils;
import com.fzy.shop.ware.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author fzy
 * @email fzy@gmail.com
 * @date 2025-10-31 20:04:06
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


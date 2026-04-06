package com.fzy.shop.product.fallback;

import com.fzy.common.exception.BizCodeEnum;
import com.fzy.common.utils.R;
import com.fzy.shop.product.feign.SeckillFeignService;
import org.springframework.stereotype.Component;


@Component
public class SeckillFeignServiceFallBack implements SeckillFeignService {
    @Override
    public R getSkuSeckilInfo(Long skuId) {
        return R.error(BizCodeEnum.TO_MANY_REQUEST.getCode(),BizCodeEnum.TO_MANY_REQUEST.getMsg());
    }
}

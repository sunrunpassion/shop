package com.fzy.shop.member.fegin;

import com.fzy.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "shop-coupon")
public interface CouponFeginService {

    @RequestMapping("/coupon/coupon/member/list")
    public R memberCoupons();
}

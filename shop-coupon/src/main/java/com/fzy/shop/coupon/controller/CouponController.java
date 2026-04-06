package com.fzy.shop.coupon.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
//import org.springframework.core.env.ConfigurableEnvironment;
//import org.springframework.core.env.EnumerablePropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.core.env.PropertySource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fzy.shop.coupon.entity.CouponEntity;
import com.fzy.shop.coupon.service.CouponService;
import com.fzy.common.utils.PageUtils;
import com.fzy.common.utils.R;



/**
 * 优惠券信息
 *
 * @author fzy
 * @email fzy@gmail.com
 * @date 2025-10-29 20:51:34
 */
@RefreshScope
@RestController
@RequestMapping("coupon/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;

    @Value("${Coupon.user.name}")
    private String name;
    @Value("${Coupon.user.age}")
    private Integer age;
//    @Autowired // 注入 Environment
//    private Environment environment;
//
//    @Autowired
//    private ConfigurableEnvironment configurableEnvironment;

    @RequestMapping("/test")
    public R test(){
//        System.out.println("Controller instance hash: " + this.hashCode());
//        System.out.println("Current Name: " + name + ", Current Age: " + age);
//        String envName = environment.getProperty("Coupon.user.name");
//        String envAge = environment.getProperty("Coupon.user.age");
//        System.out.println("Current Name (from Environment): " + envName + ", Current Age (from Environment): " + envAge);
//        System.out.println("--- All Property Sources ---");
//        for (PropertySource<?> ps : configurableEnvironment.getPropertySources()) {
//            System.out.println("PropertySource Name: " + ps.getName() + ", Type: " + ps.getClass().getSimpleName());
//            if (ps instanceof EnumerablePropertySource) {
//                for (String propertyName : ((EnumerablePropertySource<?>) ps).getPropertyNames()) {
//                    if (propertyName.startsWith("Coupon.user.")) { // 只打印我们关心的
//                        System.out.println("  " + propertyName + " = " + ps.getProperty(propertyName));
//                    }
//                }
//            }
//        }
//        System.out.println("--------------------------");
        return R.ok().put("name", name).put("age", age);
    }
    @RequestMapping("/member/list")
    public R memberCoupons(){
        CouponEntity couponEntity = new CouponEntity();
        couponEntity.setCouponName("满100减50");
        return R.ok().put("coupons", Arrays.asList(couponEntity));
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:coupon:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = couponService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:coupon:info")
    public R info(@PathVariable("id") Long id){
		CouponEntity coupon = couponService.getById(id);

        return R.ok().put("coupon", coupon);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:coupon:save")
    public R save(@RequestBody CouponEntity coupon){
		couponService.save(coupon);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:coupon:update")
    public R update(@RequestBody CouponEntity coupon){
		couponService.updateById(coupon);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:coupon:delete")
    public R delete(@RequestBody Long[] ids){
		couponService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}

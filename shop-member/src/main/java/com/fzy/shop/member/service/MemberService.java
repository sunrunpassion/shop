package com.fzy.shop.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fzy.common.utils.PageUtils;
import com.fzy.shop.member.entity.MemberEntity;
import com.fzy.shop.member.exception.PhoneException;
import com.fzy.shop.member.exception.UsernameException;
import com.fzy.shop.member.vo.MemberUserLoginVo;
import com.fzy.shop.member.vo.MemberUserRegisterVo;
import com.fzy.shop.member.vo.SocialUser;

import java.util.Map;

/**
 * 会员
 *
 * @author fzy
 * @email fzy@gmail.com
 * @date 2025-10-31 19:30:00
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 用户注册
     * @param vo
     */
    void register(MemberUserRegisterVo vo);

    /**
     * 判断邮箱是否重复
     * @param phone
     * @return
     */
    void checkPhoneUnique(String phone) throws PhoneException;

    /**
     * 判断用户名是否重复
     * @param userName
     * @return
     */
    void checkUserNameUnique(String userName) throws UsernameException;

    /**
     * 用户登录
     * @param vo
     * @return
     */
    MemberEntity login(MemberUserLoginVo vo);

    /**
     * 社交用户的登录
     * @param socialUser
     * @return
     */
    MemberEntity login(SocialUser socialUser) throws Exception;

}


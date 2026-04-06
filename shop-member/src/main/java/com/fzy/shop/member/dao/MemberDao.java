package com.fzy.shop.member.dao;

import com.fzy.shop.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author fzy
 * @email fzy@gmail.com
 * @date 2025-10-31 19:30:00
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}

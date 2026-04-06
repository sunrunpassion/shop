package com.fzy.shop.product;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.fzy.shop.product.dao.AttrGroupDao;
import com.fzy.shop.product.dao.SkuSaleAttrValueDao;
import com.fzy.shop.product.entity.BrandEntity;
import com.fzy.shop.product.service.BrandService;
import com.fzy.shop.product.vo.SkuItemSaleAttrVo;
import com.fzy.shop.product.vo.SpuItemAttrGroupVo;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@SpringBootTest
public class ShopProductApplicationTests {

	@Autowired
	BrandService brandService;

	@Resource
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedissonClient redissonClient;

	@Resource
	private AttrGroupDao attrGroupDao;

	@Resource
	private SkuSaleAttrValueDao skuSaleAttrValueDao;

	@Test
	public void test1() {
		List<SkuItemSaleAttrVo> saleAttrBySpuId = skuSaleAttrValueDao.getSaleAttrBySpuId(1L);
		saleAttrBySpuId.forEach(System.out::println);
	}

	@Test
	public void test() {
		List<SpuItemAttrGroupVo> attrGroupWithAttrsBySpuId = attrGroupDao.getAttrGroupWithAttrsBySpuId(1L, 225L);
		attrGroupWithAttrsBySpuId.forEach(System.out::println);
	}
	@Test
	public void testRedisson() {
		System.out.println(redissonClient);
	}

	@Test
	public void testStringRedis() {
		ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();

		//保存
		ops.set("hello","world_" + UUID.randomUUID().toString());

		//查询
		String hello = ops.get("hello");
		System.out.println("之前保存的数据:"+hello);
	}
	@Test
	public void testUpload() throws FileNotFoundException {
		// Endpoint以杭州为例，其它Region请按实际情况填写。
		String endpoint = "oss-cn-beijing.aliyuncs.com";
// 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
		String accessKeyId = "";
		String accessKeySecret = "";

// 创建OSSClient实例。
		OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

// 上传文件流。
		InputStream inputStream = new FileInputStream("E:\\study\\尚硅谷\\课件和文档\\基础篇\\资料\\pics\\ccd1077b985c7150.jpg");
		ossClient.putObject("fzyshop", "bug.jpg", inputStream);

// 关闭OSSClient。
		ossClient.shutdown();
		System.out.println("上傳完成");
	}
	@Test
	public void contextLoads() {
//		BrandEntity brandEntity = new BrandEntity();
//		brandEntity.setBrandId(1L);
//		brandEntity.setDescript("华为");
//		brandEntity.setName("华为");
//		brandService.save(brandEntity);
//		System.out.println("保存成功");
//		brandService.updateById(brandEntity);
		List<BrandEntity> brandId = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 1L));
		brandId.forEach((item) -> {
			System.out.println(item);
		});

	}
}

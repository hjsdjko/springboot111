package com.cl.entity.view;

import com.cl.entity.KechengbaomingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 课程报名
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-09 13:25:06
 */
@TableName("kechengbaoming")
public class KechengbaomingView  extends KechengbaomingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public KechengbaomingView(){
	}
 
 	public KechengbaomingView(KechengbaomingEntity kechengbaomingEntity){
 	try {
			BeanUtils.copyProperties(this, kechengbaomingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}

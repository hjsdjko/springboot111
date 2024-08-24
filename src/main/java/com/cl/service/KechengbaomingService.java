package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.KechengbaomingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KechengbaomingView;


/**
 * 课程报名
 *
 * @author 
 * @email 
 * @date 2024-03-09 13:25:06
 */
public interface KechengbaomingService extends IService<KechengbaomingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KechengbaomingView> selectListView(Wrapper<KechengbaomingEntity> wrapper);
   	
   	KechengbaomingView selectView(@Param("ew") Wrapper<KechengbaomingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KechengbaomingEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<KechengbaomingEntity> wrapper);

}


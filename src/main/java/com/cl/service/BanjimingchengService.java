package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.BanjimingchengEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BanjimingchengView;


/**
 * 班级名称
 *
 * @author 
 * @email 
 * @date 2024-03-09 13:25:06
 */
public interface BanjimingchengService extends IService<BanjimingchengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BanjimingchengView> selectListView(Wrapper<BanjimingchengEntity> wrapper);
   	
   	BanjimingchengView selectView(@Param("ew") Wrapper<BanjimingchengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BanjimingchengEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<BanjimingchengEntity> wrapper);

}


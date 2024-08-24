package com.cl.dao;

import com.cl.entity.KechengbaomingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KechengbaomingView;


/**
 * 课程报名
 * 
 * @author 
 * @email 
 * @date 2024-03-09 13:25:06
 */
public interface KechengbaomingDao extends BaseMapper<KechengbaomingEntity> {
	
	List<KechengbaomingView> selectListView(@Param("ew") Wrapper<KechengbaomingEntity> wrapper);

	List<KechengbaomingView> selectListView(Pagination page,@Param("ew") Wrapper<KechengbaomingEntity> wrapper);
	
	KechengbaomingView selectView(@Param("ew") Wrapper<KechengbaomingEntity> wrapper);
	
	List<KechengbaomingView> selectGroupBy(Pagination page,@Param("ew") Wrapper<KechengbaomingEntity> wrapper);

}

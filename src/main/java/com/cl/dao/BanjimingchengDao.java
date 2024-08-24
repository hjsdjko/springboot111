package com.cl.dao;

import com.cl.entity.BanjimingchengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BanjimingchengView;


/**
 * 班级名称
 * 
 * @author 
 * @email 
 * @date 2024-03-09 13:25:06
 */
public interface BanjimingchengDao extends BaseMapper<BanjimingchengEntity> {
	
	List<BanjimingchengView> selectListView(@Param("ew") Wrapper<BanjimingchengEntity> wrapper);

	List<BanjimingchengView> selectListView(Pagination page,@Param("ew") Wrapper<BanjimingchengEntity> wrapper);
	
	BanjimingchengView selectView(@Param("ew") Wrapper<BanjimingchengEntity> wrapper);
	
	List<BanjimingchengView> selectGroupBy(Pagination page,@Param("ew") Wrapper<BanjimingchengEntity> wrapper);

}

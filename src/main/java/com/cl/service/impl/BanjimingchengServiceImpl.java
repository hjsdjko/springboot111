package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.BanjimingchengDao;
import com.cl.entity.BanjimingchengEntity;
import com.cl.service.BanjimingchengService;
import com.cl.entity.view.BanjimingchengView;

@Service("banjimingchengService")
public class BanjimingchengServiceImpl extends ServiceImpl<BanjimingchengDao, BanjimingchengEntity> implements BanjimingchengService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<BanjimingchengEntity> wrapper) {
		Page<BanjimingchengView> page =new Query<BanjimingchengView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BanjimingchengEntity> page = this.selectPage(
                new Query<BanjimingchengEntity>(params).getPage(),
                new EntityWrapper<BanjimingchengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BanjimingchengEntity> wrapper) {
		  Page<BanjimingchengView> page =new Query<BanjimingchengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<BanjimingchengView> selectListView(Wrapper<BanjimingchengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BanjimingchengView selectView(Wrapper<BanjimingchengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

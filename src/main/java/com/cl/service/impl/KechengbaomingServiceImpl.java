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


import com.cl.dao.KechengbaomingDao;
import com.cl.entity.KechengbaomingEntity;
import com.cl.service.KechengbaomingService;
import com.cl.entity.view.KechengbaomingView;

@Service("kechengbaomingService")
public class KechengbaomingServiceImpl extends ServiceImpl<KechengbaomingDao, KechengbaomingEntity> implements KechengbaomingService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<KechengbaomingEntity> wrapper) {
		Page<KechengbaomingView> page =new Query<KechengbaomingView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KechengbaomingEntity> page = this.selectPage(
                new Query<KechengbaomingEntity>(params).getPage(),
                new EntityWrapper<KechengbaomingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KechengbaomingEntity> wrapper) {
		  Page<KechengbaomingView> page =new Query<KechengbaomingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<KechengbaomingView> selectListView(Wrapper<KechengbaomingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KechengbaomingView selectView(Wrapper<KechengbaomingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

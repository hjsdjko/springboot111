package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.KechengbaomingEntity;
import com.cl.entity.view.KechengbaomingView;

import com.cl.service.KechengbaomingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 课程报名
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-09 13:25:06
 */
@RestController
@RequestMapping("/kechengbaoming")
public class KechengbaomingController {
    @Autowired
    private KechengbaomingService kechengbaomingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KechengbaomingEntity kechengbaoming,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			kechengbaoming.setJiaoshizhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			kechengbaoming.setXueshengzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<KechengbaomingEntity> ew = new EntityWrapper<KechengbaomingEntity>();

		PageUtils page = kechengbaomingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kechengbaoming), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KechengbaomingEntity kechengbaoming, 
		HttpServletRequest request){
        EntityWrapper<KechengbaomingEntity> ew = new EntityWrapper<KechengbaomingEntity>();

		PageUtils page = kechengbaomingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kechengbaoming), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KechengbaomingEntity kechengbaoming){
       	EntityWrapper<KechengbaomingEntity> ew = new EntityWrapper<KechengbaomingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kechengbaoming, "kechengbaoming")); 
        return R.ok().put("data", kechengbaomingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KechengbaomingEntity kechengbaoming){
        EntityWrapper< KechengbaomingEntity> ew = new EntityWrapper< KechengbaomingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kechengbaoming, "kechengbaoming")); 
		KechengbaomingView kechengbaomingView =  kechengbaomingService.selectView(ew);
		return R.ok("查询课程报名成功").put("data", kechengbaomingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KechengbaomingEntity kechengbaoming = kechengbaomingService.selectById(id);
		kechengbaoming = kechengbaomingService.selectView(new EntityWrapper<KechengbaomingEntity>().eq("id", id));
        return R.ok().put("data", kechengbaoming);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KechengbaomingEntity kechengbaoming = kechengbaomingService.selectById(id);
		kechengbaoming = kechengbaomingService.selectView(new EntityWrapper<KechengbaomingEntity>().eq("id", id));
        return R.ok().put("data", kechengbaoming);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KechengbaomingEntity kechengbaoming, HttpServletRequest request){
    	kechengbaoming.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kechengbaoming);
        kechengbaomingService.insert(kechengbaoming);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KechengbaomingEntity kechengbaoming, HttpServletRequest request){
    	kechengbaoming.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kechengbaoming);
        kechengbaomingService.insert(kechengbaoming);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KechengbaomingEntity kechengbaoming, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kechengbaoming);
        kechengbaomingService.updateById(kechengbaoming);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<KechengbaomingEntity> list = new ArrayList<KechengbaomingEntity>();
        for(Long id : ids) {
            KechengbaomingEntity kechengbaoming = kechengbaomingService.selectById(id);
            kechengbaoming.setSfsh(sfsh);
            kechengbaoming.setShhf(shhf);
            list.add(kechengbaoming);
        }
        kechengbaomingService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kechengbaomingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}

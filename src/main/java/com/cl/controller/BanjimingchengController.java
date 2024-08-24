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

import com.cl.entity.BanjimingchengEntity;
import com.cl.entity.view.BanjimingchengView;

import com.cl.service.BanjimingchengService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 班级名称
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-09 13:25:06
 */
@RestController
@RequestMapping("/banjimingcheng")
public class BanjimingchengController {
    @Autowired
    private BanjimingchengService banjimingchengService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BanjimingchengEntity banjimingcheng,
		HttpServletRequest request){
        EntityWrapper<BanjimingchengEntity> ew = new EntityWrapper<BanjimingchengEntity>();

		PageUtils page = banjimingchengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, banjimingcheng), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,BanjimingchengEntity banjimingcheng, 
		HttpServletRequest request){
        EntityWrapper<BanjimingchengEntity> ew = new EntityWrapper<BanjimingchengEntity>();

		PageUtils page = banjimingchengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, banjimingcheng), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( BanjimingchengEntity banjimingcheng){
       	EntityWrapper<BanjimingchengEntity> ew = new EntityWrapper<BanjimingchengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( banjimingcheng, "banjimingcheng")); 
        return R.ok().put("data", banjimingchengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(BanjimingchengEntity banjimingcheng){
        EntityWrapper< BanjimingchengEntity> ew = new EntityWrapper< BanjimingchengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( banjimingcheng, "banjimingcheng")); 
		BanjimingchengView banjimingchengView =  banjimingchengService.selectView(ew);
		return R.ok("查询班级名称成功").put("data", banjimingchengView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BanjimingchengEntity banjimingcheng = banjimingchengService.selectById(id);
		banjimingcheng = banjimingchengService.selectView(new EntityWrapper<BanjimingchengEntity>().eq("id", id));
        return R.ok().put("data", banjimingcheng);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BanjimingchengEntity banjimingcheng = banjimingchengService.selectById(id);
		banjimingcheng = banjimingchengService.selectView(new EntityWrapper<BanjimingchengEntity>().eq("id", id));
        return R.ok().put("data", banjimingcheng);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BanjimingchengEntity banjimingcheng, HttpServletRequest request){
    	banjimingcheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(banjimingcheng);
        banjimingchengService.insert(banjimingcheng);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody BanjimingchengEntity banjimingcheng, HttpServletRequest request){
    	banjimingcheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(banjimingcheng);
        banjimingchengService.insert(banjimingcheng);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody BanjimingchengEntity banjimingcheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(banjimingcheng);
        banjimingchengService.updateById(banjimingcheng);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        banjimingchengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}

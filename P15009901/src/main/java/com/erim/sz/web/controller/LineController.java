package com.erim.sz.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.sz.common.bean.LineDetailBean;
import com.erim.sz.common.bean.LinePriceBean;
import com.erim.sz.common.bean.LineTripBean;
import com.erim.sz.common.bean.VCompanyDetailBean;
import com.erim.sz.common.util.ImageUtil;
import com.erim.sz.web.handler.WordGenerator;
import com.erim.sz.web.service.LineDetailService;
import com.erim.sz.web.service.LinePriceService;
import com.erim.sz.web.service.VCompanyDetailService;
import com.erim.utils.properties.PropertiesUtils;

/**
 * @ClassName: LineController 
 * @Description: 专线详情
 * @author maoxian
 * @date 2015年10月3日 下午5:05:44
 */
@Controller
public class LineController {
	
	@Autowired
	private LineDetailService     lineDetailService;
	@Autowired
	private LinePriceService      linePriceService;
	@Autowired
	private VCompanyDetailService vCompanyDetailService;

	@RequestMapping(value = "/{cpyno}/line/jingxuan")
	public String jingxuan(ModelMap model,String searchModel) {
		this.lineDetailService.selectHotLines(model);
		model.addAttribute("searchModel",1);
		return "/line/jingxuan";
	}
	
	@RequestMapping(value = "/{cpyno}/line/tejiaxiang/{id}")
	public String tejiaxiang(ModelMap model,@PathVariable("id")Integer id,String searchModel) {
		this.lineDetailService.selectLineById(id,model);
		this.lineDetailService.selectPriceByLineId(id,model);
		List<LineTripBean> lineTripBeanList = this.lineDetailService.selectLineTripByLineId(id,model);
		List<String> imglist = new ArrayList<String>();
		String ldlRecommend = "";
		for(int i = 0;i<lineTripBeanList.size();i++){
			LineTripBean bean = lineTripBeanList.get(i);
			imglist.add(bean.getGddImg1());
			imglist.add(bean.getGddImg2());
			ldlRecommend = bean.getLdlRecommend();
		}
		model.addAttribute("ldlRecommend",ldlRecommend);
		model.addAttribute("imglist", imglist);
		model.addAttribute("linetrip", lineTripBeanList);
		model.addAttribute("searchModel", 1);
		return "/line/tejiaxiang";
	}
	
	@RequestMapping(value = "/{cpyno}/line/zhuti")
	public String zhuti(ModelMap model) {
		return "/line/zhuti";
	}
	
	/**
	 * @Title: list 
	 * @Description: 专线列表
	 * @param @param model
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/line/list")
	public String list(ModelMap model,LineDetailBean bean){
		
		this.lineDetailService.showLine(model,bean);
		model.addAttribute("line", bean);
		return "/line/list";
	}
	
	/**
	 * @Title: jingxuan 
	 * @Description: 专线详细页面
	 * @param @param model
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/line/zhutixiang/{id}")
	public String zhutixiang(ModelMap model,@PathVariable("id") Integer id) {
		this.lineDetailService.selectLineById(id,model);
		this.lineDetailService.selectPriceByLineId(id,model);
		List<LineTripBean> lineTripBeanList = this.lineDetailService.selectLineTripByLineId(id,model);
		List<String> imglist = new ArrayList<String>();
		String ldlRecommend = "";
		for(int i = 0;i<lineTripBeanList.size();i++){
			LineTripBean bean = lineTripBeanList.get(i);
			imglist.add(bean.getGddImg1());
			imglist.add(bean.getGddImg2());
			ldlRecommend = bean.getLdlRecommend();
		}
		model.addAttribute("ldlRecommend",ldlRecommend);
		model.addAttribute("imglist", imglist);
		model.addAttribute("linetrip", lineTripBeanList);
		model.addAttribute("searchModel", 1);
		return "/line/tejiaxiang";
	}
	
	@RequestMapping(value = "/{cpyno}/line/price")
	public String priceList(ModelMap map, LinePriceBean bean) {
		linePriceService.getLinePriceList(map, bean);
		return "/line/price";
	}
	
	@RequestMapping(value = "/{cpyno}/line/price/date")
	public String priceDate(ModelMap map, LinePriceBean bean) {
		String portal = bean.getPortal();
		
		if ("01".equals(portal)) {
			// 量价项时间向前选择
			linePriceService.forward(map, bean);
		} else if ("02".equals(portal)) {
			// 时间向后选择
			linePriceService.backwards(map, bean);
		}
		
		return "/line/price";
	}
	
	
	
	/**
	 * @throws Exception 
	 * @throws UnsupportedEncodingException 
	 * @Title: exportWord 
	 * @Description: 当地游导出行程
	 * @param @param map
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @author maoxian
	 * @date 2015年12月25日 下午3:07:06 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/line/detail/exportWord")
	public String exportWord(ModelMap map, LineDetailBean bean,HttpServletResponse resp,@PathVariable("cpyno") String cpyno) throws Exception{
		
		LineDetailBean gdb = this.lineDetailService.selectBeanByLineId(bean.getId(), map);
		//图片转义 转为可用于word存储的结构
		VCompanyDetailBean vc = this.vCompanyDetailService.selectCompanyByCode(cpyno);
		if(StringUtils.isNotBlank(vc.getCpyImg())){
			//图片转义 转为可用于word存储的结构
			String cpyImg = PropertiesUtils.getPropertyByKey("app.staticFileRes") + vc.getCpyImg();
			String savePath = ImageUtil.download(cpyImg, UUID.randomUUID().toString().replace("-", "") + ".jpg",
					getClass().getResource("/").getFile().toString());
			if (StringUtils.isNotBlank(savePath)) {
				vc.setCpyImg(ImageUtil.getImgStr(savePath));
				ImageUtil.deleteFile(savePath);
			}
		}

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("gdb", gdb);
		//放置企业信息
		paramMap.put("vc", vc);

		// 提示：在调用工具类生成Word文档之前应当检查所有字段是否完整
		// 否则Freemarker的模板殷勤在处理时可能会因为找不到值而报错 这里暂时忽略这个步骤了
		File file = null;
		InputStream fin = null;
		ServletOutputStream out = null;
		try {
			// 调用工具类WordGenerator的createDoc方法生成Word文档
			file = WordGenerator.createDoc(paramMap, "line");
			fin = new FileInputStream(file);

			resp.setCharacterEncoding("utf-8");
			resp.setContentType("application/msword");
			// 设置浏览器以下载的方式处理该文件默认名为resume.doc
			resp.addHeader("Content-Disposition", "attachment;filename=resume.doc");

			out = resp.getOutputStream();
			byte[] buffer = new byte[512]; // 缓冲区
			int bytesToRead = -1;
			// 通过循环将读入的Word文件的内容输出到浏览器中
			while ((bytesToRead = fin.read(buffer)) != -1) {
				out.write(buffer, 0, bytesToRead);
			}
		} finally {
			if (fin != null)
				fin.close();
			if (out != null)
				out.close();
			if (file != null)
				file.delete(); // 删除临时文件
		}
		return null;
	}
}
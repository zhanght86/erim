package com.erim.sz.web.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.LineDetailBean;
import com.erim.sz.common.bean.MallShopBean;
import com.erim.sz.web.dao.MallShopDao;
import com.erim.web.bean.CodeBean;
import com.erim.web.service.CodeService;

/**
 * @ClassName: MallShopService 
 * @Description: 特价商城
 * @author maoxian
 * @date 2015年11月1日 下午11:54:49
 */
@Service("mallshopService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class MallShopService {

	@Autowired
	private MallShopDao 	     mallshopDao;
	@Autowired
	private CompanyDetailService companyDetailService;
	@Autowired
	private LineDetailService	 lineDetailService;
	@Autowired
	private CodeService          codeService;

	/**
	 * @Title: selectList 
	 * @Description: 商城
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return List<MallShopBean>    返回类型 
	 * @throws
	 */
	public void selectList(MallShopBean bean,ModelMap model){
		model.addAttribute("listmall", this.mallshopDao.selectList(bean));
	}
	
	
	/**
	 * @Title: initShopCity 
	 * @Description: 初始化商城
	 * @param @param cpyno
	 * @param @param model    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2016年1月3日 下午4:23:36 
	 * @throws
	 */
	public void initShopCity(String cpyno,ModelMap model){
		Integer cpyId = this.companyDetailService.getCpyId(cpyno);
		if(0 != cpyId){
			//获取组团选中的所有专线
			List<LineDetailBean> list = this.lineDetailService.selectAllListBean(model, cpyId);
			
			this.selectListBar(new MallShopBean(), model,list);
			
			//专线放置list中
			model.addAttribute("listLine", list);
		}
	}
	
	
	/**
	 * @Title: selectList 
	 * @Description: 旅游商城
	 * @param @param bean
	 * @param @param model
	 * @param @param listLine    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年12月25日 上午2:41:48 
	 * @throws
	 */
	public void selectListBar(MallShopBean bean,ModelMap model,List<LineDetailBean> listLine){
		bean.setMspId(0);
		List<MallShopBean> listShop = this.mallshopDao.selectList(bean);
		//主题
		List<CodeBean> listC086     = this.codeService.getSystemCodeListByCodeNo("C086");
		List<CodeBean> responseC086 = new ArrayList<CodeBean>();
		
		//周边
		List<CodeBean> listC116     = this.codeService.getSystemCodeListByCodeNo("C116");
		List<CodeBean> responseC116_ZB = new ArrayList<CodeBean>();
		//国内
		List<CodeBean> responseC116_GN = new ArrayList<CodeBean>();
		
		//学生活动
		List<CodeBean> listC111     = this.codeService.getSystemCodeListByCodeNo("C111");
		List<CodeBean> responseC111 = new ArrayList<CodeBean>();
				
		//国家
		List<CodeBean> listC118     = this.codeService.getSystemCodeListByCodeNo("C118");
		//欧、美
		List<CodeBean> responseOM   = new ArrayList<CodeBean>();
		//韩、日、朝
		List<CodeBean> responseHRC   = new ArrayList<CodeBean>();
		//东、南、泰
		List<CodeBean> responseDNT   = new ArrayList<CodeBean>();
		//澳、中
		List<CodeBean> responseAZ   = new ArrayList<CodeBean>();
		
		//港澳台
		List<CodeBean> listC108     = this.codeService.getSystemCodeListByCodeNo("C108");
		List<CodeBean> responseC108 = new ArrayList<CodeBean>();
			
		//遍历专线产品
		for(LineDetailBean line : listLine){
			//初始化主题
			String protype1 = line.getLdlProType1();
			if(StringUtils.isNotBlank(protype1)){
				for(CodeBean code : listC086){
					if(protype1.contains(code.getCodeKey()) && !responseC086.contains(code)){
						responseC086.add(code);
					}
				}
			}
			
			//初始化周边
			String ldlPerimeterIs = line.getLdlPerimeterIs();
			if("02".equals(ldlPerimeterIs)){
				String LdlSpecialLine = line.getLdlSpecialLine();
				if(StringUtils.isNotBlank(LdlSpecialLine)){
					for(CodeBean code : listC116){
						if(LdlSpecialLine.contains(code.getCodeValue()) && !responseC116_ZB.contains(code)){
							responseC116_ZB.add(code);
						}
					}
				}
			}
			//国内
			if("01".equals(ldlPerimeterIs)){
				String LdlSpecialLine = line.getLdlSpecialLine();
				if(StringUtils.isNotBlank(LdlSpecialLine)){
					for(CodeBean code : listC116){
						if(LdlSpecialLine.contains(code.getCodeValue()) && !responseC116_GN.contains(code)){
							responseC116_GN.add(code);
						}
					}
				}
			}
			
			//学生活动
			String ldlGame = line.getLdlGame();
			if(StringUtils.isNotBlank(ldlGame)){
				for(CodeBean code : listC111){
					if(StringUtils.isNotBlank(protype1)){
					  if(protype1.contains(code.getCodeKey()) && !responseC111.contains(code)){
						responseC111.add(code);
					  }
					}
				}
			}
			
			//国家 港澳台
			String LdlSpecialLine = line.getLdlSpecialLine();
			if(StringUtils.isNotBlank(LdlSpecialLine)){
				for(CodeBean code : listC118){
					if("01".equals(code.getCodeKey()) || "02".equals(code.getCodeKey())){
						if(LdlSpecialLine.contains(code.getCodeValue()) && !responseOM.contains(code)){
							responseOM.add(code);
						}
					}else if("03".equals(code.getCodeKey()) || "04".equals(code.getCodeKey()) || "05".equals(code.getCodeKey())){
						if(LdlSpecialLine.contains(code.getCodeValue()) && !responseHRC.contains(code)){
							responseHRC.add(code);
						}
					}else if("06".equals(code.getCodeKey()) || "07".equals(code.getCodeKey()) || "08".equals(code.getCodeKey())){
						if(LdlSpecialLine.contains(code.getCodeValue()) && !responseDNT.contains(code)){
							responseDNT.add(code);
						}
					}else if("09".equals(code.getCodeKey()) || "10".equals(code.getCodeKey())){
						if(LdlSpecialLine.contains(code.getCodeValue()) && !responseAZ.contains(code)){
							responseAZ.add(code);
						}
					}
				}
				
				//港澳台
				for(CodeBean code : listC108){
					if(LdlSpecialLine.contains(code.getCodeValue()) && !responseC108.contains(code)){
						responseC108.add(code);
					}
				}
			}
		}
		
		
		for(MallShopBean shop : listShop){
			Integer shopId = shop.getId();
			
			switch (shopId) {
			//1 主题游&nbsp;&nbsp;&nbsp;周末&nbsp;&nbsp;&nbsp;海岛
			case 1:
				shop.setListCode(responseC086); 
				shop.setQueryLink("&ldlProType1=");
				break;
			//2 周边旅游
			case 2:
				shop.setListCode(responseC116_ZB); 
				shop.setQueryLink("&ldlPerimeterIs=02&ldlSpecialLine=");
				break;
			//3 国内旅游
			case 3:
				shop.setListCode(responseC116_GN);  
				shop.setQueryLink("&ldlPerimeterIs=01&ldlSpecialLine=");
				break;
			//4 学生活动
			case 4:
				shop.setListCode(responseC111); 
				shop.setQueryLink("&ldlGame=");
				break;
			//5 欧洲&nbsp;&nbsp;&nbsp;美洲
			case 5:
				shop.setListCode(responseOM);
				shop.setQueryLink("&ldlSpecialLine=");
				break;
			//6 韩国&nbsp;&nbsp;&nbsp;日本&nbsp;&nbsp;&nbsp;朝鲜
			case 6:
				shop.setListCode(responseHRC);
				shop.setQueryLink("&ldlSpecialLine=");
				break;
			//7 东南亚&nbsp;&nbsp;&nbsp;南亚&nbsp;&nbsp;&nbsp;泰国
			case 7:
				shop.setListCode(responseDNT);
				
				shop.setQueryLink("&ldlSpecialLine=");
				break;
			//8 香港&nbsp;&nbsp;&nbsp;澳门&nbsp;&nbsp;&nbsp;台湾
			case 8:
				shop.setListCode(responseC108);
				
				shop.setQueryLink("&ldlSpecialLine=");
				break;
			//9 澳洲&nbsp;&nbsp;&nbsp;中东非洲
			case 9:
				shop.setListCode(responseAZ);
				shop.setQueryLink("&ldlSpecialLine=");
				break;
			default:
				break;
			}
		}
		model.addAttribute("listmall", listShop);
	}
}
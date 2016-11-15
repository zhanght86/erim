package com.erim.sz.common.util;

/**
 * @ClassName: CodeUtil 
 * @Description: 编码生成
 * @author maoxian
 * @date 2015年10月4日 下午2:08:44
 */
public class CodeUtil {

	//签证
	public static String NTYPE_MANAGEMENT  = "Q";
	//租车
	public static String NTYPE_TEXI		   = "Z";
	//酒店
	public static String NTYPE_HOTEL       = "J";
	//门票
	public static String NTYPE_TICKET      = "M";
	//特色餐
	public static String NTYPE_CAFETERIA   = "T";
	//套餐
	public static String NTYPE_PACKAGE     = "C";
	//飞机
	public static String NTYPE_PLANETICKET = "F";
	//火车
	public static String NTYPE_TRANSTICKET = "H";
	//导游
	public static String NTYPE_GUIDE       = "D";
	//专线
	public static String NTYPE_LINE        = "X";
	//当地
	public static String NTYPE_GROUND      = "L";
	
	
	/**
	 * @Title: getShopCode 
	 * @Description: 生成产品编号
	 * @param @param type
	 * @param @param cpyid
	 * @param @param id
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	public static String getShopCode(String type,Integer cpyid,Integer id){
		//企业id增加数值
		Integer CODE = 2229,NUM  = 1982;
		//返回产品编号
		return type+(cpyid+CODE)+(id+NUM);
	}
}

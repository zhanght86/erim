package com.erim.sz.system.aspect;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import com.erim.sz.system.bean.SellSystemLogBean;
import com.erim.sz.system.bean.SellSystemRescourceBean;
import com.erim.sz.system.service.SellSystemLogService;
import com.erim.sz.system.service.SellSystemRescourceService;
import com.erim.utils.ip.IP4;

/**
 * 
 * @ClassName: SellSystemLogAspect
 * @Description: 日志记录
 * @author maoxian
 * @date 2015年8月6日 下午8:12:02
 */
@Aspect
public class SellSystemLogAspect {

	@Autowired
	private SellSystemLogService       sellSystemLogService;
	@Autowired
	private SellSystemRescourceService sellSystemRescourceService;

	@Autowired(required = true)
	private HttpServletRequest request;
	/**
	 * 
	 * 添加业务逻辑方法切入点
	 * 
	 */

	@Pointcut("execution(* com.erim.sz.*.service.*.insert*(..))")

	public void insertServiceCall() {
	};

	/**
	 * 
	 * 修改业务逻辑方法切入点
	 * 
	 */

	@Pointcut("execution(* com.erim.sz.*.service.*.update*(..))")

	public void updateServiceCall() {
	}

	/**
	 * 
	 * 删除业务逻辑方法切入点
	 * 
	 */

	@Pointcut("execution(* com.erim.sz.*.service.*.delete*(..))")

	public void deleteServiceCall() {
	}

	/**
	 * 
	 * 查询业务逻辑方法切入点
	 * 
	 */

	@Pointcut("execution(* com.erim.sz.*.service.*.select*(..))")

	public void selectServiceCall() {
	};
	
	/**
	 * 
	 * 业务逻辑方法切入点
	 * 
	 */

	@Pointcut("execution(* com.erim.sz.*.service.*.show*(..))")

	public void showServiceCall() {
	};

	/**
	 * 
	 * 添加操作日志(后置通知)
	 * 
	 * @param joinPoint
	 * 
	 * @param rtv
	 * 
	 * @throws Throwable
	 * 
	 */

	@AfterReturning(value = "insertServiceCall()", argNames = "rtv", returning = "rtv")

	public void insertServiceCallCalls(JoinPoint joinPoint, Object rtv) throws Throwable {

		this.insertLog(joinPoint, rtv, "添加");

	}

	/**
	 * 
	 * 修改操作日志(后置通知)
	 * 
	 * @param joinPoint
	 * 
	 * @param rtv
	 * 
	 * @throws Throwable
	 * 
	 */

	@AfterReturning(value = "updateServiceCall()", argNames = "rtv", returning = "rtv")

	public void updateServiceCallCalls(JoinPoint joinPoint, Object rtv) throws Throwable {

		this.insertLog(joinPoint, rtv, "修改");

	}

	/**
	 * 
	 * 修改操作日志(后置通知)
	 * 
	 * @param joinPoint
	 * 
	 * @param rtv
	 * 
	 * @throws Throwable
	 * 
	 */

	@AfterReturning(value = "selectServiceCall()", argNames = "rtv", returning = "rtv")

	public void selectServiceCallCalls(JoinPoint joinPoint, Object rtv) throws Throwable {

		this.insertLog(joinPoint, rtv, "查询");

	}
	
	/**
	 * 
	 * @Title: showServiceCall 
	 * @Description: 分页查询
	 * @param @param joinPoint
	 * @param @param rtv
	 * @param @throws Throwable    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	@AfterReturning(value = "showServiceCall()", argNames = "rtv", returning = "rtv")

	public void showServiceCall(JoinPoint joinPoint, Object rtv) throws Throwable {

		this.insertLog(joinPoint, rtv, "查询");

	}

	/**
	 * 
	 * 修改操作日志(后置通知)
	 * 
	 * @param joinPoint
	 * 
	 * @param rtv
	 * 
	 * @throws Throwable
	 * 
	 */

	@AfterReturning(value = "deleteServiceCall()", argNames = "rtv", returning = "rtv")

	public void deleteServiceCallCalls(JoinPoint joinPoint, Object rtv) throws Throwable {

		this.insertLog(joinPoint, rtv, "删除");

	}

	public void insertLog(JoinPoint joinPoint, Object rtv, String title) throws Exception {

		// 判断参数

		if (joinPoint.getArgs() == null) {// 没有参数

			return;

		}

		// 获取方法名

		String methodName = joinPoint.getSignature().getName();

		// 获取操作内容

		String opContent = "";

		try {

			opContent = adminOptionContent(joinPoint.getArgs(), methodName);

		} catch (Exception e) {

			opContent = "";

		}
		
		// 获取session
		Session securitySession = SecurityUtils.getSubject().getSession();
		if (null != securitySession) {
			String uri = request.getRequestURI();
			
			SellSystemLogBean sellSystemLogBean = new SellSystemLogBean();
			sellSystemLogBean.setLogUserid((Integer)securitySession.getAttribute("userId"));
			sellSystemLogBean.setLogUsername((String) securitySession.getAttribute("userName"));
			sellSystemLogBean.setLogUserrealname((String) securitySession.getAttribute("userRealname"));
			sellSystemLogBean.setLogUsercpyid((Integer) securitySession.getAttribute("userCpyId"));
			sellSystemLogBean.setLogContent(StringUtils.isNotBlank(opContent) ? opContent : "");
			sellSystemLogBean.setLogOperation(title);
			sellSystemLogBean.setLogIp(IP4.getIP4(request));
			
			SellSystemRescourceBean rescourceBean = this.sellSystemRescourceService.getOneByRescourceUrl(uri);
			if(null != rescourceBean){
				sellSystemLogBean.setLogUrl(uri);
				sellSystemLogBean.setLogResourceName(rescourceBean.getSellRescourceName());
				sellSystemLogBean.setLogFuncResourceCode(rescourceBean.getSellFuncRescourceCode());
				sellSystemLogBean.setLogFuncCode("1".equals(rescourceBean.getSellFuncRescourceCode())?"1":
						rescourceBean.getSellFuncRescourceCode().substring(0, rescourceBean.getSellFuncRescourceCode().lastIndexOf("_")));
			}
			this.sellSystemLogService.save(sellSystemLogBean);
		}
	}

	/**
	 * 
	 * 使用Java反射来获取被拦截方法(insert、update)的参数值，
	 * 
	 * 将参数值拼接为操作内容
	 * 
	 */

	public String adminOptionContent(Object[] args, String mName) throws Exception {

		if (args == null) {

			return null;

		}

		StringBuffer rs = new StringBuffer();

		rs.append(mName);

		String className = null;

		int index = 1;

		// 遍历参数对象

		for (Object info : args) {

			// 获取对象类型

			className = info.getClass().getName();

			className = className.substring(className.lastIndexOf(".") + 1);

			rs.append("[参数" + index + "，类型：" + className + "，值：");

			// 获取对象的所有方法

			Method[] methods = info.getClass().getDeclaredMethods();

			// 遍历方法，判断get方法

			for (Method method : methods) {

				String methodName = method.getName();

				// 判断是不是get方法

				if (methodName.indexOf("get") == -1) {// 不是get方法

					continue;// 不处理

				}

				Object rsValue = null;

				try {

					// 调用get方法，获取返回值

					rsValue = method.invoke(info);

					if (rsValue == null) {// 没有返回值

						continue;

					}

				} catch (Exception e) {

					continue;

				}

				// 将值加入内容中

				rs.append("(" + methodName + " : " + rsValue + ")");

			}

			rs.append("]");

			index++;

		}

		return rs.toString();

	}
}

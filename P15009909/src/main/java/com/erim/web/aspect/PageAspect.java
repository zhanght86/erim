package com.erim.web.aspect;

import org.apache.ibatis.session.SqlSession;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.exception.ErimException;
import com.erim.sz.common.util.PropertyUtil;
import com.erim.utils.pagelink.PageLinkUtils;

@Component
@Aspect
public class PageAspect {

    @Autowired
    private SqlSession sqlSession;

    // 第一个*，表示任意返回类型
    // 第二个*，表示任意类
    // 第三个*，表示任意开头为selectPage的方法
    // (..)，任意参数
    @Around("execution(* com.erim.*.*.dao.*.selectPage*(..))")
    public Object pagelink(ProceedingJoinPoint pjp) throws ErimException {

        // 连接点方法返回值
        Object retVal = null;

        try {
            // 获取目标对象类名
            String clazzName = pjp.getTarget().getClass().getSimpleName();

            // 去除DAO
            clazzName = clazzName.substring(0, clazzName.indexOf("Dao")).toLowerCase();

            // 获取将要执行的方法名称
            String methodName = pjp.getSignature().getName();

            // 获取执行方法的参数
            Object[] args = pjp.getArgs();

            // 转化参数为BaseBean
            BaseBean bean = (BaseBean) args[0];

            // 获取分页记录总条数
            int count = sqlSession.selectOne(clazzName + "." + methodName + "Count", bean);

            // 处理翻页参数
            PageLinkUtils.dealBaseBean(bean, count);

            // 将新的参数替换原有方法的参数
            retVal = pjp.proceed(args);

            // 将pagelink传入前台
            ModelMap model = (ModelMap) args[1];
            model.put("pagelink", bean.getPageLinkBean());
            //设置分页查询条件 start
            bean.setPageLinkBean(null);
    		model.put("pageCondition", PropertyUtil.getObject(bean));
    		//放置分页查询条件 end

        } catch (Throwable e) {
            e.printStackTrace();
            throw new ErimException("pagelink拦截器错误！");
        }

        return retVal;
    }

}
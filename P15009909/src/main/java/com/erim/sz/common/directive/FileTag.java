package com.erim.sz.common.directive;

import java.io.IOException;
import java.io.Writer;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.directive.Directive;
import org.apache.velocity.runtime.parser.node.Node;
import org.apache.velocity.runtime.parser.node.SimpleNode;

import com.erim.utils.properties.PropertiesUtils;

/**
 * @ClassName: Text 
 * @Description: 字典转换文本
 * @author maoxian
 * @date 2015年12月2日 下午2:03:11
 */
public class FileTag extends Directive {

	@Override
	public String getName() {
		return "vfile";
	}

	@Override
	public int getType() {
		return LINE;
	}

	@Override
	public boolean render(InternalContextAdapter context, Writer writer, Node node)
			throws IOException, ResourceNotFoundException, ParseErrorException, MethodInvocationException {
		//name
		SimpleNode name = (SimpleNode) node.jjtGetChild(0);
		//name转为string
		String strname  = (String) name.value(context);
		//name
		SimpleNode id   = (SimpleNode) node.jjtGetChild(1);
		//name转为string
		String strid    = (String) id.value(context);
		
		//val
		SimpleNode val  = (SimpleNode) node.jjtGetChild(2);
		//name转为val
		String strval   = (String) val.value(context);
		
		StringBuffer sb = new StringBuffer();
		if(StringUtils.isNotBlank(strval)){
			sb.append("<input name=\"").append(strname).append("\" value=\"").append(strval).append("\" type=\"hidden\" id=\"").append(strid).append("\"/>");
			sb.append("<input name=\"file\" id=\"").append(strname).append("_file\" contenteditable=\"false\" size=\"30\" type=\"file\" />");
			sb.append("<img class=\"img200\" style=\"width:300px;\" src=\""+PropertiesUtils.getPropertyByKey("app.staticFileRes")+"").append(strval).append("\" /><a href=\"javascript:uploadDelete('").append(strname).append("_file','").append(strname).append("_filespan','").append(strval).append("','").append(strid).append("');\">删除图片</a>");
		}else{
			sb.append("<input name=\"").append(strname).append("\" value=\"\" type=\"hidden\" id=\"").append(strid).append("\"/>");
			sb.append("<input name=\"file\" id=\"").append(strname).append("_file\" contenteditable=\"false\" size=\"30\" type=\"file\" />");
		}
		sb.append("<span id=\"").append(strname).append("_filespan\"></span>");
		sb.append("<div id=\"").append(strname).append("_fileQueue\"></div>");
		sb.append("<script type=\"text/javascript\">uploadify('").append(strname).append("_file','").append(strid).append("','").append(strname).append("_filespan','").append(strname).append("_fileQueue');");
		//如果不为空
		if(StringUtils.isNotBlank(strval)){
			sb.append("$(\"#").append(strname).append("_file\").hide();");
		}
		sb.append("</script>");
		
		System.out.println(sb.toString());
		writer.write(sb.toString());
		return true;
	}
}

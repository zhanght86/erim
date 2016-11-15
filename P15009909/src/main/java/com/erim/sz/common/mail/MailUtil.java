package com.erim.sz.common.mail;

/**
 * @ClassName: MailUtil
 * @Description: 邮件发送
 * @author maoxian
 * @date 2015年11月30日 下午8:47:53
 */
public class MailUtil {

	public static void main(String[] args) {
		sendMail("libra0920@qq.com");
	}
	
	/**
	 * @Title: sendMail 
	 * @Description: 发送邮件
	 * @param @param address 收件人地址
	 * @param @param subject 邮件主题
	 * @param @param content 邮件地址
	 * @param @param ntype   邮件类型
	 * @param @return        设定文件 
	 * @return boolean       返回类型  text/html
	 * @author maoxian
	 * @date 2015年11月30日 下午9:26:08 
	 * @throws
	 */
	public static boolean sendMail(String address){
		
		// 邮件标题
		String subject = "感谢您注册《佳旅联合》旅游服务平台！";
		
		// 邮件内容
		String str20151224 = "尊敬的用户，您好！<br>"
				+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;感谢您注册《佳旅联合》旅游服务平台，我们已经收到您的注册信息，为了保障您开展业务合作的权益，我们将对所有合作公司进行资质审核，时长为1个工作日以内，审核结果将会发送到您的邮箱，请注意查收！"
				+"<br><br>如果您有其他问题，请直接拔打全国统一客服热线：400-004-6161，感谢您的支持并祝您生活愉快！<br>"
				+"<p align='right'><b>北京佳旅联合科技有限公司</b></p>";
		
		// 邮件内容
		String content = "尊敬的用户，您好！\n"
				+"感谢您注册《佳旅联合》旅游服务平台，我们已经收到您的注册信息，为了保障您开展业务合作的权益，我们将对所有合作公司进行资质审核，时长为1个工作日以内，审核结果将会发送到您的邮箱，请注意查收！"
				+"\n如果您有其他问题，请直接拔打全国统一客服热线：400-004-6161，感谢您的支持并祝您生活愉快！\n\n"
				+"北京佳旅联合科技有限公司";
				
		// 邮件类型
		String ntype = "text";
		
		return sendMailUtil(address, subject, content, ntype);
	}
	
	/**
	 * @描述: 发射！
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月24日 下午5:19:12
	 * @param address
	 * @param subject
	 * @param content
	 * @param ntype
	 * @return
	 */
	public static boolean sendMailUtil(String address,String subject, String content,String ntype) {
		// 这个类主要是设置邮件
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setMailServerHost(MailConfig.HOST);
		mailInfo.setMailServerPort(MailConfig.PORT);
		mailInfo.setValidate(true);
		mailInfo.setUserName(MailConfig.USERNAME);
		mailInfo.setPassword(MailConfig.PASSWORD);// 您的邮箱密码
		mailInfo.setFromAddress(MailConfig.FROMADDRESS);
		mailInfo.setToAddress(address);
		mailInfo.setSubject(subject);
		mailInfo.setContent(content);
		// 这个类主要来发送邮件
		SimpleMailSender sms = new SimpleMailSender();
		
		// 判断发送邮件内容样式
		if("text".equals(ntype)){
			sms.sendTextMail(mailInfo);// 发送文体格式
		}else if("html".equals(ntype)){
			sms.sendHtmlMail(mailInfo);
		}
		return true;
	}
}

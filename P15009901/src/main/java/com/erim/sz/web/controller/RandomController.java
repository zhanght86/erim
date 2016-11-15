package com.erim.sz.web.controller;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.common.constant.RandomNumUtil;

/**
 * @ClassName: RandomController
 * @Description: 验证码生成
 * @Author 宁晓强
 * @Date 2015年9月20日 下午4:51:22
 */
@Controller
public class RandomController {
	
	@ResponseBody
	@RequestMapping("/check/code")
	public void init(HttpServletRequest request, HttpServletResponse response) {
		
		RandomNumUtil util = RandomNumUtil.Instance();
		try {
			ServletOutputStream stream = response.getOutputStream();
			ImageIO.write(util.getImage(), "JPEG", stream);
			stream.close();
		} catch (IOException e) {
			System.out.println("验证码生成失败");
		}
	}

}

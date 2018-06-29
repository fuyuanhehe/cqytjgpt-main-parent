package com.ccttic.cqytjgpt.webapi.controller.authImage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ccttic.entity.common.ResponseMsg;
import com.ccttic.util.common.Const;
import com.ccttic.util.common.VerifyCodeUtils;

@Controller
@RequestMapping("/authimage")
public class AuthImageController {

	private Logger logger = Logger.getLogger(getClass());

	@RequestMapping("/img")
	public ResponseMsg<String> img(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ResponseMsg<String> rm = new ResponseMsg<>();
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		try {
			// 生成随机字串
			String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
			// 存入session
			session.setAttribute(Const.PIC_CODE, verifyCode);

			// 生成图片
			int w = 200, h = 80;

			VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
			rm.success("验证码图片生成成功");
			logger.info("图片验证码：" + verifyCode);
			return rm;
		} catch (Exception e) {
			rm.fail("验证码图片生成失败");
			return rm;
		}

	}

}

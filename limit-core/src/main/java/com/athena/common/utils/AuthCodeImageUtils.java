package com.athena.common.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 生成图片验证码
 * @author niebinxiao
 */
public class AuthCodeImageUtils {

	// 图片验证码字库
	private static final String CHECKCODE_CHARACTER_LIB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";

	// 图片验证码随机字体
	private static final String[] FONTTYPES = { "\u5b8b\u4f53", "\u65b0\u5b8b\u4f53", "\u9ed1\u4f53", "\u6977\u4f53", "\u96b6\u4e66" };

	// 验证码session key
	private static String CHECKCODE_KEY = "authenCode";

	/**
	 * 生成图片验证码
	 * @author niebx
	 * @date 2015年2月2日 下午1:57:46
	 * @param response
	 * @param request
	 * @throws IOException
	 */
	public static void getImage(HttpServletResponse response, HttpServletRequest request) throws IOException {
		int width = 130;
		int height = 30;
		int length = CHECKCODE_CHARACTER_LIB.length();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		Random random = new Random();
		g.setColor(getRandColor(random, 188, 235));
		g.fillRect(0, 0, width, height);
		int fontTypesLength = FONTTYPES.length;
		g.setColor(getRandColor(random, 180, 199));
		g.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		for (int i = 0; i < 4; i++) {
			g.drawString("@*@*@*@*@*@*@*", 0, 5 * (i + 2));
		}
		String sRand = "";
		for (int i = 0; i < 4; i++) {
			int start = random.nextInt(length);
			String rand = CHECKCODE_CHARACTER_LIB.substring(start, start + 1);
			sRand += rand;
			g.setColor(getRandColor(random, 10, 150));
			g.setFont(new Font(FONTTYPES[random.nextInt(fontTypesLength)], Font.BOLD, 18 + random.nextInt(6)));
			g.drawString(rand, 24 * i + 10 + random.nextInt(8), 24);
		}
		request.getSession().setAttribute(CHECKCODE_KEY, sRand);
		g.dispose();
		ImageIO.write(image, "JPEG", response.getOutputStream());
	}

	/**
	 * 获取随机颜色
	 * @author niebx
	 * @date 2015年2月4日 下午4:13:34
	 * @param random
	 * @param ff
	 * @param cc
	 * @return
	 */
	private static Color getRandColor(Random random, int ff, int cc) {
		if (ff > 255)
			ff = 255;
		if (cc > 255)
			cc = 255;
		int r = ff + random.nextInt(cc - ff);
		int g = ff + random.nextInt(cc - ff);
		int b = ff + random.nextInt(cc - ff);
		return new Color(r, g, b);
	}
}

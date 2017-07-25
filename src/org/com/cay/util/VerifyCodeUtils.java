package org.com.cay.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class VerifyCodeUtils {
	private String code;
	private byte[] bytes;
	
	public byte[] getBytes() {
		return bytes;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	public void generateCode(int width, int height, int num) {
		// 1������һ���ڴ�ӳ�����(����һ������)
		BufferedImage img = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		// 2����û���
		Graphics g = img.getGraphics();
		// 3��������ɫ
		Random r = new Random();
		g.setColor(Color.BLACK);
		// 4�����������ñ�����ɫ
		g.fillRect(0, 0, width, height);

		// 5���滭,�����֤��
		code = "";
		for (int i = 0; i < num; ++i) {
			int h = (int) ((height - 10) * r.nextDouble() + 10);
			g.setColor(Color.YELLOW);
			String ch = getNumber(1);
			code += ch;
			g.setFont(new Font(null, Font.ITALIC | Font.BOLD, h));
			g.drawString(ch, width / 5 * i, h);
		}

		g.setColor(new Color(0, 0, 0));
		// g.drawString(number, 15, 25);

		// ���������
		for (int i = 0; i < num; ++i)
			g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width),
					r.nextInt(height));

		// �ֽ����������
		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		JPEGImageEncoder encode = JPEGCodec.createJPEGEncoder(bos);

		// ͼƬ�Ķ�������Ϣ������ڴ���
		try {
			encode.encode(img);
		} catch (ImageFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		bytes = bos.toByteArray();
	}

	private String getNumber(int size) {
		// TODO Auto-generated method stub
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ01234567890";
		String rs = "";
		Random r = new Random();
		for (int i = 0; i < size; ++i) {
			rs += str.charAt(r.nextInt(str.length()));
		}
		return rs;
	}
}

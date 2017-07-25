package org.com.cay.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.com.cay.data.Constance;
import org.com.cay.util.VerifyCodeUtils;

public class VerifyCodeAction implements SessionAware {
	private static int WIDTH = 80;
	private static int HEIGHT = 30;
	private static int NUM = 4;

	private Map<String, Object> session;

	private InputStream codeInputStream;
	private String userCode;// �û��������֤��
	private boolean ok = false;//
	
	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String code() {
		VerifyCodeUtils verifyCode = new VerifyCodeUtils();
		verifyCode.generateCode(WIDTH, HEIGHT, NUM);
		String code = verifyCode.getCode();
		//System.out.println(code);
		session.put(Constance.VERIFYCODE_KEY, code);

		codeInputStream = new ByteArrayInputStream(verifyCode.getBytes());
		return "success";
	}

	public InputStream getCodeInputStream() {
		return codeInputStream;
	}

	public void setCodeInputStream(InputStream codeInputStream) {
		this.codeInputStream = codeInputStream;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		session = arg0;
	}

	public String verify() {
		String code = (String) session.get(Constance.VERIFYCODE_KEY);
		if (code != null)
			ok = code.equalsIgnoreCase(userCode);

		return "success";
	}
}

package br.order.common.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class SendSmsUtils {

	private static String Url = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";

	private static String x_uid = "cf_2857029618"; // 用户名

	private static String x_pwd_md5 = "biaoruan"; // 密码

	public static Map<String,Object> SendSms(String mobile, String contents) {

		Map<String, Object> map = new HashMap<String, Object>();

		HttpClient client = new HttpClient();

		PostMethod method = new PostMethod(Url);

		// client.getParams().setContentCharset("GBK");
		client.getParams().setContentCharset("UTF-8");

		method.setRequestHeader("ContentType", "application/x-www-form-urlencoded;charset=UTF-8");

		String content = new String("您的验证码是：" + contents + "。请不要把验证码泄露给其他人。");
		NameValuePair[] data = { // 提交短信
				new NameValuePair("account", x_uid), new NameValuePair("password", x_pwd_md5),
				// new NameValuePair("password",
				// util.StringUtil.MD5Encode("密码")),
				new NameValuePair("mobile", mobile), new NameValuePair("content", content), };

		method.setRequestBody(data);

		try {
			client.executeMethod(method);

			String SubmitResult = method.getResponseBodyAsString();

			// System.out.println(SubmitResult);

			Document doc = DocumentHelper.parseText(SubmitResult);
			Element root = doc.getRootElement();

			String code = root.elementText("code");
			String msg = root.elementText("msg");
			String smsid = root.elementText("smsid");

			System.out.println(code);
			System.out.println(msg);
			System.out.println(smsid);

			if ("2".equals(code)) {
				System.out.println("短信提交成功");
			}
			map.put("code", Integer.parseInt(code));
			return map;
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	// 测试
	public static void main(String[] args) {

		SendSms("18268888717", "8888");
	}

}

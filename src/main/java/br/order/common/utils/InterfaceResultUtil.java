package br.order.common.utils;

import java.util.Date;

import com.alibaba.fastjson.JSONObject;

public class InterfaceResultUtil {

	/**
	 * 操作成功
	 * @return
	 */
	public static JSONObject getReturnMapSuccess(JSONObject param) {
        JSONObject result = new JSONObject();
        result.put("success", true);
		result.put("result", 0);
		result.put("message", "操作成功");
		if (null != param) {
			result.putAll(param);
		}
		System.out.println((new Date())+"返回信息："+result.toJSONString());
        return result;
    }
	
	/**
	 * 请求出错
	 * @return
	 */
	public static JSONObject getReturnMapError(JSONObject param) {
        JSONObject result = new JSONObject();
        result.put("success", false);
		result.put("result", 1);
		result.put("message", "请求出错");
		if (null != param) {
			result.putAll(param);
		}
		System.out.println((new Date())+"返回信息："+result.toJSONString());
        return result;
    }
	
	
	/**
	 * 违法用户
	 * @return
	 */
	public static JSONObject getReturnMapValidUser() {
        JSONObject result = new JSONObject();
        result.put("success", false);
		result.put("result", 2);
		result.put("message", "违法用户或用户名和密码不匹配");
        return result;
    }
	
	/**
	 * 违法Token
	 * @return
	 */
	public static JSONObject getReturnMapValidToken() {
        JSONObject result = new JSONObject();
        result.put("success", false);
		result.put("result", 4);
		result.put("message", "token错误或失效,请重新登录获取");
        return result;
    }
	
	/**
	 * 余额不足
	 * @return
	 */
	public static JSONObject getReturnMapValidAccount() {
        JSONObject result = new JSONObject();
        result.put("success", false);
		result.put("result", 10);
		result.put("message", "账户余额不足");
        return result;
    }
	
	/**
	 * 违法数据
	 * @return
	 */
	public static JSONObject getReturnMapValidValue(JSONObject param) {
		JSONObject result = new JSONObject();
        result.put("success", false);
		result.put("result", 3);
		result.put("message", "违法数据");
		if (null != param) {
			result.putAll(param);
		}
		System.out.println((new Date())+"返回信息："+result.toJSONString());
        return result;
    }
	
	/**
	 * 违法用户名
	 * @return
	 */
	public static JSONObject getReturnMapValidUserName() {
        JSONObject result = new JSONObject();
        result.put("success", false);
		result.put("result", 3);
		result.put("message", "请填写用户名或用户名错误");
        return result;
    }
	
	/**
	 * 该手机号已注册
	 * @return
	 */
	public static JSONObject getReturnMapExistPhoneNum() {
        JSONObject result = new JSONObject();
        result.put("success", false);
		result.put("result", 3);
		result.put("message", "该手机号已注册");
        return result;
    }
	
	/**
	 * 违法密码
	 * @return
	 */
	public static JSONObject getReturnMapValidPassWord() {
        JSONObject result = new JSONObject();
        result.put("success", false);
		result.put("result", 3);
		result.put("message", "请填写密码或密码错误");
        return result;
    }
	
	/**
	 * 违法身份证号
	 * @return
	 */
	public static JSONObject getReturnMapValidIDCard() {
        JSONObject result = new JSONObject();
        result.put("success", false);
		result.put("result", 3);
		result.put("message", "请填写身份证号或身份证号错误");
        return result;
    }
	
	/**
	 * 违法姓名
	 * @return
	 */
	public static JSONObject getReturnMapValidName() {
        JSONObject result = new JSONObject();
        result.put("success", false);
		result.put("result", 3);
		result.put("message", "请填写姓名或姓名错误");
        return result;
    }
	
	/**
	 * 违法手机号码
	 * @return
	 */
	public static JSONObject getReturnMapValidPhoneNum() {
        JSONObject result = new JSONObject();
        result.put("success", false);
		result.put("result", 3);
		result.put("message", "请填写手机号码或手机号码错误");
        return result;
    }
	
	/**
	 * 违法邮箱地址
	 * @return
	 */
	public static JSONObject getReturnMapValidEmail() {
        JSONObject result = new JSONObject();
        result.put("success", false);
		result.put("result", 3);
		result.put("message", "请填写邮箱地址或邮箱地址错误");
        return result;
    }
	
	/**
	 * 违法电话号码列表
	 * @return
	 */
	public static JSONObject getReturnMapValidPhoneList() {
        JSONObject result = new JSONObject();
        result.put("success", false);
		result.put("result", 3);
		result.put("message", "请填写电话号码列表或电话号码列表错误");
        return result;
    }
	
	/**
	 * 违法查询ID
	 * @return
	 */
	public static JSONObject getReturnMapValidQueryID() {
        JSONObject result = new JSONObject();
        result.put("success", false);
		result.put("result", 3);
		result.put("message", "请填写查询ID标识或查询ID标识错误");
        return result;
    }
	
	/**
	 * 拒绝访问
	 * @return
	 */
	public static JSONObject getReturnMapRefuseRequest() {
        JSONObject result = new JSONObject();
        result.put("success", false);
		result.put("result", 99);
		result.put("message", "拒绝访问");
        return result;
    }
	
	/**
	 * 跳转到登陆
	 * @return
	 */
	public static JSONObject toLogin() {
        JSONObject result = new JSONObject();
        result.put("success", false);
		result.put("result", 100);
		result.put("message", "请重新登陆");
        return result;
    }
	
	
}

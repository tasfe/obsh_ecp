package com.xwtech.xwecp.test;

import java.util.Properties;

import org.apache.log4j.Logger;

import com.xwtech.xwecp.msg.InvocationContext;
import com.xwtech.xwecp.service.logic.client.LIInvocationContext;
import com.xwtech.xwecp.service.logic.client.XWECPLIClient;
import com.xwtech.xwecp.service.logic.client_impl.common.IQueryRecLogService;
import com.xwtech.xwecp.service.logic.client_impl.common.impl.QueryRecLogServiceClientImpl;
import com.xwtech.xwecp.service.logic.pojo.QRY050057Result;


public class QRY050057Test
{
	private static final Logger logger = Logger.getLogger(QRY050057Test.class);
	
	public static void main(String[] args) throws Exception
	{
		//初始化ecp客户端片段
		Properties props = new Properties();
		props.put("client.channel", "obsh_channel");
		//props.put("platform.url", "http://127.0.0.1:8080/obsh_ecp/xwecp.do");
		props.put("platform.url", "http://10.32.65.223/obsh_ecp/xwecp.do");
		//props.put("platform.url", "http://10.32.229.81:10008/sms_ecp/xwecp.do");
		//props.put("platform.url", "http://10.32.122.166:10009/js_ecp/xwecp.do");
		//props.put("platform.url", "http://10.32.65.238:8081/sms_ecp/xwecp.do");
		//props.put("platform.url", "http://10.32.229.86:8080/openapi_ecp/xwecp.do");
		props.put("platform.user", "jhr");
		props.put("platform.password", "jhr");
		
		XWECPLIClient client = XWECPLIClient.createInstance(props);
		//逻辑接口调用片段
		LIInvocationContext lic = LIInvocationContext.getContext();
		lic.setBizCode("biz_code_19234");
		lic.setOpType("开通/关闭/查询/变更");
		lic.setUserBrand("动感地带");
		lic.setUserCity(""); 
		lic.setUserMobile("14751606885");
		InvocationContext ic = new InvocationContext();
		ic.addContextParameter("login_msisdn", "18352031008");
		ic.addContextParameter("route_type", "1");
		ic.addContextParameter("route_value", "17");
		ic.addContextParameter("ddr_city", "17");
		
		ic.addContextParameter("user_id", "");  //2056200011182291
		
		lic.setContextParameter(ic);
		try{
			IQueryRecLogService co = new QueryRecLogServiceClientImpl();
		//动感地带 13401312424  brand_id：11 city_id：17 user_id：1738200005062065
		//全球通 13913032424 user_id：1419200008195160
			QRY050057Result re = co.queryRecLog("13913814503", 0);
		
		logger.info(" ====== 开始返回参数 ======");
		if (re != null)
		{
			logger.info(" ====== getResultCode ======" + re.getResultCode());
			logger.info(" ====== getErrorCode ======" + re.getErrorCode());
			logger.info(" ====== getErrorMessage ======" + re.getErrorMessage());
			logger.info(" ====== 111 ======" + re.getRecLogList().size());
//			logger.info(" ====== 222 ======" + re.getResType());
//			logger.info(" ====== 333 ======" + re.getVcStatus());
//			logger.info(" ====== 444 ======" + re.getUsableMoney());
		
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

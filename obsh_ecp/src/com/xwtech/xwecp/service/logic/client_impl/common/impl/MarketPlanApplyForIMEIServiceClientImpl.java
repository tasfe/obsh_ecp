package com.xwtech.xwecp.service.logic.client_impl.common.impl;

import com.xwtech.xwecp.service.client.BaseClientServiceImpl;
import com.xwtech.xwecp.service.logic.client_impl.common.LIException;
import com.xwtech.xwecp.msg.RequestData;
import com.xwtech.xwecp.msg.RequestParameter;
import com.xwtech.xwecp.msg.ResponseData;
import com.xwtech.xwecp.msg.ServiceMessage;
import com.xwtech.xwecp.service.BaseServiceInvocationResult;
import com.xwtech.xwecp.service.logic.client.LIInvocationContext;
import com.xwtech.xwecp.service.logic.client.XWECPLIClient;
import com.xwtech.xwecp.service.logic.client_impl.common.IMarketPlanApplyForIMEIService;
import java.util.List;
import com.xwtech.xwecp.service.logic.pojo.UserMarketBInfo;
import com.xwtech.xwecp.service.logic.pojo.DEL040104Result;

public class MarketPlanApplyForIMEIServiceClientImpl extends BaseClientServiceImpl implements IMarketPlanApplyForIMEIService
{
	public DEL040104Result marketPlanApplyForIMEI(String servicesType, String userId, String effectFlag, String bossMmsPackId, int smsFlag, int status, int idType, int receiveType, String gradeAmount, String busiPackId, List<UserMarketBInfo> userMarketBaseInfo, String rewardList, String imei,String type) throws LIException
	{
		long __beginTime = System.currentTimeMillis();
		String __cmd = "DEL040104";
		XWECPLIClient __client = XWECPLIClient.getInstance();
		ServiceMessage __msg = __client.getMsgHelper().createRequestMessage(__cmd);
		RequestData __requestData = new RequestData();
		RequestParameter __param_servicesType = new RequestParameter("servicesType", servicesType);
		__requestData.getParams().add(__param_servicesType);
		RequestParameter __param_userId = new RequestParameter("userId", userId);
		__requestData.getParams().add(__param_userId);
		RequestParameter __param_effectFlag = new RequestParameter("effectFlag", effectFlag);
		__requestData.getParams().add(__param_effectFlag);
		RequestParameter __param_bossMmsPackId = new RequestParameter("bossMmsPackId", bossMmsPackId);
		__requestData.getParams().add(__param_bossMmsPackId);
		RequestParameter __param_smsFlag = new RequestParameter("smsFlag", smsFlag);
		__requestData.getParams().add(__param_smsFlag);
		RequestParameter __param_status = new RequestParameter("status", status);
		__requestData.getParams().add(__param_status);
		RequestParameter __param_idType = new RequestParameter("idType", idType);
		__requestData.getParams().add(__param_idType);
		RequestParameter __param_receiveType = new RequestParameter("receiveType", receiveType);
		__requestData.getParams().add(__param_receiveType);
		RequestParameter __param_gradeAmount = new RequestParameter("gradeAmount", gradeAmount);
		__requestData.getParams().add(__param_gradeAmount);
		RequestParameter __param_busiPackId = new RequestParameter("busiPackId", busiPackId);
		__requestData.getParams().add(__param_busiPackId);
		RequestParameter __param_userMarketBaseInfo = new RequestParameter("userMarketBaseInfo", userMarketBaseInfo);
		__requestData.getParams().add(__param_userMarketBaseInfo);
		RequestParameter __param_rewardList = new RequestParameter("rewardList", rewardList);
		__requestData.getParams().add(__param_rewardList);
		RequestParameter __param_imei = new RequestParameter("imei", imei);
		__requestData.getParams().add(__param_imei);
		RequestParameter __param_type = new RequestParameter("type", type);
		__requestData.getParams().add(__param_type);
		__msg.setData(__requestData);
		__msg.getHead().setUser(LIInvocationContext.USER);
		__msg.getHead().setPwd(LIInvocationContext.PWD);
		LIInvocationContext __ic = LIInvocationContext.getContext();
		if(__ic != null)
		{
			__msg.getHead().setOpType(__ic.getOpType());
			__msg.getHead().setUserMobile(__ic.getUserMobile());
			__msg.getHead().setUserCity(__ic.getUserCity());
			__msg.getHead().setBizCode(__ic.getBizCode());
			__msg.getHead().setUserBrand(__ic.getUserBrand());
			__msg.getHead().setOperId(__ic.getOperId());
			((RequestData)(__msg.getData())).setContext(__ic.getContextParameter());
		}
		String __requestXML = __msg.toString();
		DEL040104Result __result = null;
		String __responseXML = "";
		Throwable __errorStack = null;
		ServiceMessage __response = null;
		try
		{
			__responseXML = __client.getPlatformConnection().send(__requestXML);
			__response = ServiceMessage.fromXML(__responseXML);
			BaseServiceInvocationResult __ret = ((ResponseData)(__response.getData())).getServiceResult();
			if(__ret instanceof DEL040104Result)
			{
				__result = (DEL040104Result)__ret;
			}
			else
			{
			__result = new DEL040104Result();
			__result.setResultCode(__ret.getResultCode());
			__result.setErrorCode(__ret.getErrorCode());
			__result.setErrorMessage(__ret.getErrorMessage());
			}
		}
		catch(Exception __e)
		{
			__errorStack = __e;
			throw new LIException(__e);
		}
		finally
		{
			long __endTime = System.currentTimeMillis();
			__client.log(__cmd, __client.getPlatformConnection().getRemoteURL(), __requestXML, __responseXML, __msg, __response, __beginTime, __endTime, __errorStack);
		}
		return __result;
	}

}
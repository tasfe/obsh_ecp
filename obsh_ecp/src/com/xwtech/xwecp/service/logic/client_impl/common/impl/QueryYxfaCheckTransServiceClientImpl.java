package com.xwtech.xwecp.service.logic.client_impl.common.impl;

import com.xwtech.xwecp.service.client.BaseClientServiceImpl;
import com.xwtech.xwecp.service.logic.LIException;
import com.xwtech.xwecp.msg.RequestData;
import com.xwtech.xwecp.msg.RequestParameter;
import com.xwtech.xwecp.msg.ResponseData;
import com.xwtech.xwecp.msg.ServiceMessage;
import com.xwtech.xwecp.service.BaseServiceInvocationResult;
import com.xwtech.xwecp.service.logic.client.LIInvocationContext;
import com.xwtech.xwecp.service.logic.client.XWECPLIClient;
import com.xwtech.xwecp.service.logic.client_impl.common.IQueryYxfaCheckTransService;
import java.util.List;
import com.xwtech.xwecp.service.logic.pojo.YxfaIdInfo;
import com.xwtech.xwecp.service.logic.pojo.QRY090005Result;

public class QueryYxfaCheckTransServiceClientImpl extends BaseClientServiceImpl implements IQueryYxfaCheckTransService
{
	public QRY090005Result queryYxfaCheckTrans(String ddr_city, String usermarketingbaseinfo_user_id, List<YxfaIdInfo> yxfaIdInfo, String bossmarket_rec_type) throws LIException
	{
		long __beginTime = System.currentTimeMillis();
		String __cmd = "QRY090005";
		XWECPLIClient __client = XWECPLIClient.getInstance();
		ServiceMessage __msg = __client.getMsgHelper().createRequestMessage(__cmd);
		RequestData __requestData = new RequestData();
		RequestParameter __param_ddr_city = new RequestParameter("ddr_city", ddr_city);
		__requestData.getParams().add(__param_ddr_city);
		RequestParameter __param_usermarketingbaseinfo_user_id = new RequestParameter("usermarketingbaseinfo_user_id", usermarketingbaseinfo_user_id);
		__requestData.getParams().add(__param_usermarketingbaseinfo_user_id);
		RequestParameter __param_yxfaIdInfo = new RequestParameter("yxfaIdInfo", yxfaIdInfo);
		__requestData.getParams().add(__param_yxfaIdInfo);
		RequestParameter __param_bossmarket_rec_type = new RequestParameter("bossmarket_rec_type", bossmarket_rec_type);
		__requestData.getParams().add(__param_bossmarket_rec_type);
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
		QRY090005Result __result = null;
		String __responseXML = "";
		Throwable __errorStack = null;
		ServiceMessage __response = null;
		try
		{
			__responseXML = __client.getPlatformConnection().send(__requestXML);
			__response = ServiceMessage.fromXML(__responseXML);
			BaseServiceInvocationResult __ret = ((ResponseData)(__response.getData())).getServiceResult();
			if(__ret instanceof QRY090005Result)
			{
				__result = (QRY090005Result)__ret;
			}
			else
			{
				__result = new QRY090005Result();
				__result.setResultCode(__ret.getResultCode());
				__result.setErrorCode(__ret.getErrorCode());
				__result.setErrorMessage(__ret.getErrorMessage());
			}
		}
		catch(Exception __e){
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
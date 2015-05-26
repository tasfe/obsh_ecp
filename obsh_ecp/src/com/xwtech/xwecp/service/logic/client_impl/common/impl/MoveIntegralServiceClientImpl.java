package com.xwtech.xwecp.service.logic.client_impl.common.impl;

import com.xwtech.xwecp.msg.RequestData;
import com.xwtech.xwecp.msg.RequestParameter;
import com.xwtech.xwecp.msg.ResponseData;
import com.xwtech.xwecp.msg.ServiceMessage;
import com.xwtech.xwecp.service.BaseServiceInvocationResult;
import com.xwtech.xwecp.service.client.BaseClientServiceImpl;
import com.xwtech.xwecp.service.logic.LIException;
import com.xwtech.xwecp.service.logic.client.LIInvocationContext;
import com.xwtech.xwecp.service.logic.client.XWECPLIClient;
import com.xwtech.xwecp.service.logic.client_impl.common.IMoveIntegralService;
import com.xwtech.xwecp.service.logic.pojo.DEL010025Result;

/**
 * 积分转增接口
 * @author YangXQ
 * 2015-1-7
 */
public class MoveIntegralServiceClientImpl extends BaseClientServiceImpl implements IMoveIntegralService
{
	public DEL010025Result moveIntegral(int chgtype,String fromservnumber,String fromsubsid,
			int fromprodtype,String toservnumber,String tosubsid,int ftoprodtype,String intchgrsn,long integralvalue)throws LIException
	{
		long __beginTime = System.currentTimeMillis();
		String __cmd = "DEL010025";
		XWECPLIClient __client = XWECPLIClient.getInstance();
		ServiceMessage __msg = __client.getMsgHelper().createRequestMessage(__cmd);
		RequestData __requestData = new RequestData();
		RequestParameter __param_chgtype = new RequestParameter("chgtype", chgtype);
		__requestData.getParams().add(__param_chgtype);
		RequestParameter __param_fromservnumber = new RequestParameter("fromservnumber", fromservnumber);
		__requestData.getParams().add(__param_fromservnumber);
		RequestParameter __param_fromsubsid = new RequestParameter("fromsubsid", fromsubsid);
		__requestData.getParams().add(__param_fromsubsid);
		RequestParameter __param_fromprodtype = new RequestParameter("fromprodtype", fromprodtype);
		__requestData.getParams().add(__param_fromprodtype);
		RequestParameter __param_toservnumber = new RequestParameter("toservnumber", toservnumber);
		__requestData.getParams().add(__param_toservnumber);
		RequestParameter __param_tosubsid = new RequestParameter("tosubsid", tosubsid);
		__requestData.getParams().add(__param_tosubsid);
		RequestParameter __param_ftoprodtype = new RequestParameter("ftoprodtype", ftoprodtype);
		__requestData.getParams().add(__param_ftoprodtype);
		RequestParameter __param_intchgrsn = new RequestParameter("intchgrsn", intchgrsn);
		__requestData.getParams().add(__param_intchgrsn);
		RequestParameter __param_integralvalue = new RequestParameter("integralvalue", integralvalue);
		__requestData.getParams().add(__param_integralvalue);
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
		DEL010025Result __result = null;
		String __responseXML = "";
		Throwable __errorStack = null;
		ServiceMessage __response = null;
		try
		{
			__responseXML = __client.getPlatformConnection().send(__requestXML);
			__response = ServiceMessage.fromXML(__responseXML);
			BaseServiceInvocationResult __ret = ((ResponseData)(__response.getData())).getServiceResult();
			if(__ret instanceof DEL010025Result)
			{
				__result = (DEL010025Result)__ret;
			}
			else
			{
				__result = new DEL010025Result();
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
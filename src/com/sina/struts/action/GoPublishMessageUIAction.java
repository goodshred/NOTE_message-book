/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.sina.struts.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.sina.domain.Message;
import com.sina.domain.Users;
import com.sina.service.imp.MessageServiceImp;
import com.sina.service.imp.UsersServiceImp;
import com.sina.service.inter.MessageServiceInter;
import com.sina.service.inter.UsersServiceInter;
import com.sina.struts.form.MessageForm;

/** 
 * MyEclipse Struts
 * Creation date: 05-31-2011
 * 
 * XDoclet definition:
 * @struts.action parameter="flag"
 */
public class GoPublishMessageUIAction extends DispatchAction {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward goPublishMessageUi(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return mapping.findForward("goPublishMessageUi");
	}
	
	public ActionForward publishMessage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//��ȡ����
		MessageForm messageForm=(MessageForm)form;
		//����Message����
		Message message=new Message();
		message.setContent(messageForm.getContent());
		UsersServiceInter usersServiceInter=new UsersServiceImp();
		message.setGetter(usersServiceInter.getUserByName(messageForm.getGetter()));//��Ҫһ��������ͨ���û���������ȡ�ö���
		message.setMesTime(new Date());
		message.setSender((Users)request.getSession().getAttribute("userinfo"));
		
		//�������message����
		//MessageServiceInter messageServiceInter=new MessageServiceImp();
		//messageServiceInter.save(message);
		//�������message����
		usersServiceInter.save(message);
		//������ʹ����ȫ����ת
		return mapping.findForward("ok");
	}
}
package com.caoO.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.supercaoO.bean.Manager;

/**
 * Login interceptor
 * @author caoO
 *
 */
public class LoginInterceptor extends MethodFilterInterceptor {
	private static final long serialVersionUID = 3717175811212995580L;

	protected String doIntercept(ActionInvocation invocation) throws Exception {
		Manager manager = (Manager) ServletActionContext.getRequest().getSession().getAttribute("manager");
		if (manager == null) {
			return "login";
		}
		return invocation.invoke();
	}
}

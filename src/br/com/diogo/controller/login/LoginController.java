package br.com.diogo.controller.login;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.diogo.controller.filter.NavigationBean;

@ManagedBean
@SessionScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = -2005678281934517514L;

	// Simple user database :)
	private static final String[] users = { "admin:admin", "kate:123456" };

	private String username;
	private String password;

	private boolean loggedIn;

	@ManagedProperty(value = "#{navigationBean}")
	private NavigationBean navigationBean;

	public String doLogin() {

		for (String user : users) {
			String dbUsername = user.split(":")[0];
			String dbPassword = user.split(":")[1];

			// Successful login
			if (dbUsername.equals(username) && dbPassword.equals(password)) {
				loggedIn = true;
				return navigationBean.redirectToWelcome();
			}
		}

		// Set login ERROR
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Usuário ou Senha Invalidos !!!"));

		// To to login page
		return navigationBean.toLogin();

	}

	public String doLogout() {

		loggedIn = false;

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Logout efetuado com sucesso !!!"));
		return navigationBean.redirectToLogin();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public void setNavigationBean(NavigationBean navigationBean) {
		this.navigationBean = navigationBean;
	}

}

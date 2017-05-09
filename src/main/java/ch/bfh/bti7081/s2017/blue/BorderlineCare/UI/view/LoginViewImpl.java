package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view;

import java.util.ArrayList;
import java.util.List;


import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.LoginViewPresenter;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.LoginViewButtonClickListener;

public class LoginViewImpl extends CustomComponent {

	// Components
	private List<LoginViewButtonClickListener> listeners = new ArrayList<LoginViewButtonClickListener>();
	private Button buttonLogin;
	private Button buttonSignUp;
	private TextField loginName;
	public TextField loginPassword;

	public LoginViewImpl() {

		VerticalLayout vLayout = new VerticalLayout();
		vLayout.setSizeFull();
		setCompositionRoot(vLayout);

		// Textfields
		loginName = new TextField();
		loginName.setCaption("Username");

		loginPassword = new TextField();
		loginPassword.setCaption("Password");

		// Buttons
		buttonLogin = new Button("Login");
		buttonLogin.addClickListener(e ->{
			for(LoginViewButtonClickListener listener : listeners){
				listener.loginButtonClick();
			}
		});

		buttonSignUp = new Button("Sign Up");
		buttonSignUp.addClickListener(e ->{
			for(LoginViewButtonClickListener listener : listeners){
				listener.signUpButtonClick();
			}
		});

		// Add all components
		vLayout.addComponent(loginName);
		vLayout.addComponent(loginPassword);
		vLayout.addComponent(buttonLogin);
		vLayout.addComponent(buttonSignUp);
		vLayout.setComponentAlignment(buttonLogin, Alignment.MIDDLE_CENTER);
		vLayout.setComponentAlignment(buttonSignUp, Alignment.MIDDLE_CENTER);
		vLayout.setComponentAlignment(loginName, Alignment.MIDDLE_CENTER);
		vLayout.setComponentAlignment(loginPassword, Alignment.MIDDLE_CENTER);
		loginName.focus();

	}

	public void addListener(LoginViewButtonClickListener loginClickListener) {
		listeners.add(loginClickListener);
	}
}

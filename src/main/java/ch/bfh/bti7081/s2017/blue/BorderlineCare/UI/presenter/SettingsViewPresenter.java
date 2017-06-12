package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter;

import com.vaadin.data.Binder;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.Contact;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.ContactModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.SettingsViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.SettingsClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.SettingsViewImpl;

/**
 * @author André
 *
 */
public class SettingsViewPresenter implements SettingsClickListener {

	private SettingsViewImpl settingsView;
	private SettingsViewModel settingsModel;
	private Navigator navigator;
	private UI ui = UI.getCurrent();

	public SettingsViewPresenter(SettingsViewModel settingsModel, SettingsViewImpl settingsViewImp,
			ContactModel contacts, Navigator navigator) {

		this.settingsView = settingsViewImp;
		this.settingsModel = settingsModel;
		this.navigator = navigator;

		initTextFields(settingsView);

		loadContacts(settingsView.geteContact1Menu());
		loadContacts(settingsView.geteContact2Menu());
		loadContacts(settingsView.geteContact3Menu());

		settingsView.addClickListener(this);

	}

	/**
	 * load contatcs on the dropdown menu Emergency contacs
	 */
	public void loadContacts(ComboBox<Contact> cb) {
		cb.setItems(settingsModel.getDbConnector().getLoginAccount().getContacts());
		cb.setItemCaptionGenerator(Contact::getName);
	}

	/**
	 * initialize settings text fields with LoginAccount information
	 */
	public void initTextFields(SettingsViewImpl View) {

		View.getEmailTextField().setValue(settingsModel.getDbConnector().getLoginAccount().getEmail());
		View.getPasswordTextField().setValue(settingsModel.getDbConnector().getLoginAccount().getPassword());
		View.getFirstNameTextField().setValue(settingsModel.getDbConnector().getLoginAccount().getFirstName());
		View.getLastNameTextField().setValue(settingsModel.getDbConnector().getLoginAccount().getLastName());
		View.getStreetTextField().setValue(settingsModel.getDbConnector().getLoginAccount().getStreet());
		View.getCityTextField().setValue(settingsModel.getDbConnector().getLoginAccount().getCity());
		View.getZipCodeTextField().setValue(settingsModel.getDbConnector().getLoginAccount().getZipCode());

	}

	/**
	 * Add function to the Button Account Edit
	 * 
	 * @param btn
	 */
	public void AccEditButtonClick(Button btn) {

			if (btn.getCaption().equals("Edit")) {
				btn.setCaption("Save");
				settingsView.setUserInfoFieldsState(true);

			} else {
				btn.setCaption("Edit");
				settingsModel.saveUserSettignsToDB(
						settingsView.getEmailTextField().getValue(),
						settingsView.getFirstNameTextField().getValue(),
						settingsView.getLastNameTextField().getValue(),
						settingsView.getStreetTextField().getValue(), 
						settingsView.getZipCodeTextField().getValue(),
						settingsView.getCityTextField().getValue(), 
						settingsView.getPasswordTextField().getValue()
						,settingsView.geteContact1Menu().getValue(),
						settingsView.geteContact2Menu().getValue(), 
						settingsView.geteContact3Menu().getValue()
						);						
				settingsView.setUserInfoFieldsState(false);
			}
	}

	/**
	 * Add function to the Button Econtacts Edit
	 * 
	 * @param btn
	 */
	@Override
	public void EContactEditButtonClick(Button btn) {
		if (btn.getCaption().equals("Edit")) {
			btn.setCaption("Save");
			settingsView.setContactMenusState(true);

		} else {
			btn.setCaption("Edit");
			settingsView.setContactMenusState(false);

		}

	}

	/**
	 * Add function to the Button Logout
	 * 
	 * @param btn
	 */
	
	public void logOutButtonClick() {
		ui.getSession().setAttribute("user", null);
		navigator.navigateTo("LoginView");

	}

}

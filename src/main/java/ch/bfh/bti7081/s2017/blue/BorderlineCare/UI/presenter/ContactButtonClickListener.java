package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter;

import com.vaadin.ui.PopupView;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.Contact;

public interface ContactButtonClickListener {
	public Contact deleteButtonClick(PopupView popuu, Contact toDelete);
	public void saveButtonClick(String stringInput, int integerInput);
	public void cancelButtonClick();
	public void deleteContact();

}

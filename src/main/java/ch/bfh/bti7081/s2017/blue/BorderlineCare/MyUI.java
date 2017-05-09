package ch.bfh.bti7081.s2017.blue.BorderlineCare;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.ContactModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.DiaryViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.EmergencyViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.MainViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.ContactViewPresenter;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.DiaryViewPresenter;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.EmergencyViewPresenter;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.MainViewPresenter;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.ContactViewImpl;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.DiaryViewImpl;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.NavigationViewImpl;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.mainView.DiaryDashViewImpl;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.mainView.EmergencyViewImpl;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.mainView.ExerciseDashViewImpl;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.mainView.MainViewImpl;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	//Main View
    	ExerciseDashViewImpl exerciseDashViewImpl = new ExerciseDashViewImpl();
    	DiaryDashViewImpl diaryDashViewImpl = new DiaryDashViewImpl();
        EmergencyViewImpl emergencyViewImpl = new EmergencyViewImpl();
    	EmergencyViewModel emergencyViewModel = new EmergencyViewModel();
    	EmergencyViewPresenter emergencyViewPresenter = new EmergencyViewPresenter(emergencyViewImpl,emergencyViewModel);
    	MainViewImpl mainView = new MainViewImpl(exerciseDashViewImpl,diaryDashViewImpl,emergencyViewImpl);
    	MainViewModel model = new MainViewModel();
    	MainViewPresenter presenter = new MainViewPresenter(model, mainView);
    	
    	//Contact View
    	ContactViewImpl contactViewImpl = new ContactViewImpl();
    	ContactModel contactModel = new ContactModel();
    	ContactViewPresenter contactViewPresenter = new ContactViewPresenter(contactModel, contactViewImpl);
    	
    	
    	//Diary View
    	DiaryViewModel diaryViewModel = new DiaryViewModel();
    	DiaryViewImpl diaryViewImpl = new DiaryViewImpl();
    	DiaryViewPresenter diaryViewPresenter = new DiaryViewPresenter(diaryViewModel, diaryViewImpl);
    	
    	//Navigation View 
    	NavigationViewImpl view = new NavigationViewImpl(mainView,contactViewImpl,diaryViewImpl);
    	
    	
//    	//Login View
//    	LoginViewModel loginViewModel = new LoginViewModel();
//    	LoginViewImpl loginViewImpl = new LoginViewImpl();
//    	LoginViewPresenter loginViewPresenter = new LoginViewPresenter(loginViewModel, loginViewImpl);
//    	
//        VerticalLayout vLayout = new VerticalLayout();
//        vLayout.addComponent(loginViewImpl);
//        vLayout.setSizeFull();
//        vLayout.setComponentAlignment(loginViewImpl, Alignment.MIDDLE_CENTER);
//        this.setContent(vLayout);
        
    	setContent(view);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}

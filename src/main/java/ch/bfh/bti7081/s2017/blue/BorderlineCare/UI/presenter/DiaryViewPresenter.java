package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.server.Page;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.Contact;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.DiaryEntry;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.DiaryViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.ButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.DiaryButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.DiaryViewImpl;

public class DiaryViewPresenter implements DiaryButtonClickListener {
	

	private DiaryViewModel diaryViewModel;
	private DiaryViewImpl diaryViewImpl;
	private List<DiaryEntry> diaryEntry;



	public DiaryViewPresenter(DiaryViewModel model, DiaryViewImpl view){
		this.diaryViewModel = model;
		this.diaryViewImpl = view;
		diaryEntry = diaryViewModel.getDiaryEntry();

		diaryViewImpl.initializeDiaryEntry(diaryViewModel.getDiaryEntry());
		diaryViewImpl.addDiaryButtonClickListener(this);
		diaryViewImpl.initAddDiaryEntry();
}

	public List<DiaryEntry> getDiaryEntry() {
		return this.diaryEntry;
	}
	
	public void addButtonClick(LocalDate dateInput, String radioInput, String titleInput, String diaryInput) {
		
		diaryEntry.add(new DiaryEntry(dateInput, radioInput, titleInput, diaryInput));
		diaryViewImpl.initializeDiaryEntry(diaryViewModel.getDiaryEntry()); //Inhalt wird ins Grid geschrieben
		
	}


	@Override
	public void smileyGoodButtonClick() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void smileyMediumButtonClick() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void smileyBadButtonClick() {
		// TODO Auto-generated method stub
		
	}
}

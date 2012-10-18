package com.injoit.wordguessing;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class GuessLine extends LinearLayout {

	private Context context;

	private int currentSymbolIndex = 0;
	private String word;
	private boolean isAllowToGetWholeWord = false;

	private List<GuessCharObject> list = new ArrayList<GuessCharObject>();

	public GuessLine(Context context) {
		super(context);
		this.context = context;
	}

	public GuessLine(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
	}

	public void setWord(String word) {
		this.word = word;
		List<GuessCharObject> l = new ArrayList<GuessCharObject>();
		for (int i = 0; i < word.length(); i++) {
			GuessCharObject tmp = new GuessCharObject();
			String symbol = word.charAt(i) + "";
			System.out.println("symbol: " + symbol);
			if (symbol.equals(" ")) {
				tmp.setId(-1);
				tmp.setSpace(true);
			} else {
				tmp.setSpace(false);
				tmp.setCurrentCharSymbol(null);
			}
			System.out.println("tmp: " + tmp);
			l.add(tmp);
		}
		setGuessCharObjectList(l);
	}

	private void setGuessCharObjectList(List<GuessCharObject> guessCharList) {
		list = new ArrayList<GuessCharObject>(guessCharList);
		updateImage();
	}

	public void clearGuessCharElementList() {
		list.clear();
		updateImage();
	}

	private void updateImage() {
		this.removeAllViews();
		for (int i = 0; i < list.size(); i++) {
			GuessCharObject gco = list.get(i);
			GuessCharElement tmp = new GuessCharElement(context);
			tmp.setCharObject(gco);
			addView(tmp);
		}
		isAllowToGetWholeWord();
	}

	public void setCurrentSymbol(String symbol) {
		if (!(currentSymbolIndex < list.size()))
			return;
		GuessCharObject gco = list.get(currentSymbolIndex);
		if (!gco.isSpace()) {
			gco.setCurrentCharSymbol(symbol);
			list.set(currentSymbolIndex, gco);
			currentSymbolIndex++;
		} else {
			currentSymbolIndex++;
			setCurrentSymbol(symbol);
		}
		updateImage();
	}

	public void removeLastElement() {
		if (currentSymbolIndex == 0)
			return;
		currentSymbolIndex--;
		GuessCharObject gco = list.get(currentSymbolIndex);

//		System.out.println("gco isspace: " + gco.isSpace());

		if (gco.isSpace()) {
			currentSymbolIndex--;
		}

		gco = list.get(currentSymbolIndex);
		gco.setCurrentCharSymbol(null);
		list.set(currentSymbolIndex, gco);
		updateImage();
	}

	public boolean isAllowToGetWholeWord() {
		System.out.println(currentSymbolIndex + " " + list.size());
		if (currentSymbolIndex == list.size())
			isAllowToGetWholeWord = true;
		else
			isAllowToGetWholeWord = false;
		return isAllowToGetWholeWord;
	}

	public String getComplitedWord() {
		String toReturn = "";
		if (isAllowToGetWholeWord) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).isSpace())
					toReturn += " ";
				else
					toReturn += list.get(i).getCurrentCharSymbol();
			}
		}
		return toReturn;
	}

	public String getWord() {
		return word;
	}

}

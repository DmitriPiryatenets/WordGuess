package com.injoit.wordguessing;

public class GuessCharObject {

	private int id;
	private String currentCharSymbol;
	private boolean is_space;

	public GuessCharObject() { }

	public GuessCharObject(int id, String currentCharSymbol, boolean is_space) {
		super();
		this.id = id;
		this.currentCharSymbol = currentCharSymbol;
		this.is_space = is_space;
	}

	public String getCurrentCharSymbol() {
		return currentCharSymbol;
	}

	public void setCurrentCharSymbol(String currentCharSymbol) {
		this.currentCharSymbol = currentCharSymbol;
	}

	public boolean isSpace() {
		return is_space;
	}

	public void setSpace(boolean is_space) {
		this.is_space = is_space;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GuessCharObject other = (GuessCharObject) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GuessCharObject [id=" + id + ", currentCharSymbol="
				+ currentCharSymbol + ", is_space=" + is_space + "]";
	}

}

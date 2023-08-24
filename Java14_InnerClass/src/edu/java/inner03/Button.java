package edu.java.inner03;

public class Button {
	// public static 내부 인터페이스
	public interface OnClickListener {
		void onClick(); //public abstract 생략.
	}
	
	
	// field
	private String btnName;
	private OnClickListener listener;
	
	// constructor
	public Button(String btnName) {
		this.btnName = btnName;
	}
	
	// method
	public void setonClickListener(OnClickListener l) {
		this.listener = l;
	}
	
	public void click() {
		System.out.println(btnName + " 버튼:");
		listener.onClick();
	}
	
	
	
	
	
}

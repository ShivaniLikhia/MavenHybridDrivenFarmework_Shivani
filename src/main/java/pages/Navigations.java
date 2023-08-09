package pages;

import base.ControlActions;

public class Navigations extends ControlActions {

	public Navigations navigateTo(String path) {
		String[] pathArr = path.split("->");
		for(int index=0;index<pathArr.length;index++) {
			if(index==0 || index==pathArr.length-1) {
				getElement("XPATH","//a[contains(text(),'"+pathArr[index]+"')]",true);

			}		
			else {
				mouseHover("XPATH","//a[contains(text(),'"+pathArr[index]+"')]");
			}
		}
		return this;
	}
}

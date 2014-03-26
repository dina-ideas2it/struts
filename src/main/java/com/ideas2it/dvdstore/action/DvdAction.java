/**
 * 
 */
package com.ideas2it.dvdstore.action;

import com.ideas2it.dvdstore.model.Dvd;
import com.ideas2it.dvdstore.service.DvdService;
import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;

/**
 * @author dinakaran
 * 
 */
public class DvdAction extends ActionSupport {
	Dvd dvd;
	HttpServletRequest request;

	public String execute() throws Exception {
		DvdService dvdService = new DvdService();
		Dvd DvdReturn = dvdService.search(dvd);
		if(DvdReturn.getTitle() == null){
			DvdReturn = dvdService.create(dvd);
			System.out.println("===>creation");
		}
		else{
			DvdReturn = dvdService.update(dvd);
			System.out.println("===>updation");
		}
		if (DvdReturn.getTitle() != null){
			System.out.println("==============>" + DvdReturn.getTitle());
			return "SUCCESS";
		}
		else
			return "FAILURE";
	}
	
	public String search() throws Exception {
		DvdService dvdService = new DvdService();
		Dvd DvdReturn = dvdService.search(dvd);
		if (DvdReturn.getTitle() != null){
			dvd = DvdReturn;
			System.out.println("Dvd Search Success"+DvdReturn.getTitle());
			return "SUCCESS";
		}
		else{
			return "FAILURE";
		}
	}
	
	public void setDvd(Dvd dvd) {
		this.dvd = dvd;
	}

	public Dvd getDvd() {
		return dvd;
	}
}

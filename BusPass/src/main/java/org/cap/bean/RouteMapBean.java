package org.cap.bean;

public class RouteMapBean {
	private int routeid;
	private String routepath;
	private int occseats;
	private int totalseats;
	private int busno;
	private String busdriver;
	private int totalkm;
	public RouteMapBean() {
		super();
	}
	public RouteMapBean(int routeid, String routepath, int occseats, int totalseats, int busno, String busdriver,
			int totalkm) {
		super();
		this.routeid = routeid;
		this.routepath = routepath;
		this.occseats = occseats;
		this.totalseats = totalseats;
		this.busno = busno;
		this.busdriver = busdriver;
		this.totalkm = totalkm;
	}
	public int getRouteid() {
		return routeid;
	}
	public void setRouteid(int routeid) {
		this.routeid = routeid;
	}
	public String getRoutepath() {
		return routepath;
	}
	public void setRoutepath(String routepath) {
		this.routepath = routepath;
	}
	public int getOccseats() {
		return occseats;
	}
	public void setOccseats(int occseats) {
		this.occseats = occseats;
	}
	public int getTotalseats() {
		return totalseats;
	}
	public void setTotalseats(int totalseats) {
		this.totalseats = totalseats;
	}
	public int getBusno() {
		return busno;
	}
	public void setBusno(int busno) {
		this.busno = busno;
	}
	public String getBusdriver() {
		return busdriver;
	}
	public void setBusdriver(String busdriver) {
		this.busdriver = busdriver;
	}
	public int getTotalkm() {
		return totalkm;
	}
	public void setTotalkm(int totalkm) {
		this.totalkm = totalkm;
	}
	@Override
	public String toString() {
		return "RouteMapBean [routeid=" + routeid + ", routepath=" + routepath + ", occseats=" + occseats
				+ ", totalseats=" + totalseats + ", busno=" + busno + ", busdriver=" + busdriver + ", totalkm="
				+ totalkm + "]";
	}
	

}

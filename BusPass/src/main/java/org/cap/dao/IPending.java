package org.cap.dao;

import java.time.LocalDate;
import java.util.List;

import org.cap.bean.BusBean;
import org.cap.bean.TransactionBean;

public interface IPending {
	public List<BusBean> pendingDetails();
	public abstract List<BusBean> pendingDetailsOfEmp(String empid);
	public abstract Integer transaction(TransactionBean transaction);
	public List<TransactionBean> monthlyReport(LocalDate fdate,LocalDate tdate);

}

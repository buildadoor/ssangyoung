package springweb.a05_mvc.a03_dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import springweb.z01_vo.Calendar;

public interface A20_CalendarDao {
	public List<Calendar> calList();
	public void insertCalendar(Calendar ins);
	public void uptCalendar(Calendar upt);
	public void delCalendar(int id);
}

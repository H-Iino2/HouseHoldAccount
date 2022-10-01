package com.householdaccount.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.householdaccount.Bean.ItemBean;
import com.householdaccount.dao.ItemDao;

@Service
public class ItemService {
	@Autowired
	private ItemDao dao;
	
	//登録処理
	public void insertItem(String item,int price, Date sqlPaydate) {
		

		dao.insertItem(item,price,sqlPaydate);
	}
	
	//表示処理
	public List<ItemBean> selectItem() {
		
		/*sqldate
		long miliseconds = System.currentTimeMillis();
	    Date todayDate = new Date(miliseconds);
	    */
	    LocalDate now = LocalDate.now();
		LocalDate firstDate = now.withDayOfMonth(1);
	    int monLength = now.lengthOfMonth();
		LocalDate lastDate = now.withDayOfMonth(monLength);
		return dao.selectItem(firstDate,lastDate);
	}
	
	//合計金額取得
	public int mountPrice() {
	    LocalDate now = LocalDate.now();
		LocalDate firstDate = now.withDayOfMonth(1);
	    int monLength = now.lengthOfMonth();
		LocalDate lastDate = now.withDayOfMonth(monLength);
		return dao.mountPrice(firstDate,lastDate);
	}
	
	//品物事
	public List<ItemBean> selectClassify(){
		
	    LocalDate now = LocalDate.now();
		LocalDate firstDate = now.withDayOfMonth(1);
	    int monLength = now.lengthOfMonth();
		LocalDate lastDate = now.withDayOfMonth(monLength);
		
		return dao.selectClassify(firstDate,lastDate);
	}
	
	//削除処理
	public void deleteItem(int id) {
		dao.deleteItem(id);
	}
	
	//更新画面取得処理
	public List<ItemBean> updateSelectItem(int id) {
		return dao.updateSelectItem(id);
	}
	
	//検索
	public List<ItemBean> selectSerchItem(LocalDate firstDate ,LocalDate lastDate) {
		
		return dao.selectItem(firstDate,lastDate);
	}
	
	public List<ItemBean> selectSerchClassify(LocalDate firstDate ,LocalDate lastDate){
		
		return dao.selectClassify(firstDate,lastDate);
	}
	
	//検索合計金額取得
	public int serchMountPrice(LocalDate firstDate ,LocalDate lastDate) {

		return dao.mountPrice(firstDate,lastDate);
	}
	
	
	
}

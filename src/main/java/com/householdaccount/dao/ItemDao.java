package com.householdaccount.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.householdaccount.Bean.ItemBean;
import com.householdaccount.mapper.ItemMapper;

@Repository
public class ItemDao {
	@Autowired
	private ItemMapper mapper;
	
	//登録処理
	public boolean insertItem(String item,int price, Date sqlPayDate) {
	return mapper.insertItem(item,price,sqlPayDate);
	}
	
	//更新処理
	public void updateItem(int id,String item,int price, Date sqlPayDate) {
		mapper.updateItem(id,item,price,sqlPayDate);
	}
	//表示処理
	public List<ItemBean> selectItem(LocalDate firstDate,LocalDate lastDate){
		return mapper.selectItem(firstDate,lastDate);
	}
	//合計金額
	public int mountPrice(LocalDate firstDate,LocalDate lastDate) {
		return mapper.mountPrice(firstDate,lastDate);
	}
	//品物事
	public List<ItemBean> selectClassify(LocalDate firstDate,LocalDate lastDate){
		return mapper.selectClassify(firstDate,lastDate);
	}
	
	
	
	//削除処理
	public void deleteItem(int id) {
		mapper.deleteItem(id);
	}
	
	//更新処理
	public List<ItemBean> updateSelectItem(int id) {
		return mapper.updateSelectItem(id);
	}
	
	
	
}

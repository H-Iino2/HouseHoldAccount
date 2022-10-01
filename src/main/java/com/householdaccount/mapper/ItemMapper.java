package com.householdaccount.mapper;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.householdaccount.Bean.ItemBean;

@Mapper
public interface ItemMapper {
	//登録処理
	boolean insertItem(String item,int price,Date sqlPayDate);
	
	//表示処理
	List<ItemBean> selectItem(LocalDate firstDate,LocalDate lastDate);
	
	int mountPrice(LocalDate firstDate,LocalDate lastDate);
	
	//品物事
	List<ItemBean> selectClassify(LocalDate firstDate,LocalDate lastDate);
	
	//削除処理
	void deleteItem(int id);
	
	//更新処理
	List<ItemBean> updateSelectItem(int id);
}

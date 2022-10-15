package com.householdaccount.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.householdaccount.Bean.ItemBean;
import com.householdaccount.service.ItemService;


@Controller
public class MainController {
	@Autowired
	private ItemService service; 
	
	//登録画面
	@RequestMapping("/")
	public String test(Model model) {
		List<ItemBean> selectItem = service.selectItem();
		model.addAttribute("resultLists",selectItem);
		
		//合計金額
		int mountPrice = service.mountPrice();
		
		//品物別
		List<ItemBean> resultClassify = service.selectClassify();
		System.out.println(resultClassify.get(0).getItem());		
		model.addAttribute("mountPrice",mountPrice);
		model.addAttribute("resultClassify",resultClassify);
		
		
		return "top";
	}
	
	//登録処理
	@RequestMapping(path ="/submit",method = RequestMethod.POST )
	public String submit(Model model,
			@RequestParam("product") String item,@RequestParam("price") int price, @RequestParam("date") String payDate
			) {
		//日付を型変換
		Date sqlPayDate = Date.valueOf(payDate);
		service.insertItem(item,price,sqlPayDate);
		/*
		LocalDate ld = LocalDate.parse(payDate);
		System.out.println(ld);
		*/		
		return "redirect:/";
	}
	
	//削除処理
	@RequestMapping (value = "/delete/{id}" ,method = RequestMethod.POST)
	public String deleteItem(Model model, @PathVariable("id") int id ) {
		service.deleteItem(id);	
		return "redirect:/";
	}
	
	//更新画面
	@RequestMapping (value = "/update/{id}",method = RequestMethod.GET)
	public String updateSelectItem(Model model, @PathVariable("id") int id) {
		List<ItemBean> resultList = service.updateSelectItem(id);
		model.addAttribute("resultList",resultList);
		return "update";
	} 
	
	//更新処理
	@RequestMapping(path ="/updateItem",method = RequestMethod.POST )
	public String updateItem(Model model,
			@RequestParam("id") int id, @RequestParam("product") String item,@RequestParam("price") int price, @RequestParam("date") String payDate
			) {
		//日付を型変換
		Date sqlPayDate = Date.valueOf(payDate);
		//service.insertItem(item,price,sqlPayDate);
		service.updateItem(id,item,price,sqlPayDate);
		/*
		LocalDate ld = LocalDate.parse(payDate);
		System.out.println(ld);
		*/		
		return "redirect:/";
	}
	
	//参照処理
	@RequestMapping(path = "/past",method = RequestMethod.GET)
	public String selectPast(Model model ) {
		return "pastindex"; 
	}
	
	//参照検索処理
	@RequestMapping(path = "/serch",method = RequestMethod.POST)
	public String selectPastSerch(Model model, @RequestParam("selectFirstDate") String srFirstDate, @RequestParam("selectLastDate") String srLastDate) {
		
		LocalDate firstDate = LocalDate.parse(srFirstDate);
		LocalDate lastDate = LocalDate.parse(srLastDate);
		
		List<ItemBean> selectItem = service.selectSerchItem(firstDate,lastDate);
		
		
		//品物別
		List<ItemBean> resultClassifys = service.selectSerchClassify(firstDate,lastDate);
		
		int mountPrice = service.serchMountPrice(firstDate,lastDate);
		model.addAttribute("mountPrice",mountPrice);
		model.addAttribute("resultClassify",resultClassifys);
		
		model.addAttribute("resultLists",selectItem);
		return "pastindex"; 
	}
	
}

package com.web.statistics.controller;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import com.app.data.entity.DataVO;
import com.ssc.system.page.Page;
import com.web.category.entity.Category;
import com.web.category.service.CategoryService;
import com.web.member.entity.MemberInfo;
import com.web.statistics.entity.Type;
import com.web.statistics.service.TypeService;
@Controller
@RequestMapping("type")
public class typeController {
@Autowired
private TypeService typeService;

//@RequestMapping("typeTree")
//public String typeTree() {
//    return "merchandise/home";
//}
	@RequestMapping("list")
	@ResponseBody
	public  List<Type> findType(Type type){
		
		List<Type> list =new ArrayList<Type>();
	    list = typeService.findType(type);
	    return list;
	}
 
//	@RequestMapping("lists")
//	@ResponseBody
//	public void getData(HttpServletRequest request, HttpServletResponse response,Type type) {
//		response.setContentType("text/html;charset=GBK");
//		try {
//			PrintWriter out = response.getWriter();
//			List<Type> lists =new ArrayList<Type>();
//		    lists = typeService.findType(type);
//			out.print(lists);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	
//	}


@RequestMapping("insertNode")
@ResponseBody
public JSONObject insertTypes(Type type) {
    JSONObject fd = new JSONObject();
    if (type.getName()!= null) {
//    	 typeService.insertNode(type);
        fd.put("name", typeService.insertNode(type));
    } else {
    	 typeService.insertNode(type);
    }
    return fd;
}
//@RequestMapping("insertNode")
//public String insertTypes(Type type, Model model) {
//    if (type.getName()!= null) {
//       List<Type> list =new ArrayList<Type>();
//    	list = typeService.findType(type);;
//    }
//    model.addAttribute("type", type);
//    return "merchandise/home";
//}
	}



package com.web.statistics.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import com.ssc.system.dao.BaseDao;
import com.web.statistics.entity.*;
@Service
public class TypeService {
 @Autowired
private BaseDao baseDao;
 public List<Type> findType(Type type){
	 String sql = "select *from b_type";	
	 SqlParameterSource params = new BeanPropertySqlParameterSource(type);
     List<Type> list = baseDao.query(sql,new BeanPropertyRowMapper<Type>(Type.class), params);
     if (list!= null && list.size()>0) {
 		for (int i=0;i<list.size();i++) {
 			Type node=list.get(i);
// 			System.out.println("<node nodeId='"+node.getId()+"' parentId='"+node.getPid()+"'>"+node.getName()+"</node>");
 		}
// 		System.out.println("</nodes>");
 	}
     return list;
 }

public boolean insertNode(Type type) {
	String insertsql ="insert into b_type(name, pid) values(:name,:pid)";
	SqlParameterSource params = new BeanPropertySqlParameterSource(type);
    int res= baseDao.update(insertsql,params);
    if (res!=0){
        return true;
    }else {
        return false;
    }
}

}

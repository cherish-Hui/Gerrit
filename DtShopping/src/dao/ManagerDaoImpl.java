package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Manager;
import utils.odbcUtils;

public class ManagerDaoImpl {
	//查询管理员列表
	public List queryManager(String manangeid,String permission){
		List<Manager> list=null;
		ArrayList<HashMap<String, Object>> list1=null;
		Object [] params={manangeid};
		String sql=" select * from dt_manager ";
		String sql1=" select * from dt_manager where manager_id=? ";
		if(Integer.parseInt(permission)==1){
			list1=odbcUtils.executeQuery(sql, null);
		}else{
			list1=odbcUtils.executeQuery(sql1, params);
		}
		odbcUtils.close();
		if(list1.size()>0){
			Manager manager=null;
			list=new ArrayList<Manager>();
			for(int i=0;i<list1.size();i++){
				manager=new Manager();
				HashMap map=list1.get(i);
				manager.setManagerid(String.valueOf(map.get("manager_id")));
				manager.setUsername(String.valueOf(map.get("username")));
				manager.setPassword(String.valueOf(map.get("password")));
				manager.setRealname(String.valueOf(map.get("realname")));
				manager.setEmail(String.valueOf(map.get("email")));
				manager.setPermission(String.valueOf(map.get("permission")));
				manager.setPhoto(String.valueOf(map.get("photo")));
				manager.setBoonday(String.valueOf(map.get("boonday")));
				manager.setState(String.valueOf(map.get("status")));
				manager.setLastlogen(String.valueOf(map.get("lastlogen")));
				list.add(manager);
				System.out.println(map.get("manager_id"));
				System.out.println(map.get("realname"));
			}
		}
		return list;
	}
	
	//查询某个id的管理员信息，用于回显
	public Manager queryManagerInfo(String managerid){
		Manager manager=null;
		ArrayList<HashMap<String, Object>> list=null;
		String sql=" select * from dt_manager where manager_id=? ";
		Object [] params={managerid};
		list=odbcUtils.executeQuery(sql, params);
		if(list.size()>0){
			manager=new Manager();
			HashMap map=list.get(0);
			manager.setManagerid(String.valueOf(map.get("manager_id")));
			manager.setUsername(String.valueOf(map.get("username")));
			manager.setPassword(String.valueOf(map.get("password")));
			manager.setRealname(String.valueOf(map.get("realname")));
			manager.setEmail(String.valueOf(map.get("email")));
			manager.setPermission(String.valueOf(map.get("permission")));
			manager.setPhoto(String.valueOf(map.get("photo")));
			manager.setBoonday(String.valueOf(map.get("boonday")));
			manager.setLastlogen(String.valueOf(map.get("lastlogen")));
			System.out.println(map.get("lastlogen"));
			manager.setState(String.valueOf(map.get("status")));
		}
		return manager;
	}
	//添加管理员
	public int addManager(Manager manager){
		int i=0;
		String sql=" insert into dt_manager (username,password,realname,email,permission,photo,boonday,status) values(?,?,?,?,?,?,?,?) ";
		Object []params={manager.getUsername(),manager.getPassword(),manager.getRealname(),manager.getEmail(),manager.getPermission(),manager.getPhoto(),manager.getBoonday(),manager.getState()};
		i=odbcUtils.executeUpdate(sql, params);
		odbcUtils.close();
		return i;
	}
	//超级管理员修改普通管理员的权限和状态
	public int updataManager(Manager manager){
		int i=0;
		String sql="";
		int count=1;
		if(Integer.parseInt(manager.getPermission())!=0){
			count++;
			if(Integer.parseInt(manager.getState())!=2){
				count++;
			}
		}
		System.out.println("count:"+count);
		Object[] params=new Object[count];
		if(Integer.parseInt(manager.getPermission())==0){
			if(Integer.parseInt(manager.getState())==2){
				return 0;
			}else{
				sql=" update dt_manager set status=? where manager_id=? ";
				params[0]=manager.getState();
				params[1]=manager.getManagerid();
			}
		}else if(Integer.parseInt(manager.getState())==2){
			sql=" update dt_manager set permission=? where manager_id=? ";
			params[0]=manager.getPermission();
			params[1]=manager.getManagerid();
		}else{
			sql=" update dt_manager set permission=?,status=? where manager_id=? ";
			params[0]=manager.getPermission();
			params[1]=manager.getState();
			params[2]=manager.getManagerid();
		}

		i=odbcUtils.executeUpdate(sql, params);
		odbcUtils.close();
		return i;
	}
	
	
	//修改个人信息
	
	public int updataMyInfo(Manager manager){
		int i=0;
		String sql=" update dt_manager set username=?,realname=?,email=?,photo=?  where manager_id=? ";
		Object [] params={manager.getUsername(),manager.getRealname(),manager.getEmail(),manager.getPhoto(),manager.getManagerid()};
		i=odbcUtils.executeUpdate(sql, params);
		odbcUtils.close();
		return i;
	}
	
	//修改密码
	public int uptateMyPassword(Object []params){
		int i=0;
		String sql=" update dt_manager set password=? where username=? ";
		odbcUtils.executeUpdate(sql, params);
		odbcUtils.close();
		return i;
	}
}

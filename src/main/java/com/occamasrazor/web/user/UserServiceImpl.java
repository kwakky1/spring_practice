package com.occamasrazor.web.user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.JOptionPane;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	public static final String FILE_PATH = "C:\\Users\\Administrator\\spring-workspace\\occamasrazor\\src\\main\\resources\\static\\user\\";
	private Map<String, Object> map;
	public UserServiceImpl() {
		map = new HashMap<>();
	}
	@Override
	public void add(User user) {
		map.put(user.getUserid(),user);
	}
	
	@Override
	public int count() {
		return map.size();
	}
	
	@Override
	public User login(User user) {
		System.out.println(user);
		User returnUser = null;
		if(map.containsKey(user.getUserid())) {
			User u = detail(user.getUserid());
			if(user.getPassword().equals(u.getPassword())) {
				return u;
			}
		}
		return returnUser;
	}
	
	@Override
	public User detail(String userid) {	
		System.out.println(">>>>>>>>>>>>>>"+userid);
		return (User) map.get(userid);
	}
	
	@Override
	public boolean update(User user) {
		map.replace(user.getUserid(), user);
		return true;
	}
	@Override
	public boolean remove(String userid) {
		map.remove(userid);
		return true;
	}
	
	@Override
	public List<User> list() {
		List<User> list = new ArrayList<>();
		@SuppressWarnings("rawtypes")
		Set set = map.entrySet();
		@SuppressWarnings("rawtypes")
		Iterator it = set.iterator();
		while(it.hasNext()) {
			@SuppressWarnings("unchecked")
			Map.Entry<String , User> e = (Entry<String, User>) it.next();
			list.add(e.getValue());
		}
		for(int i=0;i<list.size();i++) {
			System.out.println("========"+list.get(i));
		}
		return list;
	}
	
	@Override
	public void saveFile(User user) {
		try {
			File file = new File(FILE_PATH+"list.txt");
			@SuppressWarnings("resource")
			BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
				String message = user.toString();
				System.out.println(message);
				writer.write(message+"\n");
				writer.flush();
		} catch(Exception e) {
		}
	}
	
	@Override
	public List<User> readFile() {
		List<User> userlist = new ArrayList<>();
		List<String> list = new ArrayList<>();
		try {
			File file = new File(FILE_PATH+"list.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String message = "";
			while((message = reader.readLine())!= null) {
				list.add(message);
			}
			JOptionPane.showConfirmDialog(null, list);
			reader.close();
		} catch(Exception e) {
			
		}
		User u = null;
		for(int i=0;i<list.size();i++) {
			u = new User();
			String[] arr = list.get(i).split(",");
			u.setUserid(arr[0]);
			u.setPassword(arr[1]);
			u.setName(arr[2]);
			u.setSsn(arr[3]);
			u.setAddr(arr[4]);
			userlist.add(u);
		}
		System.out.println(">>>>>>>>>>>"+userlist);
		return userlist;
	}



}

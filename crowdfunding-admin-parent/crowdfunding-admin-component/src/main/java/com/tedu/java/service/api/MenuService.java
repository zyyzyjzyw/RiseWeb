package com.tedu.java.service.api;


import com.tedu.java.entity.Menu;

import java.util.List;

public interface MenuService {
	
	List<Menu> getAll();

	void saveMenu(Menu menu);

	void updateMenu(Menu menu);

	void removeMenu(Integer id);

}

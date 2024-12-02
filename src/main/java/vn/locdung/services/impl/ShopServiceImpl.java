package vn.locdung.services.impl;

import java.util.List;

import vn.locdung.daos.IShopDao;
import vn.locdung.daos.impl.ShopDaoImpl;
import vn.locdung.models.ShopModel;
import vn.locdung.services.IShopService;

public class ShopServiceImpl implements IShopService{
	IShopDao shopDao = new ShopDaoImpl();
	@Override
	public List<ShopModel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShopModel findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int checkShop(int userid) {
		return shopDao.checkShop(userid);
	}

	@Override
	public void insert(ShopModel shop) {
		// TODO Auto-generated method stub
		
	}

}

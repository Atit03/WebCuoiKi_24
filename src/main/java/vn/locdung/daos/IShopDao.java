package vn.locdung.daos;

import java.util.List;

import vn.locdung.models.ShopModel;


public interface IShopDao {
	List<ShopModel> findAll();
	ShopModel findById(int id);
	int checkShop(int userid);
	void insert(ShopModel shop);
}

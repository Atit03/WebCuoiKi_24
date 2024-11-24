package vn.locdung.services;

import java.util.List;

import vn.locdung.models.ShopModel;

public interface IShopService {
	List<ShopModel> findAll();
	ShopModel findById(int id);
	int checkShop(int userid);
	void insert(ShopModel shop);
}

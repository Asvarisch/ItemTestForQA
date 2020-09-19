package telran.ashkelon2020.item.service;

import telran.ashkelon2020.item.dto.ItemDto;
import telran.ashkelon2020.item.model.Item;

public interface ItemService {

	Iterable<Item> findAllItems();

	ItemDto findById(Integer no);

	ItemDto withdrawalQuantity(Integer no, Integer amount);

	ItemDto depositQuantity(Integer no, Integer amount);

	boolean addItem(ItemDto itemDto);

	ItemDto deleteItem(Integer no);

}

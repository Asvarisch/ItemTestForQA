package telran.ashkelon2020.item.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import telran.ashkelon2020.item.dto.ItemDto;
import telran.ashkelon2020.item.model.Item;
import telran.ashkelon2020.item.service.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@GetMapping("/items")
	public Iterable<Item> findAllItems() {
		return itemService.findAllItems();
	}
	
	@GetMapping("/item/{no}")
	public ItemDto findById(@PathVariable Integer no) {
		return itemService.findById(no);
	}
	
	@PutMapping("/item/{no}/withdrawal/{amount}")
	public ItemDto withdrawalQuantity(@PathVariable Integer no, @PathVariable Integer amount) {
		return itemService.withdrawalQuantity(no, amount);
	}
	
	@PutMapping("/item/{no}/deposit/{amount}")
	public ItemDto depositQuantity(@PathVariable Integer no, @PathVariable Integer amount) {
		return itemService.depositQuantity(no, amount);
	}
	
	@PostMapping("/item")
	public boolean addItem(@RequestBody ItemDto itemDto) {
		return itemService.addItem(itemDto);
	}
	
	@DeleteMapping("/item/{no}")
	public ItemDto deleteItem(@PathVariable Integer no) {
		return itemService.deleteItem(no);
	}
	

}

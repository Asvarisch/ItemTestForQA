package telran.ashkelon2020.item.service;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.ashkelon2020.item.dao.ItemRepository;
import telran.ashkelon2020.item.dto.ItemDto;
import telran.ashkelon2020.item.dto.exceptions.ItemNotFoundException;
import telran.ashkelon2020.item.model.Item;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public Iterable<Item> findAllItems() {
		return itemRepository.findAll().stream()
				.collect(Collectors.toList());
	}

	@Override
	public ItemDto findById(Integer no) {
		Item item = itemRepository.findById(no).orElseThrow(() -> new ItemNotFoundException());
		return modelMapper.map(item, ItemDto.class);
	}

	@Override
	public ItemDto withdrawalQuantity(Integer no, Integer amount) {
		Item item = itemRepository.findById(no).orElseThrow(() -> new ItemNotFoundException());
		item.setAmount(item.getAmount()-amount);
		itemRepository.save(item);
		return modelMapper.map(item, ItemDto.class);
	}

	@Override
	public ItemDto depositQuantity(Integer no, Integer amount) {
		Item item = itemRepository.findById(no).orElseThrow(() -> new ItemNotFoundException());
		item.setAmount(item.getAmount()+amount);
		itemRepository.save(item);
		return modelMapper.map(item, ItemDto.class);
	}

	@Override
	public boolean addItem(ItemDto itemDto) {
		if (itemRepository.existsById(itemDto.getNo())) {
			return false;
		}
		Item item = new Item(itemDto.getNo(), itemDto.getName(), itemDto.getAmount(), itemDto.getInventoryCode());
		itemRepository.save(item);
		return true;
	}

	@Override
	public ItemDto deleteItem(Integer no) {
		Item item = itemRepository.findById(no).orElseThrow(() -> new ItemNotFoundException());
		itemRepository.delete(item);
		return modelMapper.map(item, ItemDto.class);
	}

}

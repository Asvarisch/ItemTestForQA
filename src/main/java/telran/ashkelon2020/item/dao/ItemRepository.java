package telran.ashkelon2020.item.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import telran.ashkelon2020.item.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}

package telran.ashkelon2020.item.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemDto {
	Integer no;
	String name;
	Integer amount;
	String inventoryCode;
}

package htw.berlin.webtech.demo.service;

import htw.berlin.webtech.demo.persistence.ItemEntity;
import htw.berlin.webtech.demo.persistence.ItemRepository;
import htw.berlin.webtech.demo.web.api.Item;
import htw.berlin.webtech.demo.web.api.ItemManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findAll() {
        List<ItemEntity> items = itemRepository.findAll();
        return items.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Item findById(Long id) {
        var itemEntity = itemRepository.findById(id);
        return itemEntity.map(this::transformEntity).orElse(null);
    }

    public Item create(ItemManipulationRequest request) {
        var itemEntity = new ItemEntity(request.getProdukt(), request.getMenge());
        itemEntity = itemRepository.save(itemEntity);
        return transformEntity(itemEntity);
    }

    public Item update(Long id, ItemManipulationRequest request) {
        var itemEntityOptional = itemRepository.findById(id);
        if (itemEntityOptional.isEmpty()) {
            return null;
        }

        var itemEntity = itemEntityOptional.get();
        itemEntity.setProdukt(request.getProdukt());
        itemEntity.setMenge(request.getMenge());
        itemEntity = itemRepository.save(itemEntity);

        return transformEntity(itemEntity);
    }

    public boolean deleteById(Long id) {
        if (!itemRepository.existsById(id)) {
            return false;
        }

        itemRepository.deleteById(id);
        return true;
    }

    private Item transformEntity(ItemEntity itemEntity) {
        return new Item(
                itemEntity.getId(),
                itemEntity.getProdukt(),
                itemEntity.getMenge()
        );
    }
}

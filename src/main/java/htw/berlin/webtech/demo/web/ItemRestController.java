package htw.berlin.webtech.demo.web;

import htw.berlin.webtech.demo.service.ItemService;
import htw.berlin.webtech.demo.web.api.Item;
import htw.berlin.webtech.demo.web.api.ItemManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@Validated
public class ItemRestController {

    private final ItemService itemService;

    public ItemRestController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(path = "/api/v1/item")
    public ResponseEntity<List<Item>> fetchItem() {
        return ResponseEntity.ok(itemService.findAll());
    }

    @GetMapping(path = "/api/v1/item/{id}")
    public ResponseEntity<Item> fetchItemById(@PathVariable Long id) {
        var item = itemService.findById(id);
        return item != null? ResponseEntity.ok(item) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/item")
    public ResponseEntity<Void> createItem(@RequestBody ItemManipulationRequest request) throws URISyntaxException {
        var item = itemService.create(request);
        URI uri = new URI("/api/v1/item/" + item.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/item/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody ItemManipulationRequest request) {
        var item = itemService.update(id, request);
        return item != null? ResponseEntity.ok(item) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/item/{id}")
        public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
            boolean successful = itemService.deleteById(id);
            return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}

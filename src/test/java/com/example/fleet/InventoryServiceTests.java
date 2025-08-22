import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.fleet.model.InventoryItem;
import com.example.fleet.repository.InventoryRepository;
import com.example.fleet.service.InventoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class InventoryServiceTests {

    @InjectMocks
    private InventoryService inventoryService;

    @Mock
    private InventoryRepository inventoryRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddInventoryItem() {
        InventoryItem item = new InventoryItem(1L, "Item1", 10);
        when(inventoryRepository.save(item)).thenReturn(item);

        InventoryItem createdItem = inventoryService.addInventoryItem(item);
        assertEquals(item.getName(), createdItem.getName());
        assertEquals(item.getQuantity(), createdItem.getQuantity());
    }

    @Test
    public void testGetInventoryItem() {
        InventoryItem item = new InventoryItem(1L, "Item1", 10);
        when(inventoryRepository.findById(1L)).thenReturn(Optional.of(item));

        InventoryItem foundItem = inventoryService.getInventoryItem(1L);
        assertEquals(item.getName(), foundItem.getName());
    }

    @Test
    public void testGetAllInventoryItems() {
        InventoryItem item1 = new InventoryItem(1L, "Item1", 10);
        InventoryItem item2 = new InventoryItem(2L, "Item2", 5);
        when(inventoryRepository.findAll()).thenReturn(Arrays.asList(item1, item2));

        List<InventoryItem> items = inventoryService.getAllInventoryItems();
        assertEquals(2, items.size());
    }

    @Test
    public void testUpdateInventoryItem() {
        InventoryItem item = new InventoryItem(1L, "Item1", 10);
        when(inventoryRepository.findById(1L)).thenReturn(Optional.of(item));
        when(inventoryRepository.save(item)).thenReturn(item);

        item.setQuantity(15);
        InventoryItem updatedItem = inventoryService.updateInventoryItem(item);
        assertEquals(15, updatedItem.getQuantity());
    }

    @Test
    public void testDeleteInventoryItem() {
        InventoryItem item = new InventoryItem(1L, "Item1", 10);
        when(inventoryRepository.findById(1L)).thenReturn(Optional.of(item));
        doNothing().when(inventoryRepository).delete(item);

        inventoryService.deleteInventoryItem(1L);
        verify(inventoryRepository, times(1)).delete(item);
    }
}
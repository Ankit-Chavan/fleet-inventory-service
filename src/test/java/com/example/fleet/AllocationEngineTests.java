import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;

class AllocationEngineTests {

    @InjectMocks
    private AllocationEngine allocationEngine;

    @Mock
    private InventoryRepository inventoryRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAllocateVehicles_Success() {
        // Given
        List<Vehicle> availableVehicles = Arrays.asList(new Vehicle(1L, "Model A", "available"),
                                                        new Vehicle(2L, "Model B", "available"));
        AllocationRequestDto request = new AllocationRequestDto(2);

        // When
        when(inventoryRepository.findAvailableVehicles()).thenReturn(availableVehicles);
        List<Vehicle> allocatedVehicles = allocationEngine.allocateVehicles(request);

        // Then
        assertEquals(2, allocatedVehicles.size());
        assertTrue(allocatedVehicles.stream().allMatch(v -> v.getStatus().equals("allocated")));
    }

    @Test
    void testAllocateVehicles_NotEnoughVehicles() {
        // Given
        List<Vehicle> availableVehicles = Arrays.asList(new Vehicle(1L, "Model A", "available"));
        AllocationRequestDto request = new AllocationRequestDto(2);

        // When
        when(inventoryRepository.findAvailableVehicles()).thenReturn(availableVehicles);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            allocationEngine.allocateVehicles(request);
        });

        // Then
        assertEquals("Not enough vehicles available for allocation", exception.getMessage());
    }
}
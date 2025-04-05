import org.springframework.stereotype.Service;

@Service
public class StorageService {

    @Autowired
    private StorageRepository storageRepository;

    public void decreaseStock(Long productId, Integer quantity) {
        // 根據商品 ID 查找庫存
        Storage storage = storageRepository.findByProductId(productId);
        if (storage.getQuantity() >= quantity) {
            storage.setQuantity(storage.getQuantity() - quantity);
            storageRepository.save(storage);
        } else {
            throw new RuntimeException("Not enough stock");
        }
    }
}

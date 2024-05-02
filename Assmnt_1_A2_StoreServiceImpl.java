@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private MessageChannel storeChannel;

    @Override
    public List<Store> getStores() {
        return Collections.emptyList(); 
    }

    @Override
    public Store getStoreById(String id) {
        return storeMap.get(id);
    }

    @Override
    public Store createStore(Store store) {
        store.setId(UUID.randomUUID().toString());
        storeMap.put(store.getId(), store);
        return store;
    }

    @Override
    public Store updateStore(String id, Store store) {
         store.setId(id);
        return storeMap.put(id, store); 
    }

    @Override
    public void deleteStore(String id) {
        storeMap.remove(id);
    }
}

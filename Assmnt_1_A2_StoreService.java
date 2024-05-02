public interface StoreService {

    List<Store> getStores();

    Store getStoreById(String id);

    Store createStore(Store store);

    Store updateStore(String id, Store store);

    void deleteStore(String id);
}

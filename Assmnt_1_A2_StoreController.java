@RestController
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping
    public List<Store> getStores() {
        return storeService.getStores();
    }

    @GetMapping("/{id}")
    public Store getStoreById(@PathVariable String id) 
	{
        return storeService.getStoreById(id);
    }

    @PostMapping
    public Store createStore(@RequestBody Store store)
	{
        return storeService.createStore(store);
    }

 

   
    @PutMapping("/{id}")
    public Store updateStore(@PathVariable String id, @RequestBody Store store) 
	{
        return storeService.updateStore(id, store);
    }

    @DeleteMapping("/{id}")
    public void deleteStore(@PathVariable String id) 
	{
        storeService.deleteStore(id);
    }
}

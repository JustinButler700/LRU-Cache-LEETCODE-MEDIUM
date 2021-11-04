//Justin Butler
// 11/4/2021
class LRUCache {
    LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
    int maxSize;
    public LRUCache(int capacity) {
        maxSize = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key))
        {
            int result = map.get(key);
            map.remove(key); //pop key
            map.put(key, result); //push key to back
            return result;
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            map.remove(key); //pop key
            map.put(key, value); //push key to back
        }
        else
        {
            if(map.size() >= maxSize){map.remove(map.entrySet().iterator().next().getKey());} // remove the head of the linkedHashMap
            map.put(key,value);
        }
    }
}

import java.util.ArrayList;
import java.util.List;

public class MyMap<K,V> {

    private List<MyNode<K,V>> bucket;

    private int size;
    private int capacity;
    private final int CURRENT_CAPACITY=5;


    void MyMap()
    {
        bucket=new ArrayList<>();
        capacity=CURRENT_CAPACITY;
        for(int i=0;i<capacity;i++)
        {
            bucket.add(null);
        }
    }

    public void put(K key,V value)
    {

    }

    public V get(K key)
    {

    }

    public void remove(K key)
    {

    }

    private int getBucketIndex(K key)
    {
        int hashCode=key.hashCode();
        return hashCode%capacity;
    }


    private class MyNode<K,V>{
        K key;
        V value;
    
        MyNode<K,V> next;
    
        public MyNode(K key, V value)
        {
            this.key=key;
            this.value=value;
        }
    }
}


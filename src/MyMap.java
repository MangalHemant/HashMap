import java.nio.channels.FileChannel.MapMode;
import java.util.ArrayList;
import java.util.List;

public class MyMap<K,V> {

    private List<MyNode<K,V>> bucket;

    private int size;
    private int capacity;
    private final int CURRENT_CAPACITY=5;


    public MyMap()
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
       int bucketIndex=getBucketIndex(key);
       MyNode<K,V> head=bucket.get(bucketIndex);
       while(head!=null)
       {
        if(head.key.equals(key))
        {
            head.value=value;
            return;
        }
        head=head.next;
       }
       MyNode<K,V> newNode=new MyNode<K,V>(key, value);
       head=bucket.get(bucketIndex);
       newNode.next=head;
       bucket.set(bucketIndex, newNode);
       size++;
        

       double loadFactor=(1.0*size)/capacity;

       if(loadFactor>0.7)
       {
        System.out.println("Rehashing");
        rehash();
       }


       
    }

    private void rehash()
    {
        List<MyNode<K,V>> temp=bucket;
        capacity*=2;
        bucket=new ArrayList<>();
        size=0;
        for(int i=0;i<capacity;i++)
        {
            bucket.add(null);
        }
        for(int i=0;i<temp.size();i++)
        {
            MyNode<K,V> node=temp.get(i);
            while(node!=null)
            {
                put(node.key,node.value);
                node=node.next;
            }
        }
           }

    public V get(K key)
    {
        int bucketIndex=getBucketIndex(key);
        MyNode<K,V> head=bucket.get(bucketIndex);
        while(head!=null)
        {
            if(head.key.equals(key))
            {
                return head.value;
            }
            head=head.next;
        }
       return null;
    }

    public void remove(K key)
    {
       int bucketIndex=getBucketIndex(key);
       MyNode<K,V> head=bucket.get(bucketIndex);
       MyNode<K,V> prev=null;
       while(head!=null)
       {
          if(head.key.equals(key))
          {
            if(prev==null)
            {
                bucket.set(bucketIndex, head.next);
            }
            else{
                prev.next=head.next;
            }
            size--;
            break;
          }
          prev=head;
          head=head.next;
          
       }
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


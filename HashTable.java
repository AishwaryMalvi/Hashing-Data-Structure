package Hashing;

public class HashTable {
	private HashNode[] bucket;
	private int numOfBuckets;
	private int size;
	
	public HashTable() {
		this(10);
	}
	public HashTable(int capicity) {
		this.numOfBuckets = capicity;
		bucket = new HashNode[numOfBuckets];
		this.size = 0;
	}
	
	private class HashNode{
		@SuppressWarnings("unused")
		private Integer key;
		@SuppressWarnings("unused")
		private String value;
	
		private HashNode next;
		
		
		public HashNode (Integer key,String value) {
			this.key = key;
			this.value = value;
		}
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	@SuppressWarnings("unused")
	public void put(Integer key,String value) {
		if(key == null || value == null) {
			throw new IllegalArgumentException("key or value is null");
		}
		int bucketIndex = getBucketIndex(key);
		HashNode head = bucket[bucketIndex];
		while(head!=null) {
			if(head!=null) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		size++;
		head = bucket[bucketIndex];
		HashNode node = new HashNode(key,value);
		node.next = head;
		bucket[bucketIndex] = node;
	}
	private int getBucketIndex(Integer key) {
		return key%numOfBuckets;
	}
	
	public String get(Integer key) {
		if(key == null) {
			throw new IllegalArgumentException("key is null !!!");
		}
		int bucketindex = getBucketIndex(key);
		HashNode head = bucket[bucketindex];
		while(head!=null) {
			if(head.key.equals(key)) {
				return head.value;
			}
			head = head.next;
		}
		return null;
	}
	
	public String remove(Integer key) {
		if(key == null) {
			throw new IllegalArgumentException("key is null !!!");
		}
		int bucketIndex = getBucketIndex(key);
		HashNode head = bucket[bucketIndex];
		HashNode previous = null;
		
		while(head!=null) {
			if(head.key.equals(key)) {
				break;
			}
			previous = head;
			head = head.next;
		}
		if(head == null) {
			return null;
		}
		size--;
		if(previous!=null) {
			previous.next = head.next;
		}
		else {
			bucket[bucketIndex] = head.next;
		}
		
		return head.value;
	}
	public static void main(String[] args) {
		HashTable table = new HashTable(10);
		table.put(105,"tom");
		table.put(105, "tina");
		table.put(101, "tima");
		table.put(109, "chima");
		table.put(106, "loka");
		System.out.println(table.size());
		System.out.println(table.get(101));
		System.out.println(table.get(107));
		System.out.println(table.remove(105));
		
		
	}
}

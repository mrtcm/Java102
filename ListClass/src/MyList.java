
public class MyList<T> {
	private int capacity;
	private int listSize=0;
	private T[] tempList;
	private T[] list ;
	
	public MyList() {
		this.capacity = 10;
		list = (T[]) new Object[capacity];
	}
	
	public MyList(int capacity) {
		this.capacity = capacity;
		list = (T[]) new Object[this.capacity];

	}
	
	public int size() {
		return listSize;
	}
	
	public int getCapacity() {
		return this.capacity;
	}
	
	public void add(T data) {
		
		if (size() == getCapacity()) {
			this.capacity = capacity*2;
			tempList = list.clone();
			list = (T[]) new Object[this.capacity];
			for (int i = 0 ; i<size() ; i++) {
				list[i] = tempList[i];
			}
		}
		list[listSize] = data;	
		listSize++;
	    
	}
	
	public T  get(int index) {
		if (listSize<index) {
			return null;
		}else {
			return list[index];
		}
	}
	
	public void remove(int index) {
		for (int i = index ; i<=listSize;i++) {
			list[i] =  list[i+1];
		}
		for(T s : list) {
			System.out.print(s + ",");
		}
		this.listSize--;
	}
	
	public  void set(int index , T data) {
		if (index >= list.length) {
			System.out.println("Hatalı index numarası");
		}
		else {
			list[index] =data;
		}
	}
	
	@Override
	public  String toString() {
		String veriable ="";
		veriable += "[";
		for (int i = 0 ; i< size() ; i++ ) {
			if (i == size()-1) {
				veriable += list[i] ;
			}else {
				veriable += list[i] + ",";
			}
		}
		veriable+="]";
		return veriable;
	}
	
	public int indexOf(T data) {
		for ( int i  = 0 ; i<size(); i++) {	
			if (list[i].toString().equals(data.toString())) {
				return i ;
			}
		}
		return -1 ;
	}

	public int lastIndexOf(T data) {
		int lastIndex = 0;
		for (int i = 0 ; i<size();i++) {
			if (list[i] == data ) {
			 	lastIndex =  i;
			}
		}
		if (lastIndex  == 0 ) {
			return 0;
		}
		
		return lastIndex;
	}
	
	public boolean isEmpty() {
		if (size()>0 ) {
			return false;
		}
		return true;
	}

	public T[] toArray() {
		Object[] dizi = new Object[size()];
		dizi = list.clone();
		return (T[])dizi;
	}

	public void clear() {
		this.list = (T[]) new Object[this.getCapacity()];
	}
	
	public MyList<T> subList(int start,int finish) {
		MyList<T> liste =new MyList<>(finish+1);
		for (int i = start ; i<=finish ; i++   ) {
				liste.add(list[i]);  
		}
		return liste;
			
	}

	public boolean contains(T data) {
		for (int i = 0 ; i<size(); i++) {
			if (list[i] == data) {
				return true;
			}
		}
		return false;
	}

}



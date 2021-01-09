import java.util.*;

public class TestTree {
	


	public static void main(String[] args){

		new TestTree().go();
		

	}	//	Close main

	public void go(){
		Book b1=new Book("How Cats Work");
		Book b2=new Book("Remix your Body");
		Book b3=new Book("Finding Emo");
		BookCompare bCompare =new BookCompare();
		TreeSet<Book> tree =new TreeSet<Book>();
		tree.add(b1);
		tree.add(b2);
		tree.add(b3);
		System.out.println(tree);
		
		
		
		
		
	}
	
	public class BookCompare implements Comparator<Book>{
		public int compare(Book one,Book two){
			return (one.title.compareTo(two.title));
		}
	}

	
}	//	Close class






/*
class Book implements Comparable{
		String title;
		
		public int compareTo(Object b){
		Book book=(Book) b;
		return title.compareTo(book.title);
		}


		public Book(String t){
			title =t;
		}
	}
*/



//Ϲд������
/* 	class Book implements Comparable<Book>{
		String title;
		
		public int compareTo(Book aBook){
		
		return title.compareTo(aBook.title);
		}


		public Book(String t){
			title =t;
		}
	} */
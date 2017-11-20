
public class NodeList {
	Node first;
	
	public NodeList(){
		
	}
	
	public void add(int val)
		{Node newNode = new Node(val);
		Node current = first;
		if(first==null){
			this.first=newNode;
		}
		else{
			while(current.next!=null){
				current = current.next;
			}
			current.next = newNode;
		}
	}
	private Node mergeSortLinkList(Node startNode){
		 
		  //Break the list until list is null or only 1 element is present in List.
		  if(startNode==null || startNode.next==null){
		   return startNode;
		  }
		 
		  //Break the linklist into 2 list.
		  //Finding Middle node and then breaking the Linled list in 2 parts.
		  //Now 2 list are, 1st list from start to middle and 2nd list from middle+1 to last.
		 
		  Node middle = getMiddle(startNode);
		  Node nextOfMiddle = middle.next;
		  middle.next = (null);
		 
		  //Again breaking the List until there is only 1 element in each list.
		  Node left = mergeSortLinkList(startNode);
		  Node right = mergeSortLinkList(nextOfMiddle);
		 
		  //Once complete list is divided and contains only single element, 
		  //Start merging left and right half by sorting them and passing Sorted list further. 
		  Node sortedList = mergeTwoListIterative(left, right);
		 
		  return sortedList;
		 }
		 
		 //Iterative Approach for Merging Two Sorted List
	
	 private Node mergeTwoListIterative(Node leftStart, Node rightStart) {
		 
		  Node merged=null;
		  Node temp=null;
		 
		  //To keep track of last element, so that we don't need to iterate for adding the element at last of 
		  //list when either LeftStart or rightStart is NULL.
		  Node lastAddedNode = null;
		 
		  while(leftStart!=null && rightStart!=null){
		 
		   if(leftStart.data>rightStart.data){
		    temp = new Node(rightStart.data);
		    rightStart=rightStart.next;
		 
		   }else{
		    temp = new Node(leftStart.data);
		    leftStart=leftStart.next;
		   }
		 
		   if(merged==null){
		    merged=temp;
		   }else{
		    lastAddedNode.next = temp;     
		   }
		   lastAddedNode=temp;
		  }
		 
		  if(leftStart!=null){
		   lastAddedNode.next = leftStart;
		  }else{
		   lastAddedNode.next = rightStart;
		  }
		   
		  return merged;
		 }
		 
		 private Node getMiddle(Node startNode) {
		  if(startNode==null){
		   return startNode;
		  }
		 
		  Node pointer1=startNode;
		  Node pointer2=startNode;
		  
		  while(pointer2!=null && pointer2.next!=null && pointer2.next.next!=null){
		   pointer1 = pointer1.next;
		   pointer2 = pointer2.next.next;
		 
		  }
		  return pointer1;
		 }
		 
		 private void printLinkList(Node startNode) {
		  Node temp = startNode;
		  while(temp!=null){
		   System.out.print(temp.data + " ");
		   temp = temp.next;
		  }}
		 public static void main(String[] args) {
			NodeList myList = new NodeList();
			
			myList.add(10);
			myList.add(2);
			myList.add(3);
			myList.add(4);
			myList.add(5);
			myList.add(6);
			myList.add(7);
			
			myList.printLinkList(myList.first);
			Node newFirst = myList.mergeSortLinkList(myList.first);
			
			
			myList.printLinkList(newFirst);
			
		}
}

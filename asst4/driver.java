import java.util.Scanner;

public class driver {

	public static void main(String[] args) {
     
        LinkedList llist = new LinkedList();
        
        System.out.println("How long would like a list to be?");
        Scanner inputLen = new Scanner(System.in);
        int len = inputLen.nextInt();
        int [] nums = new int [len];
        Scanner input = new Scanner(System.in);
        System.out.println("Enter " + len +" numbers: ");
        for(int i=0; i<nums.length; i++) {
        	nums[i] = input.nextInt();
        	llist.push(nums[i]);
        	
        }
        System.out.println("Your List: ");
    		llist.printList();
        
        System.out.println("Enter a numbers for search:");
        Scanner input1 = new Scanner(System.in);
        int searchNum = input1.nextInt();
        llist.search(llist.head, searchNum);
        System.out.println("Would you like to delete " + searchNum + "?  Enter yes or no: ");
        Scanner inputBol = new Scanner(System.in);
        String answer = inputBol.nextLine();
        answer.toLowerCase();
        if(answer.equals("yes") || answer.equals("y")) {
        	llist.deleteNode(searchNum);
        }else {
        	System.out.println("Enter a numbers to delete:");
        Scanner input2 = new Scanner(System.in);
        int delNum = input2.nextInt();
        llist.deleteNode(delNum);
        }
        
        
        llist.printList();
        
    }

}

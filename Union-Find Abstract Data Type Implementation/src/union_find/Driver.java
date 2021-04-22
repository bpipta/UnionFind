package union_find;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		try {
			UnionFindForest forest = new UnionFindForest();
			Scanner scan = new Scanner(new File("sampleInput2.txt"));
			int names = scan.nextInt();
			
			for(int i = 0; i < names; i++) {
				forest.makeSet(scan.next());
			}
			
			while(scan.hasNext()) {
				String s1 = scan.next().trim();
				String s2 = scan.next();
				forest.union(s1.substring(0, s1.length()-1), s2);
			}
			
			 UnionFindForest groups = new UnionFindForest();
			 System.out.println(forest.toString());
			
				
				//Read the names and add them to the data structure using makeSet(name)
		                //Read the rest of the file and perform unions
				System.out.println("Tests begin");
				assert groups.find("Barbara").equals(groups.find("Joseph")) : " Barbara and Joseph should be in the same group!";
				assert groups.find("Joseph").equals(groups.find("Patricia")) : " Joseph and Patricia should be in the same group!";
				assert groups.find("Mary").equals(groups.find("Linda")) : " Mary and Linda should be in the same group!";
				assert groups.find("Charles").equals(groups.find("William")) : " Charles and William should be in the same group!";
				
				assert !groups.find("Michael").equals(groups.find("William")) : " Michael and William should not be in the same group!";
				assert !groups.find("Joseph").equals(groups.find("Steven")) : " Joseph and Steven should not be in the same group!";
				assert !groups.find("Richard").equals(groups.find("Mary")) : " Richard and Mary should not be in the same group!";
				assert !groups.find("William").equals(groups.find("Barbara")) : " William and Barbara should not be in the same group!";

				System.out.println("Tests passed");
				
				
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}

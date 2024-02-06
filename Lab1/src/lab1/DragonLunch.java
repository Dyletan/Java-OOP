package lab1;
import java.util.Vector;

//BG B BG B BG GG

public class DragonLunch {
	Vector<Person> people;
	{
		people = new Vector<Person>();
	}
	public DragonLunch() {
		
	}
	
	public void kidnap(Person p) {
		people.add(p);
	}
	
	public String toString() {
		return "This is a scary dragon that eats people. Better keep away";
	}
	
	public boolean willDragonEatOrNot() {
	    int size = people.size();
	    int count = size;
	    
	    int maleCount = 0;

	    for (int i = 0; i < size; i++) {
	        if (people.get(i).getGender() == Gender.MALE) {
	            maleCount++;
	        } else { // if FEMALE
	            if (maleCount > 0) {
	                maleCount--;
	                count -= 2;
	            }
	        }
	    }
	    System.out.println(count);
	    return count != 0;
	}


//	public boolean willDragonEatOrNot() {
//		int size = people.size();
//	    boolean[] skip = new boolean[size];
//
//	    int count = size; // count of the elements in the vector
//
//        for (int i = 0; i < size - 1; i++) {
//        	if(skip[i]) {
//        		continue;
//        	}
//            if (people.get(i).getGender() == Gender.MALE) {
//                for (int j = i + 1; j < size - 1; j++) {
//                	if(skip[j]) {
//                		continue;
//                	}
//                    if (people.get(j).getGender() == Gender.FEMALE) {
//                        skip[i] = true;
//                        skip[j] = true;
//
//                        count -= 2;
//                        break;
//                    }
//                }
//            }
//        }
//    
//	    int i = 0;
//	    for(Person person : people) {
//	    	if(!skip[i]) {
//	    		System.out.println(person);
//	    	}
//	    	i++;
//	    }
//	    return count != 0;
//	}

}

package ga;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		LinkedList<LinkedList<Integer>> solutions = new LinkedList<LinkedList<Integer>>(); 
		LinkedList<Integer> bestSolution = new LinkedList<Integer>();
		int answer = 200, maxNum = 100, numInList = 16;
		int sum = 0, gen = 1;
		boolean check = true;
		
		for(int i = 0; i<10; i++)
		{
			solutions.add(randomAnswer(maxNum+1, numInList));
		}
		
		while(check)
		{
			System.out.println("gen " + gen);
			solutions = evolution(solutions, answer, maxNum, numInList);
			for (LinkedList<Integer> list: solutions)
			{
				sum = 0;
				for (int i:list)
				{
					sum += i;
				}
				if (sum == answer)
				{
					check = false;
					bestSolution = list;
				}
			}
		gen++;
		}
		System.out.println(bestSolution);
	}

	
	public static LinkedList<Integer> randomAnswer(int maxNum, int numInList){
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		for(int i = 0; i<numInList; i++){
			list.add((int)(Math.random()*maxNum));
		}
		
		return list;
	}
	
	public static LinkedList<LinkedList<Integer>> evolution(LinkedList<LinkedList<Integer>> list, int answer, int maxNum, int numInList){
		int sum, chance, bestChance = 10000;
		Map<Integer, LinkedList<Integer>> best = new HashMap<Integer, LinkedList<Integer>>();
		LinkedList<LinkedList<Integer>> newList = new LinkedList<LinkedList<Integer>>();
		LinkedList<Integer> temp = new LinkedList<Integer>();
		LinkedList<Integer> temp1 = new LinkedList<Integer>();
		
		for (LinkedList<Integer> l: list){
			sum = 0;
			
			for (int i: l){
				sum += i;
			}
			
			chance = Math.abs(answer-sum);
			best.put(chance, l);
		}
		
		while(best.size() > 1)
		{
			for(int i: best.keySet()){
				bestChance = Math.min(bestChance, i);
			}
			
			temp1 = best.get(bestChance);		
			best.remove(bestChance);
			bestChance = 10000;
			
			for(int i: best.keySet()){
				bestChance = Math.min(bestChance, i);
			}
			
			temp = best.get(bestChance);
			best.remove(bestChance);
			bestChance = 10000;
			
			newList.add(mix(temp, temp1, numInList));
		}
		
		while(newList.size() < 10)
		{
			newList.add(randomAnswer(maxNum+1, numInList));
		}
		
		return newList;
	}
	
	public static LinkedList<Integer> mix(LinkedList<Integer> list1, LinkedList<Integer> list2, int numInList)
	{
		LinkedList<Integer> newList = new LinkedList<Integer>();
		
		for(int i=0; i<numInList/2; i++)
			newList.add(list1.get(i));
		
		for(int i=numInList/2; i<numInList; i++)
			newList.add(list2.get(i));
		
		return newList;
	}
}

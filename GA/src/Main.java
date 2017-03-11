import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import timeWizard.TimeMagic;

public class Main {

	public static void main(String[] args) {
		TimeMagic tm = new TimeMagic("tm");
		tm.startMagic();
		
		LinkedList<LinkedList<Integer>> solutions = new LinkedList<LinkedList<Integer>>(); 
		LinkedList<Integer> bestSolution = new LinkedList<Integer>();
		int answer = 50, sum = 0, gen = 1;
		boolean check = true;
		
		for(int i = 0; i<10; i++)
		{
			solutions.add(randomAnswer());
		}
		
		while(check)
		{
			System.out.println("gen " + gen);
			solutions = evolution(solutions, answer);
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
		
		tm.stopMagic();
	}

	
	public static LinkedList<Integer> randomAnswer(){
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		for(int i = 0; i<8; i++){
			list.add((int)(Math.random()*101));
		}
		
		return list;
	}
	
	public static LinkedList<LinkedList<Integer>> evolution(LinkedList<LinkedList<Integer>> list, int answer){
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
			
			newList.add(mix(temp, temp1));
		}
		
		while(newList.size() < 10)
		{
			newList.add(randomAnswer());
		}
		
		return newList;
	}
	
	public static LinkedList<Integer> mix(LinkedList<Integer> list1, LinkedList<Integer> list2)
	{
		LinkedList<Integer> newList = new LinkedList<Integer>();
		
		for(int i=0; i<4; i++)
			newList.add(list1.get(i));
		
		for(int i=4; i<8; i++)
			newList.add(list2.get(i));
		
		return newList;
	}
}

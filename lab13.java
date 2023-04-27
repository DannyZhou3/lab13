

import java.util.ArrayList;
import java.util.StringTokenizer;

public class lab13 {
	ArrayList<Integer> intList; 
	public void readData(String filename)
	{
		intList = new ArrayList<Integer>();
		try {
            java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(filename)));
            String inn;
            while ((inn = input.readLine()) != null)
            {
               // StringTokenizer st = new StringTokenizer(inn);
               // int id = Integer.parseInt(st.nextToken());
                intList.add(Integer.valueOf(inn.trim()));
            }
            input.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
	}
	public long getTotalCount()
	{
		return intList.stream().count();
	}
	public long getOddCount()
	{
		return intList.stream().filter(x -> x % 2 == 1).count();
	}
	public long getEvenCount()
	{
		return intList.stream().filter(x -> x % 2 == 0).count();
	}
	public long getDistinctGreaterThanFiveCount()
	{
		return intList.stream().distinct().filter(x -> x > 5).count();
	}
	public Integer[] getResult1()
	{
		return intList.stream().filter(x -> x % 2 == 0).filter(x -> x > 5).filter(x -> x <50).sorted().toArray(Integer[]::new);
	}
	public Integer[] getResult2()
	{
		return intList.stream().map(x -> x*x*3).limit(50).toArray(Integer[]::new);
	}
	public Integer[] getResult3()
	{
		return intList.stream().filter(x -> x % 2 == 1).map(x -> x*2).sorted().skip(20).distinct().toArray(Integer[]::new);
	}
}


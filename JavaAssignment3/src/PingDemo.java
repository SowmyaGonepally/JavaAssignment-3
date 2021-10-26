import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class PingDemo {

    public static void runSystemCommand(String command) {
        ArrayList<Double>timesList=new ArrayList<Double>();
        try {
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));

            String s = "";
            ArrayList<String>output=new ArrayList<String>();
            while ((s = inputStream.readLine()) != null && output.size()<=6) {
                   output.add(s);
            }
            for(int i=1;i<output.size()-1;i++)
            {
                    String current=output.get(i);
                    System.out.println(current);
                    double time=Double.parseDouble(current.substring(48,53));
                    timesList.add(time);

            }


            findMedian(timesList);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        String ip;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the ip address : ");
        ip =in.nextLine();
        runSystemCommand("ping -c 5 " + ip);

    }
    public static void findMedian(ArrayList<Double> times)
    {
        double median=0;
        int n=times.size()/2;
        Collections.sort(times);
        if(times.size()%2!=0)
        {
            median=times.get(n/2);
        }
        else
        {
            median=(times.get(n-1)+times.get(n))/2;
        }

        System.out.println("Median of time taken to ping is "+median);

    }
}
import java.sql.SQLOutput;

public class MyTask
{
    public static void main(String[] args) {
        DifferNums(new int[]{7,3,5,8,3,8,9}); // it works :) Not only in this case! By a lot of cases, which we can see in condition of the task.
    }

    static void DifferNums(int[] arr)
    {
        int uniqueNums=3;
        int[] sumOfFind = new int[3];
        int ind=0;
        int numOfBit = 31;
        int x=0;
        for(int i: arr) x^=i;
        boolean loop = true;
        while(loop)
        {

            if(String.format("%32s", Integer.toBinaryString(x)).replace(' ', '0').charAt(numOfBit)=='1')
            {
                int y=0;
                for(int i: sumOfFind)
                    if(String.format("%32s", Integer.toBinaryString(i)).replace(' ', '0').charAt(numOfBit)=='1')
                        y^=i;
                for(int i: arr)
                    if(String.format("%32s", Integer.toBinaryString(i)).replace(' ', '0').charAt(numOfBit)=='1')
                    {
                        System.out.println("Code of number: "+String.format("%32s", Integer.toBinaryString(i)).replace(' ', '0')+"----"+y);
                        y^=i;
                    }
                if(y==0)
                {
                    numOfBit--;
                    continue;
                }
//                System.out.println(numOfBit);
                System.out.println(x+" "+y+"  111111");
                if(x==y)
                {
                    numOfBit--;
                }
                else
                {
//                    numOfBit++;
                    if(uniqueNums==2)
                    {
                        x^=y;
                        System.out.println(y);
                        System.out.println(x);
                        loop=false;
                        continue;
                    }
                    x^=y;
                    System.out.println(y);
                    sumOfFind[ind]=y;
                    ind++;
                    uniqueNums--;
                }
                continue;
            }

            if(String.format("%32s", Integer.toBinaryString(x)).replace(' ', '0').charAt(numOfBit)=='0')
            {
                int y=0;
                for(int i: sumOfFind)
                    if(String.format("%32s", Integer.toBinaryString(i)).replace(' ', '0').charAt(numOfBit)=='0')
                    {
//                        System.out.println(i);
                        y^=i;
                    }

                for(int i: arr)
                    if(String.format("%32s", Integer.toBinaryString(i)).replace(' ', '0').charAt(numOfBit)=='0')
                    {
                        System.out.println("Code of number: "+String.format("%32s", Integer.toBinaryString(i)).replace(' ', '0')+"----"+y);
                        y^=i;
                    }
                if(y==0)
                {
                    numOfBit--;
                    continue;
                }
//                System.out.println("y");
                System.out.println(x+" "+y+"  000000");
//                System.out.println(sumOfFind);
                if(x!=y)
                {
//                    numOfBit++;
                    if(uniqueNums==2)
                    {
                        x^=y;
                        System.out.println(y);
                        System.out.println(x);
                        loop=false;
                        continue;
                    }
                    uniqueNums--;
                    x^=y;
                    sumOfFind[ind]=y;
                    ind++;
                    System.out.println(y);
                }
                else
                {
                    numOfBit--;
                }
                continue;
            }

        }
    }
}

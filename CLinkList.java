
public class CLinkList {
	public long[] Fib(int n) {
		if(n<=1) {
			long[] answer= {n,0};
			return answer;
		}
		
		else {
			long[]temp=Fib(n-1);
			long [] answer= {temp[0]+temp[1]+temp[0]};
			return answer;			
		}
		
	}
public static int pow(int v,int n) {
	if(n==0)
		return 1;
	else if(n%2==1) {
		int y=pow(v,(n-1)/2);
		return v*y*y;
	}
	else {
		int y= pow(v,n/2);
		return v*y*y;
	}
	
}
public static void main(String [] args) {
System.out.println(pow(2,7));	
}
}

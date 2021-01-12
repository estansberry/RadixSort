public class Radix{
  public static void main(String args[]){
    System.out.println(nth(123,0));
    System.out.println(nth(12345,1));
    System.out.println(nth(123,2));
  }
  public static int nth(int n, int col){
    int newnum = 0;
    for(int i = 0; i <= col; i++){
      newnum = n % 10;
      n = n / 10;
    }return(newnum);
  }
  public static int length(int n){
    return(n);
  }

}

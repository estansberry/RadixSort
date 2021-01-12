public class Radix{
  public static int nth(int n, int col){
    int newnum = 0;
    for(int i = 0; i <= col; i++){
      newnum = n % 10;
      n = n / 10;
    }return(newnum);
  }
  public static int length(int n){
    n = Math.abs(n);
    int len = 0;
    if(n == 0){
      return(1);
    }
    while(n > 0){
      n = n /10;
      len += 1;
    }return(len);
  }

}

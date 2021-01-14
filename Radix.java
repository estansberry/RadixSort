public class Radix{
  public static int nth(int n, int col){
    n = Math.abs(n);
    if(col != 0 & n/(10^(col - 1)) < 1){
      return(0);
    }
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
  public static void merge(SortableLinkedList original, SortableLinkedList[]buckets){
    for(int i = 0; i < buckets.length; i ++){
      original.extend(buckets[i]);
    }
  }

  public static void radixSortSimple(SortableLinkedList data){
    int largest = 1;
    SortableLinkedList[] bucket = new SortableLinkedList[10];
    for(int i = 0; i < 10; i++){
      bucket[i] = new SortableLinkedList();
    }for(int i = 0; i < largest; i ++){
      if(i == 0){
        while(data.size() > 0){
          if(length(data.get(0)) > largest){
            largest = length(data.get(0));
          }bucket[0].add(data.get(0));
          data.remove(0);
        }
      }merge(data, bucket);
      while(data.size() > 0){
        int val = data.get(0);
        int digit = nth(val, i);
        bucket[digit].add(val);
        data.remove(0);
      }merge(data, bucket);
    }
  }

  public static void radixSort(SortableLinkedList data){
    int largest = 1;
    SortableLinkedList[] positives = new SortableLinkedList[10];
    for(int i = 0; i < 10; i++){
      positives[i] = new SortableLinkedList();
    }SortableLinkedList[] negatives = new SortableLinkedList[10];
    for(int i = 0; i < 10; i++){
      negatives[i] = new SortableLinkedList();
    }for(int i = 0; i < largest; i ++){
      if(i == 0){
        while(data.size() > 0){
          if(length(data.get(0)) > largest){
            largest = length(data.get(0));
          }positives[0].add(data.get(0));
          data.remove(0);
        }
      }merge(data, positives);
      while(data.size() > 0){
        int val = data.get(0);
        int digit = nth(val, i);
        if(val < 0){
          negatives[9 - digit].add(val);
        }else{
          positives[digit].add(val);
        }data.remove(0);
      }merge(data, negatives);
      merge(data, positives);
    }
  }
}

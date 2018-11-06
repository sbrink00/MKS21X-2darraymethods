public class ArrayMethods{

  public static void main(String[]args){
    //just some test cases I ran
    int[][] ary1 = new int[][]{{-4, -6, -9},{9, 6, -98}, {4, -23}};
    int[][] ary2 = new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
    System.out.println(rowSum(ary1, 1));
    System.out.println(rowSum(ary1, 2));
    System.out.println(columnSum(ary1, 2));
    System.out.println(toString(allRowSums(ary1)));
    System.out.println(toString(allColSums(ary1)));
    System.out.println(isRowMagic(ary1));
    System.out.println(isRowMagic(ary2));
    System.out.println(isColumnMagic(ary1));
    System.out.println(isColumnMagic(ary2));
  }


  public static int rowSum(int[][] ary, int x){
    int sum = 0;
    if (x >= ary.length || x < 0){
      throw new IndexOutOfBoundsException("the row referenced does not exist. x must be >= 0 and < length");
    }
    else for (int idx = 0; idx < ary[x].length; idx ++){
      sum +=ary[x][idx];
    }
    return sum;
  }

  public static int columnSum(int[][] ary, int x){
    int total = 0;
    for (int idx = 0; idx < ary.length; idx ++){
      if (x < ary[idx].length) total += ary[idx][x];
    }
    return total;
  }

  public static int[] allRowSums(int[][] ary){
    int[] output = new int[ary.length];
    for (int idx = 0; idx < ary.length; idx ++){
      output[idx] = rowSum(ary, idx);
    }
    return output;
  }

  public static int[] allColSums(int[][] ary){
    int finalLen = 0;
    for (int idx = 0; idx < ary.length; idx ++){
      if (ary[idx].length > finalLen) finalLen = ary[idx].length;
    }
    int[] output = new int[finalLen];
    for (int idx = 0; idx < output.length; idx ++){
      output[idx] = columnSum(ary, idx);
    }
    return output;
  }

  public static boolean isRowMagic(int[][] ary){
    boolean output = true;
    for (int idx = 0; idx < ary.length - 1; idx ++){
      if (rowSum(ary, idx) != rowSum(ary, idx + 1)) output = false;
    }
    return output;
  }

  public static boolean isColumnMagic(int[][] ary){
    boolean output = true;
    int finalLen = 0;
    for (int idx = 0; idx < ary.length; idx ++){
      if (ary[idx].length > finalLen) finalLen = ary[idx].length;
    }
    for (int idx = 0; idx < finalLen - 1; idx ++){
      if (columnSum(ary, idx) != columnSum(ary, idx + 1)) output = false;
    }
    return output;
  }

  public static String toString(int[] ary){
    String output = "[";
    for (int idx = 0; idx < ary.length; idx ++){
      output += ary[idx] + ", ";
    }
    return output.substring(0, output.length() - 1) + "]";
  }
}

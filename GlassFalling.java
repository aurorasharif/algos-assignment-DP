/**
 * Glass Falling
 */
public class GlassFalling {

  // Do not change the parameters!
  public int glassFallingRecur(int floors, int sheets) {
    // Fill in here and change the return
    if(sheets==1) return floors;
    if(floors==0) return 0;
    if(floors==1) return 1;

    int minimum=Integer.MAX_VALUE;
    for(int x=1;x<=floors;x++) minimum=Math.min(minimum,(1+ Math.max(glassFallingRecur(sheets,floors-x), glassFallingRecur(sheets-1,x-1))));

    return minimum;
  }

  // Optional:
  // Pick whatever parameters you want to, just make sure to return an int.
  public int glassFallingMemoized() {
    // Fill in here and change the return
    return 0;
  }

  // Do not change the parameters!
  public int glassFallingBottomUp(int floors, int sheets) {
     // Fill in here and change the return
    if(floors == 0 || floors == 1 || sheets == 1) return floors;
    int[][] table = new int[sheets+1][floors+1];  
      for(int i = 1; i <= sheets; i++) {
          table[i][0] = 0;
          table[i][1] = 1;
      } for(int i = 1; i <= floors; i++) {
          table[1][i] = i;
      } for(int i = 2; i <= sheets; i++) {
          for(int j = 2; j <= floors; j++){
              table[i][j] = Integer.MAX_VALUE;
              for(int k = 1; k <= j; k++){
              int res = 1 + Math.max(table[i-1][k-1], table[i][j-k]); 
                   if (res < table[i][j]) {
                   table[i][j] = res; 
                   }
              }
          }
       } return table[sheets][floors];   
  }


  public static void main(String args[]){
      GlassFalling gf = new GlassFalling();

      // Do not touch the below lines of code, and make sure
      // in your final turned-in copy, these are the only things printed
      int minTrials1Recur = gf.glassFallingRecur(27, 2);
      int minTrials1Bottom = gf.glassFallingBottomUp(27, 2);
      int minTrials2Recur = gf.glassFallingRecur(100, 3);
      int minTrials2Bottom = gf.glassFallingBottomUp(100, 3);
      System.out.println(minTrials1Recur + " " + minTrials1Bottom);
      System.out.println(minTrials2Recur + " " + minTrials2Bottom);
  }
}

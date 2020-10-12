public class exe1 {
   public static void drawTriangle(int n){
      int col = 0;
      int row = 0;
      while(row < n){
         while(col < row){
            System.out.print('*');
            col = col + 1;
         }
         System.out.println('*');
         row = row + 1;
         col = 0;
      }
   }
   public static void main(String[] args) {
      drawTriangle(10);
   }
}
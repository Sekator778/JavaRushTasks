public class Sobesedovanie {
    public static void main(String[] args) {
        try{
            return;
//            System.exit(0);
//            System.out.println("try block");
        }catch (Exception e){
            System.out.println("catch block");
        }finally {
            System.out.println("finally block");
        }
    }
}

public class Reflexx {
    public static void main(String[] args) {
//        String s = "12345678";
//        String sx = null;
//        int l = s.length();
//        int x1, x2;
//        int centr = 0;
//        if (l%2 == 0){
//             x1 = l/2;
//             x2 = l/2+1;
//            sx  = s.substring(0, x1);
//
//        }
//        else {
//            x1 = x2 = l/2;
//            centr = l/2+1;
//        }
//
//        System.out.println(x1);
//        System.out.println(x2);
//        System.out.println("rezultat " + sx);

        String x = "myLongString";
        String y = x.substring(2,6);
        String z = x.substring(0,3);
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);

        String s = "Good news everyone!";
        int index = s.indexOf("ne", 5);
        System.out.println(index);
    }
}

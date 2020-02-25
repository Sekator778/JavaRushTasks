public class Test1 {
//    public static void main(String[] args) throws Exception{
//        DataInputStream dis = new DataInputStream(new FileInputStream("/home/sekator/Java/JavaRushTasks/My Solution/src/file1.txt"));
//       byte[] buffer = new byte[51];
//
//       while (dis.available() != 0) {
//           int count = dis.read(buffer);
//
//           if (count > 0) {
//               System.out.println(new String(buffer));
//           }
//       }

//    }


        static void methodWideVar(int i1, int i2) {
            System.out.println("int int");
        }

        static void methodWideVar(Integer... i) {
            System.out.println("Integers");
        }

        public static void main( String[] args) {
            short shVal1 = 25;
            short shVal2 = 35;
            methodWideVar( shVal1, shVal2);

            Integer istInt = new Integer(1);
            Integer secondInt = new Integer(1);

            if (istInt == secondInt) {
                System.out.println("both one are equal");

            } else {
                System.out.println("Both one are not equal");
            }
        }
    }



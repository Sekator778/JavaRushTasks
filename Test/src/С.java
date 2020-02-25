class C {
    public static void main(String[] args) {
        Single single = Single.getSingle();
        Single single2 = Single.getSingle();
    }

    class childSingle extends Single {}

    static class Single {
        private Single() {
            System.out.println("make");
        }

        static Single single;

        public static Single getSingle() {
            if (single == null) {
                single = new Single();
            }
            return single;
        }
    }
}

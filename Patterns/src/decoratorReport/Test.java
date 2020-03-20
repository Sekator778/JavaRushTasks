package decoratorReport;

public class Test {
    public static void main(String[] args) {
        Report report1 = new ReportForIt(new ReportImpl());
        Report report = new ReportForIt(new ReportForAccount(new ReportImpl()));
        System.out.println(report.generate());
    }
}

package decoratorReport;

public class ReportForAccount extends ReportDecorator {
    public ReportForAccount(Report report) {
        super(report);
    }

    @Override
    public String generate() {
        return super.generate() + " report for accounter";
    }
}

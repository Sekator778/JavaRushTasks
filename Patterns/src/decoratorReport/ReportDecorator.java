package decoratorReport;

public abstract class ReportDecorator implements Report {
    private Report report;

    public ReportDecorator(Report report) {
        this.report = report;
    }

    @Override
    public String generate() {
        return report.generate();
    }
}

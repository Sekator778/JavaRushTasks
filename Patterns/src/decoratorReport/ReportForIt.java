package decoratorReport;

public class ReportForIt extends ReportDecorator {
    public ReportForIt(Report report) {
        super(report);
    }

    @Override
    public String generate() {
        return super.generate() + " report IT + ";
    }
}

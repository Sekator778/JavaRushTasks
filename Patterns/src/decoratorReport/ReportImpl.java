package decoratorReport;

public class ReportImpl implements Report {
    @Override
    public String generate() {
        return "report start";
    }
}

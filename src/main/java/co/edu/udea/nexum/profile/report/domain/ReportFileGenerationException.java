package co.edu.udea.nexum.profile.report.domain;

import co.edu.udea.nexum.profile.common.domain.exception.NexumException;

public class ReportFileGenerationException extends NexumException {
    public ReportFileGenerationException(String message) {
        super(message);
    }

    public ReportFileGenerationException(String message, Throwable e) {
        super(message, e);
    }
}

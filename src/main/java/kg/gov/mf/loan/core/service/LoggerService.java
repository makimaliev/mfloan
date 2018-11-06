package kg.gov.mf.loan.core.service;

import kg.gov.mf.loan.core.model.MFLog;

public interface LoggerService extends GenericService<MFLog>
{
    void addLog(String user, String entity, String action, String ip);
}

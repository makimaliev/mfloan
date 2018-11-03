package kg.gov.mf.loan.service;

import kg.gov.mf.loan.model.MFLog;

public interface LoggerService extends GenericService<MFLog>
{
    void addLog(String user, String entity, String action, String ip);
}

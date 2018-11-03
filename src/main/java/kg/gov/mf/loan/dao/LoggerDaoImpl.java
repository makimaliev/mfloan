package kg.gov.mf.loan.dao;

import kg.gov.mf.loan.model.MFLog;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LoggerDaoImpl extends GenericDaoImpl<MFLog> implements LoggerDao
{
}

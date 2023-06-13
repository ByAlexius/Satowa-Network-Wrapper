package net.byalexius.snapi.service.impl;

import net.byalexius.snapi.internal.common.Constants;
import net.byalexius.snapi.internal.model.ReportModel;
import net.byalexius.snapi.service.interfaces.IReport;
import net.byalexius.snapi.service.logic.ReportLogic;

import java.util.List;

public class ReportImpl implements IReport {
    ReportLogic reportLogic = new ReportLogic();

    @Override
    public List<ReportModel> getReports() {
        return reportLogic.getReports(0, null, null, null, null, true);
    }

    @Override
    public List<ReportModel> getReports(long id) {
        return reportLogic.getReports(id, null, null, null, null, false);
    }

    @Override
    public List<ReportModel> getReportsViaReporterId(String reporter_id) {
        return reportLogic.getReports(0, reporter_id, null, null, null, false);
    }

    @Override
    public List<ReportModel> getReportsViaReportedId(String reported_uid) {
        return reportLogic.getReports(0, null, reported_uid, null, null, false);
    }

    @Override
    public List<ReportModel> getReports(Constants.Platform platform) {
        return reportLogic.getReports(0, null, null, platform, null, false);
    }

    @Override
    public List<ReportModel> getReports(Boolean status) {
        return reportLogic.getReports(0, null, null, null, status, false);
    }

    @Override
    public ReportModel getReport(long id, String reporter_id, String reported_uid, Constants.Platform platform, boolean status) {
        return reportLogic.getReports(id, reporter_id, reported_uid, platform, status, false).get(0);
    }
}

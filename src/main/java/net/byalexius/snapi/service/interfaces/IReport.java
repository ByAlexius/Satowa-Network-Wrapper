package net.byalexius.snapi.service.interfaces;

import net.byalexius.snapi.internal.common.Constants;
import net.byalexius.snapi.internal.model.ReportModel;

import java.util.List;

/**
 * This is the Interface for the <a href="https://api.satowa-network.eu/v3/reports/">Report API</a>
 * <br>If you want to get data from the Reports database you need to get it from here
 * @author <a href="https://www.github.com/ByAlexius">Alexander Rziha</a>
 */
public interface IReport {

    List<ReportModel> getReports();

    List<ReportModel> getReports(long id);

    List<ReportModel> getReportsViaReporterId(String reporter_id);

    List<ReportModel> getReportsViaReportedId(String reported_uid);

    List<ReportModel> getReports(Constants.Platform platform);

    List<ReportModel> getReports(Boolean status);

    ReportModel getReport(long id, String reporter_id, String reported_uid, Constants.Platform platform, boolean status);

}

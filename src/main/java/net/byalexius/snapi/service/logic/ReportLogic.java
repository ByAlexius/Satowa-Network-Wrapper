package net.byalexius.snapi.service.logic;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.moandjiezana.toml.Toml;
import net.byalexius.snapi.internal.common.Constants;
import net.byalexius.snapi.internal.helper.LoggingHelper;
import net.byalexius.snapi.internal.helper.TOMLHelper;
import net.byalexius.snapi.internal.model.ReportModel;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains the logic for the {@link net.byalexius.snapi.service.impl.ReportImpl} Implementation
 * @author <a href="https://www.github.com/ByAlexius">Alexander Rziha</a>
 */
public class ReportLogic {

    /**
     * The config File where the apikey is stored
     */
    private final Toml config = TOMLHelper.readConfig("satowa.toml");

    /**
     * <p>This method gets all Reports from the <a href="https://api.satowa-network.eu/v3/reports/">API</a> and filters them</p>
     * @since 0.0.1-SNAPSHOT
     * @param id This is used to filter the responses with the ID of the Report
     * @param reporter_Id This is used to filter the responses with the ID of the Person that Reported
     * @param reported_Id This is used to filter the responses with the ID of the Person that was Reported
     * @param platform This is used to filter the responses based on the Platform that the Reports are on
     * @param status This is used to filter the responses based on the Current Status
     * @param getAll When this is set to true all Reports are getting returned
     * @return a List of {@link net.byalexius.snapi.internal.model.ReportModel}'s
     */
    public List<ReportModel> getReports(long id, String reporter_Id, String reported_Id, Constants.Platform platform, Boolean status, boolean getAll) {
        List<ReportModel> result = new ArrayList<>();

        String apikey = config != null ? config.getString("apikey") : null;

        OkHttpClient client = new OkHttpClient().newBuilder()
            .build();
        Request request;

        if (apikey != null && !apikey.equals("")) {
            request = new Request.Builder()
                    .url("https://api.satowa-network.eu/v3/reports/")
                    .addHeader("x-api-key", apikey)
                    .method("GET", null)
                    .build();
        } else {
            request = new Request.Builder()
                    .url("https://api.satowa-network.eu/v3/reports/")
                    .method("GET", null)
                    .build();
        }

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                JsonArray jsonArray = JsonParser.parseString(responseBody).getAsJsonArray();
                for (JsonElement jsonElement : jsonArray) {
                    ReportModel reportModel = new ReportModel();

                    Constants.Platform _platform = null;

                    long rId = jsonElement.getAsJsonObject().get("id").getAsLong();
                    String reporter_id = jsonElement.getAsJsonObject().get("reporter_id").getAsString();
                    String reported_uid = jsonElement.getAsJsonObject().get("reported_uid").getAsString();
                    String rPlatform = jsonElement.getAsJsonObject().get("platform").getAsString();
                    String rTxt = jsonElement.getAsJsonObject().get("report_txt").getAsString();
                    boolean rStatus = jsonElement.getAsJsonObject().get("status").getAsBoolean();

                    switch (rPlatform.toUpperCase()) {
                        case "DISCORD" -> _platform = Constants.Platform.DISCORD;
                        case "MINECRAFT" -> _platform = Constants.Platform.MINECRAFT;
                    }

                    if (id > 0) {
                        if (rId != id) {
                            continue;
                        }
                        reportModel.setId(rId);
                    }

                    if (reporter_Id != null) {
                        if (!reporter_id.equals(reporter_Id)) {
                            continue;
                        }
                        reportModel.setReporter_id(reporter_id);
                    }

                    if (reported_Id != null) {
                        if (!reported_uid.equals(reported_Id)) {
                            continue;
                        }
                        reportModel.setReported_uid(reported_Id);
                    }

                    if (platform != null) {
                        if (_platform != platform) {
                            continue;
                        }
                        reportModel.setPlatform(_platform);
                    }

                    if (status != null) {
                        if (status != rStatus) {
                            continue;
                        } else {
                            reportModel.setStatus(rStatus);
                        }
                    }

                    if (getAll) {
                        reportModel.setId(rId);
                        reportModel.setReporter_id(reporter_id);
                        reportModel.setReported_uid(reported_Id);
                        reportModel.setPlatform(_platform);
                        reportModel.setInformation(rTxt);
                        reportModel.setStatus(rStatus);
                        result.add(reportModel);
                    } else if (reportModel.getId() > 0) {
                        reportModel.setReporter_id(reporter_id);
                        reportModel.setReported_uid(reported_Id);
                        reportModel.setPlatform(_platform);
                        reportModel.setInformation(rTxt);
                        reportModel.setStatus(rStatus);
                        result.add(reportModel);
                    } else if (reportModel.getReporter_id() != null && !reportModel.getReporter_id().equals("")) {
                        reportModel.setId(rId);
                        reportModel.setReported_uid(reported_Id);
                        reportModel.setPlatform(_platform);
                        reportModel.setInformation(rTxt);
                        reportModel.setStatus(rStatus);
                        result.add(reportModel);
                    } else if (reportModel.getReported_uid() != null && !reportModel.getReported_uid().equals("")) {
                        reportModel.setId(rId);
                        reportModel.setReporter_id(reporter_id);
                        reportModel.setPlatform(_platform);
                        reportModel.setInformation(rTxt);
                        reportModel.setStatus(rStatus);
                        result.add(reportModel);
                    } else if (reportModel.getPlatform() != null) {
                        reportModel.setId(rId);
                        reportModel.setReporter_id(reporter_id);
                        reportModel.setReported_uid(reported_Id);
                        reportModel.setInformation(rTxt);
                        reportModel.setStatus(rStatus);
                        result.add(reportModel);
                    } else if (status != null) {
                        reportModel.setId(rId);
                        reportModel.setReporter_id(reporter_id);
                        reportModel.setReported_uid(reported_Id);
                        reportModel.setInformation(rTxt);
                        reportModel.setPlatform(_platform);
                        result.add(reportModel);
                    }
                }
            } else {
                LoggingHelper.Log(this.getClass(), "Request was not successful. Response code: " + response.code(), Constants.LogLevel.ERROR);
            }
        } catch (IOException e) {
            LoggingHelper.LogError(this.getClass(), e, Constants.LogLevel.ERROR);
        }

        return result;
    }

}

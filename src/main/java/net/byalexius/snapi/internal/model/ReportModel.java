package net.byalexius.snapi.internal.model;

import lombok.Getter;
import lombok.Setter;
import net.byalexius.snapi.internal.common.Constants;

public class ReportModel {

    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private String reporter_id;

    @Getter
    @Setter
    private String reported_uid;

    @Getter
    @Setter
    private Constants.Platform platform;

    @Getter
    @Setter
    private String information;

    @Getter
    @Setter
    private Boolean status;
}

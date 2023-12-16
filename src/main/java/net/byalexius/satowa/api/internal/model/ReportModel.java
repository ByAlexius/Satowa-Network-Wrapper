package net.byalexius.satowa.api.internal.model;

import lombok.Getter;
import lombok.Setter;
import net.byalexius.satowa.api.internal.common.Constants;

/**
 * This is the Model that Reports that get Requested are assigned
 * @author <a href="https://www.github.com/ByAlexius">Alexander Rziha</a>
 */
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

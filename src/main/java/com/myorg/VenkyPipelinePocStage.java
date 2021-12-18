package com.myorg;

import software.amazon.awscdk.core.Stage;
import software.constructs.Construct;
import software.amazon.awscdk.core.StageProps;

public class VenkyPipelinePocStage extends Stage {
    public VenkyPipelinePocStage(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public VenkyPipelinePocStage(final Construct scope, final String id, final StageProps props) {
        super(scope, id, props);

        new VenkyJavaPocStack(this, "VenkyJavaPocStack");
        //new PocSendgridWebhookStack(this, "SendgridWebbhookWebService");
    }
}
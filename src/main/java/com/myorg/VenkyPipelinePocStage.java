package com.myorg;

import software.amazon.awscdk.core.Stage;
import software.constructs.Construct;
import software.amazon.awscdk.core.StageProps;
import software.amazon.awscdk.core.StackProps;
import software.amazon.awscdk.core.Environment;

public class VenkyPipelinePocStage extends Stage {
    public VenkyPipelinePocStage(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public VenkyPipelinePocStage(final Construct scope, final String id, final StageProps props) {
        super(scope, id, props);

        new VenkyJavaPocStack(this, "VenkyJavaPocStack", StackProps.builder()
        .env(new Environment.Builder()
                .account("821518525729")
                .region("us-east-1")
                .build())
        .build());
        //new PocSendgridWebhookStack(this, "SendgridWebbhookWebService");
    }
}
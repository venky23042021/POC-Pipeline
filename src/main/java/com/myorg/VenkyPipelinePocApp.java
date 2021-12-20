package com.myorg;

import software.amazon.awscdk.core.App;
import software.amazon.awscdk.core.Environment;
import software.amazon.awscdk.core.StackProps;

public class VenkyPipelinePocApp {
    public static void main(final String[] args) {
        App app = new App();

        final VenkyPipelinePocStack pipelineStack = new VenkyPipelinePocStack(app, "VenkyPipelinePocStack", StackProps.builder()
                .env(new Environment.Builder()
                        .account("821518525729")
                        .region("us-east-1")
                        .build())
                .build());

        app.synth();
    }
}
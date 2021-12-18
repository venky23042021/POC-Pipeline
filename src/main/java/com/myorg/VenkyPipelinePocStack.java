package com.myorg;

import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.core.Stack;
import software.amazon.awscdk.core.StackProps;
import software.amazon.awscdk.services.sqs.Queue;
import software.amazon.awscdk.core.Duration;
import software.amazon.awscdk.pipelines.CodePipeline;
import software.amazon.awscdk.pipelines.CodePipelineSource;
import software.amazon.awscdk.pipelines.ConnectionSourceOptions;
import software.amazon.awscdk.pipelines.ShellStep;

import java.util.Arrays;

public class VenkyPipelinePocStack extends Stack {
    public VenkyPipelinePocStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public VenkyPipelinePocStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        // The code that defines your stack goes here

        // example resource
         /*final Queue queue = Queue.Builder.create(this, "VenkyPipelinePocQueue")
                 .visibilityTimeout(Duration.seconds(300))
                 .build();*/

        CodePipeline pipeline = CodePipeline.Builder.create(this, "pipeline")   
             .pipelineName("VenkyPipelinePOC")
             .synth(ShellStep.Builder.create("Synth")
                /*.input(CodePipelineSource.gitHub("<owner>/<repo>", "main"))*/
                .input(CodePipelineSource.connection("venky23042021/POC-Java", "main", ConnectionSourceOptions.builder()
                         .connectionArn("arn:aws:codestar-connections:us-east-1:821518525729:connection/d5127fd5-7f1f-4ab2-a072-a60dd3ae0f41")
                         .build()))
                .commands(Arrays.asList("mvn clean install", "npx cdk synth"))
                .build())
             .build();
    }
}
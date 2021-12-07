package com.myorg;

import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.core.Stack;
import software.amazon.awscdk.core.StackProps;
import software.amazon.awscdk.core.Duration;

import software.amazon.awscdk.services.sns.Topic;
import software.amazon.awscdk.services.sqs.Queue;
import software.amazon.awscdk.services.sns.subscriptions.SqsSubscription;

import software.amazon.awscdk.services.s3.Bucket;

import software.amazon.awscdk.services.lambda.Code;
import software.amazon.awscdk.services.lambda.Function;
import software.amazon.awscdk.services.lambda.Runtime;
import software.amazon.awscdk.services.apigateway.LambdaRestApi;

public class VenkyJavaPocStack extends Stack {
    public VenkyJavaPocStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public VenkyJavaPocStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        final Function venkyFunctionPOC = Function.Builder.create(this, "POCHandlerStack")
        .runtime(Runtime.NODEJS_14_X) //NODEJS_14_X,JAVA_8, This is the execution evn, can be set to Java, Python, nodejs, etc
        .code(Code.fromAsset("lambda"))
        .handler("venkyPoc.handler")//PocLambdaHandler, com.myorg.PocLambdaHandler::handleRequest
        .build();

        final LambdaRestApi apigatewayPoc = LambdaRestApi.Builder.create(this, "Endpoint")
        .handler(venkyFunctionPOC)
        .build();
    }
}
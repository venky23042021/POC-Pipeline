// package com.myorg;

// import software.amazon.awscdk.core.App;
// import software.amazon.awscdk.assertions.Template;
// import java.io.IOException;

// import java.util.HashMap;

// import org.junit.jupiter.api.Test;

// example test. To run these tests, uncomment this file, along with the
// example resource in java/src/main/java/com/myorg/VenkyPipelinePocStack.java
// public class VenkyPipelinePocTest {

//     @Test
//     public void testStack() throws IOException {
//         App app = new App();
//         VenkyPipelinePocStack stack = new VenkyPipelinePocStack(app, "test");

//         Template template = Template.fromStack(stack);

//         template.hasResourceProperties("AWS::SQS::Queue", new HashMap<String, Number>() {{
//           put("VisibilityTimeout", 300);
//         }});
//     }
// }

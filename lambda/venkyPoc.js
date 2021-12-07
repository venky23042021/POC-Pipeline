exports.handler = async function(event) {
    console.log("request:", JSON.stringify(event, undefined, 2));
    return {
      statusCode: 200,
      headers: { "Content-Type": "text/plain" },
      body: `This is a confirmation message that the Lambda is hit and its working ${event.path}.\nThe payload passed was : ${JSON.stringify(event.body)}`
    };
  };
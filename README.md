# simpleGRPCLoadTest

It's a simple gRPC load test project with using Jmeter-Java-DSL.
Jmeter-Java-DSL does not support the gRPC protocol, in this project it uses the JSR223-controller.

<h3>Algorithm</h3>

JSR223 controller runs the Groovy code, which executes shell command and send gRPC request.
Later this script catches the responses from gRPC-server and writes to one of two files: success.txt and error.txt.

It writes the result as Success if variable sout in Shell.groovy is not empty. In other cases, it writes the result as Fail.
If request is failed, it throws the exception and JSR223 controller is fall.

Folder Examples have a few of examples from https://grpc.io/docs/languages/kotlin/quickstart/
Folder build has the compiled client files for sending requests.


<h3>Basic running:</h3>
- run the hello-world-server, grafana and influxDB in the docker image:
```shell
docker-compose -f docker-compose.yml up d
```
- run fun testPerformance() (path:src/test/kotlin/qa/simplegrpcloadtest/GrpcLoadTest)

Advantages:
- it is possible to load the simple gRPC server
- the Jmeter report(.jtl) is generated

Disadvantages:
- need to manually replace the client build

Future works:
- encapsulate gRPC request generation in a class and pass the object of class to JSR223 controller
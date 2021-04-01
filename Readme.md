# FRAMEWORK

Java, rest assured, and junit 5

# TEST

to run tests

`./gradlew test`

to continuously run tests during tests development

`./gradlew -t test`


# TEST DOCUMENTATION

to start with, we are using gradle's default generated reports

to view the detailed test report, view
build/reports/tests/test/index.html
in root dir

as part of CI pipeline, we upload the report as artefacts to circleCI. 

https://5-353692340-gh.circle-artifacts.com/0/test-reports/index.html


# FORMAT

to format the code 

'./gradlew spotlessApply'

you can also configure your IDE to format on file save
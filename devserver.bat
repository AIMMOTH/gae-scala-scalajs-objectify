@ECHO OFF

echo APPENGINE_SDK_HOME located at:

echo %APPENGINE_SDK_HOME%

%APPENGINE_SDK_HOME%/bin/dev_appserver -a localhost -p 8080 src/main/webapp --jvm_flag=-agentlib:jdwp=transport=dt_socket,address=8000,server=y,suspend=n

#!/bin/sh


exec java ${JAVA_OPTS}  -cp /smart/resources/:/smart/classes/:/smart/libs/* "com.smart.demo.DemoApplication"  "$@"

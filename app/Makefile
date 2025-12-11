run-dist:
	./build/install/app/bin/app

build-dist:
	./gradlew clean
	./gradlew installDist

build-and-run-dist:
	./gradlew clean
	./gradlew installDist
	./build/install/app/bin/app -h

build:
	./gradlew clean build installDist checkstyleMain checkstyleTest test

.PHONY: build

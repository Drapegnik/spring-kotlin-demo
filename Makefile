.PHONY: build
build:
	./gradlew clean build

.PHONY: run
run:
	./gradlew bootRun

.PHONY: lintCheck
lintCheck:
	./gradlew ktlintCheck


.PHONY: lintFormat
lintFormat:
	./gradlew ktlintFormat

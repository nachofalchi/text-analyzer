# Variables
PROJECT_NAME = text-analyzer
MAIN_CLASS = com.project.analyzer.BasicTextAnalyzer # Replace with your main class
JAVA_HOME ?= /usr/lib/jvm/java-17-openjdk-amd64 # Set your JAVA_HOME if needed

# Targets
all: compile run

compile:
	@echo "Compiling..."
	@mvn compile

run: compile
	@echo "Running..."
	@mvn exec:java -Dexec.mainClass=$(MAIN_CLASS)

clean:
	@echo "Cleaning..."
	@mvn clean      

.PHONY: all compile run clean

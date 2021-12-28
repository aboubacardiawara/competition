all: compile testCompile jar
##################################################
#					VARIABLES					 #
##################################################

TARGET=classes
TEST_TARGET=classes
CC=javac
RUN=java
JAR_NAME=League.jar Tournament.jar Master.jar
FLAG=-Xlint:unchecked
BASE_MANIFEST=manifest
SOURCES = competition/competition/*.java \
		  competition/match/*.java \
		  competition/util/*.java \
		  competition/exception/*.java \
		  competition/rule/*.java \
		  competition/observer/*.java \
		  competition/*.java

SRC_TEST = test/competition/competition/*.java \
		  test/competition/match/*.java \
		  test/competition/*.java \
		  test/competition/observer/*.java

JUNIT_JAR=junit-platform-console-standalone-1.8.1.jar
#####################################################
#			Generer les executables					#
#####################################################
compile:
	@echo "compilation en cours ..."
	@cd src && javac $(FLAG) ${SOURCES} -d ../classes && cd ..
	@echo "compilation terminée !"

#####################################################
#		Generer les executables de tests			#
#####################################################
testCompile:
	@echo "compilation des tests en cours ..."
	@javac -d $(TEST_TARGET) -cp classes:$(JUNIT_JAR) $(SRC_TEST)
	@echo "compilation terminée"



#####################################################
#					Executer les tests				#
#####################################################
runTest:
	@ java -jar junit-platform-console-standalone-1.8.1.jar --class-path $(TEST_TARGET) --scan-class-path


#####################################################
#					Generer le jar					#
#####################################################
jar:
	@ make jarLeague
	@ make jarTournament
	@ make jarMaster


jarLeague: src/competition/MainLeague.java
	@ cd classes && jar cvfm ../League.jar ../$(BASE_MANIFEST)/manifest-League competition
	@ cd ../

jarTournament: src/competition/MainTournament.java
	@ cd classes && jar cvfm ../Tournament.jar ../$(BASE_MANIFEST)/manifest-Tournament competition
	@ cd ../

jarMaster: src/competition/MainMaster.java
	@ cd classes && jar cvfm ../Master.jar ../$(BASE_MANIFEST)/manifest-Master competition
	@ cd ../



#####################################################
#			Generer la documentation				#
#####################################################
doc:
	@ echo "generation de la documentation ..."
	@ cd src && javadoc -d ../docs -subpackages competition
	@ echo -e "${GREEN}document généré$(`tput sgr 0`)"

#####################################################
#	Nettoyer les fichiers facilement generables		#
#####################################################
clean:
	@ echo "suppression en cours ..."
	@rm -rf docs/*
	@rm -rf $(TARGET)
	@rm -rf $(TEST_TARGET)
	@rm -f $(JAR_NAME)
	@ echo "suppression terminée"
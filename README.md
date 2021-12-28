# Competition
# Contains
- [Preface](#Preface)
- [How to build](#Installing)
- [Element de conception](#elements-de-conception)


# Preface
This project concerns the practice of object-oriented design. It is divided into 3 parts (3 versions) and allows to implement the addition of new functionality on an existing base by using various concepts such as (abstraction, design patterns).
It also concerns the pratice of clean code and sofware testing and team work.

## Team
- Aboubacar DIAWARA
- Abdoulkader MOUSSA MOHAMED

## Progress and Design
<a href="progress.md">click here</a> to see the progress and the design.

<!-- ![astuce](assets/astuce.png)-->


# Installing
## Linux
- you can directly download it graphicaly.

- you can also use git commands to clone it.
```bash
$ git clone <clone_link> # clone_link is hhtps or ssh link of the git repository
```

## compile source code
```bash
$ make compile # compile on ly the source code
```
## Test
Tests check if the application works correctly.
To generate the tests classes, follow the next instructions:\
**WARNING:** to compile test classes, you should be sure the class ounder testing (files in src/competition) have already been compiled. Otherwise we doubt it will work (except by miracle).
```bash
$ make testCompile # compile only the test classes, be sure to have already done the previous step
```
## compile source code and tests in one step
```bash
$ make # compile both (tests) and (code under test) but also the jar (see bollow). 
```

## run test
```bash
$ make runTest # run all the test classes
```

## Documentation
If you want to read about using the programm, the ressource should be generated manually. \
Follow the instructions bellow.
- Open the project.
- Then use the makefile commands to generate the `documentations`.
```bash
$ make doc
```
- Then use this commande to open it on the navigator.
```bash
$ xdg-open ./docs/index.html
```





You should notice a new non-empty directory `docs` in the root of the project.

## Build the jar
**jar file is an executable based on zip file format, in the section we'll see how to generate it**

before this step, make sure you have already create the executables.

To generate the `jar` file, follow the following instructions.

- Go in the root of the project.
- Then execute the command:
```bash
$ make jar
```
You should notice a new files `Master.jar` `League.jar` `Tournament.jar` in the root.
You can now execute it !!!!

## Execute the Tournament Competition
```bash
$ java -jar Tournament.jar 
```

## Execute the League Competition
```bash
$ java -jar League.jar 
```

## Execute the Master Competition
```bash
$ java -jar Master.jar # this command will show the usage of the MasterCompetition
```
Try the following command to run an exemple of Master competition.

```bash
$ java -jar Master.java 3 losc pasg marseille lyon
```

Or this one with another Competition rule.
```bash
$ java -jar Master.jar 2 psg nantes marseille nice lyon reines lens ajaccio Troyes toulouse sochaux valencienne rennes reins nimes calais strasbourg limoge Dijon montpellier brest lorient clermont toulon
```

# Elements de conception
- Le Pattern Builder: Au fil des modifications, la construction des competitions mobilisait beacoups d'objets, qui n'etaient pas toujours imperatifs. Nous avons donc utiliser le pattern builder pour pallier le problème de construction.
- Pattern Strategy: CHaque competition de type master etait sujette à une règle (finaliste d'une poule, nombre de competiteurs). Nous nous sommes inspirer du pattern strategy pour implementer les reglements. Ainsi ils pourront facilemet etre interchangés
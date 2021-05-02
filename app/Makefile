clean:
	rm -rf build

build:
	javac -d build/classes -classpath build/classes:src/resources/* src/vaccine/manager/*.java

server:
	java -classpath build/classes:resources/* vaccine.manager.VaccineServer 9000

client:
	java -classpath build/classes:resources/* vaccine.manager.VaccineClient localhost 9000

registry:
	rmiregistry -J-classpath -Jbuild/classes 9000


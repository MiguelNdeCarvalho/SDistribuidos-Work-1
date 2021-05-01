clean:
	rm -rf build

build:
	javac -d build/classes -classpath build/classes src/vaccine/manager/*.java

server:
	java -classpath build/classes vaccine.manager.VaccineServer 9000

client:
	java -classpath build/classes vaccine.manager.VaccineClient localhost 9000

registry:
	rmiregistry -J-classpath -Jbuild/classes 9000


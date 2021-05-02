port = 9000

all:
	clean
	compile

clean:
	rm -rf build

compile:
	javac -d build/classes -classpath build/classes:src/resources/* src/vaccine/manager/*.java

registry:
	rmiregistry -J-classpath -Jbuild/classes $(port)

server:
	java -classpath build/classes:resources/* vaccine.manager.VaccineServer $(port)

client:
	java -classpath build/classes:resources/* vaccine.manager.VaccineClient localhost $(port)

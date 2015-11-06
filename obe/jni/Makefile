JNI=/opt/java/include
JNIOSX=/opt/java/include/linux

# JAVA
JAVA=java
JAVAC=javac
JAVAH=javah
JAVAHOME=/opt/java/

# C
CC=gcc
CFLAGS=-I $(JAVAHOME)include -I $(JAVAHOME)/include/linux -Wformat -Werror=format-security

.PONY: compileSO execute

all: CHelloWorld.class CHelloWorld.h compileSO

clean:
	@rm -v *.class
	@rm -v *.so
	@rm -v *.h

CHelloWorld.class: CHelloWorld.java
	@$(JAVAC) $<

CHelloWorld.h: CHelloWorld.class
	@$(JAVAH) -verbose CHelloWorld

compileSO:
	@$(CC) -shared -fPIE $(CFLAGS) CHelloWorld.c -o libCHelloWorld.so

execute:
	@$(JAVA) -Xcheck:jni -cp . -Djava.library.path=. CHelloWorld $(args)

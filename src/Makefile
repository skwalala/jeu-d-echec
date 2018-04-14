JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $*.java

CLASSES = \
	Piece.java \
	Fou.java \
	Pion.java \
	Tour.java \
	Dame.java \
	Cavalier.java \
	Roi.java \
	Jeu.java \
	Plateau.java

default: classes

test: clean classes exec

classes : $(CLASSES:.java=.class)

clean :
	rm *.class

exec :
	clear
	java Jeu

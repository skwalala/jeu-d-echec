JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $*.java

CLASSES = \
	Jeu.java \
	Piece.java \
	Plateau.java \
	Fou.java \
	Pion.java \
	Tour.java \
	Dame.java \
	Cavalier.java \
	Roi.java

default: classes

test: clean classes

classes : $(CLASSES:.java=.class)

clean :
	rm *.class

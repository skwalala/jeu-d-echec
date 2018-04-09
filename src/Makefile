JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $*.java

CLASSES = \
	Jeu.java \
	Piece.java \
	Plateau.java \
	Fou.java \
	Cavalier.java \
	Pion.java \
	Roi.java \
	Tour.java

default: classes

classes : $(CLASSES:.java=.class)

clean :
	rm *.class

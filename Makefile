NAME := todo

SRCDIR := ./srcs
OBJDIR := ./objs

MAIN := GUI

JDBC := ./jdbc/sqlite-jdbc-3.42.0.0.jar

DATABASE := ./database/database.db
DATABASE_SQL := ./database/insert.sql

SRCS := $(shell find $(SRCDIR) -mindepth 1 -type f -name "*.java")

$(NAME): class
	java -cp $(OBJDIR):$(JDBC) $(MAIN)

all: $(NAME)

clean:
	rm -rf $(OBJDIR)

re: clean all

database:
	sqlite3 $(DATABASE) < $(DATABASE_SQL)

class:
	javac -d ./objs $(SRCS)

.PHONY: all clean re
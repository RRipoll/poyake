# you need h2-1.4-196.jar in the same directory
java -cp h2*.jar org.h2.tools.Script -url "jdbc:h2:~/testdb" -user "sa" -password "sa" -script "backup.sql"

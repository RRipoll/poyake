cd framework/dbjavamap
mvn clean deploy
cd ../..
cd framework/commondata
mvn clean deploy
cd ../..
cd apps/poyake-label
mvn clean deploy
cd ../..
cd apps/poyake-audit
mvn clean deploy
cd ../..
cd apps/poyake-datagridsetting
mvn clean deploy
cd ../..
cd apps/poyake-permission
mvn clean deploy
cd ../..
cd framework/search
mvn clean deploy
cd ../..
cd framework/webappbase
mvn clean deploy
cd ../..
cd apps/poyake-file
mvn clean deploy
cd ../..
cd apps/poyake-file-ui
mvn clean deploy
cd ../..
cd apps/poyake-audit-ui
mvn clean deploy
cd cd ../..

cd apps/poyake-testrunner
mvn clean deploy 
cd ../..
cd apps/poyake-testrunner-events
mvn clean deploy 
cd ../..
cd apps/poyake-example
mvn clean deploy 
cd ../..
cd apps/poyake-roadrunner
mvn clean deploy 
cd ../..

cd apps/poyake-demo-metadata
mvn clean deploy
cd ../..
cd apps/poyake-demo
mvn clean deploy
cd ../..
cd controllers
mvn clean deploy
cd ..
cd apps/poyake-rest
mvn clean deploy




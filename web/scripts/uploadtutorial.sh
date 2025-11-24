#!/bin/bash

cd ~/git/metaplugin/tutorial/
tar czf poyake-tutorial-orm-simple.tgz poyake-tutorial-orm-simple
HOST='ftp.poyake.com'
USER='ftp.poyake.com'
PASS='VQQjax2s'
TARGETFOLDER='/public/tutorial'

lftp -v -f "
open $HOST
user $USER $PASS

ls
cd $TARGETFOLDER
put ~/git/metaplugin/tutorial/poyake-tutorial-orm-simple.tgz 
bye
"
rm ~/git/metaplugin/tutorial/poyake-tutorial-orm-simple.tgz


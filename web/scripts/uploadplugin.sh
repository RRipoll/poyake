#!/bin/bash
HOST='ftp.poyake.com'
USER='ftp.poyake.com'
PASS='VQQjax2s'
TARGETFOLDER='/public/updatesite'
SOURCEFOLDER=/home/jsantos/git/metaplugin/plugin/com.jsantos.metadata.plugin.updatesite

lftp -v -f "
open $HOST
user $USER $PASS

cd $TARGETFOLDER
lcd $SOURCEFOLDER
mirror -c --reverse
bye
"

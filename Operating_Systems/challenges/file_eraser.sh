#!/bin/sh
typeset dir
typeset -i date

dir=$1
date=$(date +%s)
((date=date/86400))

if [ -d $dir ]
then
    ls -lR $dir --time-style +%s | awk -v f=$date '$1~/:/ {tray=substr($1,1,length($1)-1)}
                            NF>1 && $5>200000 && (f-($6/86400))>30 {print "rm " tray "/" $7}' > temporal
else
    echo "Directorio " $dir "no existe"
fi
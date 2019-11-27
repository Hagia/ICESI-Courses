$processes = Get-Content ./../data/stoplist.txt
foreach($i in $processes){
    Stop-Process -Id $i
}
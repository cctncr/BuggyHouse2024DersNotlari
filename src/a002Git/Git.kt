package a002Git

/*
    cd (change directory) -> dosyaya gitme
    clear -> terminali temizler

    git --global user.name "<isim>" -> isim koyar
    git --global user.email "<email>" -> email koyar

    git init -> initialize eder
    git clone <url> -> uzak sunucuda bulunan repoyu clone'lar
    git clone <url> <directory> -> yazilan directory'e clone'lar
    git clone --branch <branch ismi> <url> -> branch'i getirir
    git clone --single-branch <branch ismi> <url> -> diger branchler download edilmez
    git clone --recursive <url> -> sub modulleri de icerek sekilde download eder

    git status -> degisiklikleri gosterir
    git status -s -> daha kisa bilgi

    git add <file ismi> -> untracked file'i staging area'ya ekler untracked -> tracked olur
    git add --all -> tum dosylari tracked yapar
    git reset -> staging area'dakileri geri cikarir ama yapilan islemi geri alma islemi degildir

    git diff -> yapilan degisiklikleri gosterir
    git diff --staged -> staging area'daki degisiklikleri gosterir
    git diff -stat -> kac dosya ve satir degisti gosterir

    git commit -m "<mesaj>" -> commitleme

    git log -> commit loglarini gosterir

    git push -> commitleri uzak sunucya pushlar
    git push -u <repo ismi> -> yazilan repoya pushlar
    git push --tags -> o tag'e pushlar

    git fetch -> uzak sunucuda degisiklik olup olmadigina bakar
    git pull -> uzak sunucudan ceker. conflict olabilir

    git branch <branch name>/<isim> -> branch olustur
    git checkout <branch name>/<isim> -> o branch'e gider
    git checkout -b <branch name>/<isim> -> branch olusturur ve o branch'e gider

    ONEMLI OLANLAR
    git --global user.name "<isim>"
    git --global user.email "<email>"
    git init
    git clone <url>
    git status
    git add .
    git reset
    git diff
    git commit -m "<mesaj>"
    git log
    git fetch
    git pull
    git branch
    git checkout

    GORSELLESTIREN WEB SITELERI
    https://visualizegit.com/
    https://dev.to/lydiahallie/cs-visualized-useful-git-commands-37p1
    https://github.com/git-school/visualizing-git
    https://onlywei.github.io/explain-git-with-d3/#fetch
    https://learngitbranching.js.org/
    https://marklodato.github.io/visual-git-guide/index-en.html
    https://githistory.xyz/
    https://gource.io/
 */

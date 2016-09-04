#!/bin/bash
# MDS - Script
#
# Script de atualização dos repositórios Git.
#  - verificar git stash
#  - problemas com makepkg
#
# autor: Marcelo dos Santos
#

skip=(citacoes files exercises emacs25-git mds mdssjc.github.io study)

update () {
    case $1 in
        "languagetool")
            ./build.sh languagetool-standalone clean package -DskipTests
            ;;
        "emacs")
            ./configure
            make
            make install
            ;;
        *)
            makepkg -s --skippgpcheck
            file=$(ls -A1t | tail -n +2 | head -1)
            pacman -U $file
            ;;
    esac
}

contains () {
    for d in ${skip[@]}
    do
        if [[ $d == $1 ]]
        then
            return 0
        fi
    done
    return 1
}

sudo echo "[[MDS]]"
for d in $(ls -d */); do
    directory=${d::-1}
    echo $directory

    if contains $directory == 0
    then
        echo "Skipping" $directory "..."
        continue
    fi

    cd $directory
    echo "Entering directory" $(pwd)

    git pull | grep "^Already up-to-date.$"
    if [[ $? -eq 1 ]]
    then
        update $directory
    fi

    echo "Leaving directory" $(pwd)
    cd ..
done

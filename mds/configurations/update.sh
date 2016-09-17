#!/bin/bash
# MDS - Script
#
# Script de atualização dos repositórios Git.
#  - verificar git stash
#  - problemas com makepkg
#
# autor: Marcelo dos Santos
#

skip=(citacoes exercises mds mdssjc.github.io study)
list=()

if [[ ${list[@]} -eq 1 ]]
then
  echo "vazio"
fi

update () {
    case $1 in
        "languagetool")
            ./build.sh languagetool-standalone clean package -DskipTests
            ;;
        "emacs")
            ./configure
            make
            sudo make install
            ;;
        *)
            #makepkg -s --skippgpcheck
            #file=$(ls -A1t | tail -n +2 | head -1)
            #pacman -U $file
            list+=$1
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

echo "[[MDS]]"
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

if [[ ${list[@]} -eq 0 ]]
then
  echo "---"
else
  echo "Updates"
  printf ${list}
fi

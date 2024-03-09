#!/bin/bash
remove_trailing_slash() {
    local input="$1"
    local result="${input//\//}"
    echo "$result"
}

currentChapter="$(remove_trailing_slash $1)"
currentPackage="$currentChapter/*"
currentClass=$2

rm -rf ./$currentChapter/*.class ./util/*.class

javac util/* $currentPackage 
java "$currentChapter.$currentClass"

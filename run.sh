#!/bin/sh

# create jar file for each module in "mods" directory
mvn clean package

# write logo
printf "\nRunning JPMS demo:\n"

# run demo
java --module-path mods -m jpms.demo.app/ro.fortsoft.jpms.demo.Boot

#!/bin/bash

read input
chars=${#input}

for ((i=1; i<$((chars-1)); i++)); do
	if [[ ${input:((${i}-1)):1} > ${input:${i}:1} ]]; then
		echo "NOT IN ORDER"
		exit
	fi 
done 

echo "IN ORDER"


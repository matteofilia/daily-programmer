from array import array

file = open("input_1.txt", "r")

nodes = int(file.readline())

#Create array
numConnected = [0] * nodes

#Figure out number of connections
for line in file:
	for connectedNode in [int(num) for num in line.split()]:
		numConnected[connectedNode-1] += 1

file.close();

for i in range(0, nodes):
	print("Node", i+1,"has a degree of", numConnected[i])

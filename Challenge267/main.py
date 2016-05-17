
import sys

def getNumberEnding(num):
	lastDigit = num % 10

	if num == 12 or num == 13 or num == 14:
		return "th"

	if lastDigit == 1:
		return "st"
	elif lastDigit == 2:
		return "nd"
	elif lastDigit == 3:
		return "rd"
	else:
		return "th"

place = int(input("Please enter the place your dog got: "))
maxPlaces = int(input("Please enter the total number of dogs: "))

for i in range(0, maxPlaces):
	if(i+1 != place):
		sys.stdout.write(str(i+1))
		sys.stdout.write(str(getNumberEnding(i+1)))
		sys.stdout.write(", ")

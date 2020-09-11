dict = {"theString": "A"}

def theFunctionThatTheyWantUsToUse():
    newString = ""
    for i in dict["theString"]:
        if i == "A":
            newString += "B"
        elif i == "B":
            newString += "BA"
    dict["theString"] = newString

def countLetters():
    countA = 0
    countB = 0

    for i in dict["theString"]:
        if i == "A":
            countA += 1
        elif i == "B":
            countB += 1

    print("OUTPUT " + str(countA) + " " + str(countB))

theNumber = int(input("K> "))

for i in range(0, theNumber):
    theFunctionThatTheyWantUsToUse()

countLetters()

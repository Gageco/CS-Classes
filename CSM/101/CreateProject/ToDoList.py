import webbrowser
import os

def exportLists():
    lookingForList = input("What list do you want to export?: ")
    htmlExport = "<!DOCTYPE html>\n<html>\n<body style=\"background-color:powderblue;\">\n<h2>" + lookingForList + "</h2>\n<ul>"
    fileLocation = 0

    with open("ToDoListFile.todo", "r") as file:
        for i, line in enumerate(file):

            if line.rstrip().lower() == lookingForList.lower():
                fileLocation = i+1

            if i == fileLocation:
                splitLineList = line.split("|")
                printItem = ""
                for j in splitLineList:
                    if j != "\n":
                        htmlExport += "<li>" + j + "</li>\n"

    mailOption = input("If you would like the option to email this to yourself please input email> ")

    htmlExport += "\n\n<a href=\"mailto:" + mailOption + "\">EMAIL THIS LIST TO YOURSELF</a></body>\n</html>"
    htmlFile = open(lookingForList.lower() + ".html", "a+")
    htmlFile.write(htmlExport)
    htmlFile.close()

    currentDir = os.getcwd() + "/" + lookingForList.lower() + ".html"
    print(currentDir)
    webbrowser.open(currentDir, new =  2)
    print("Exported to " + lookingForList.lower() + ".html")



def modifyList():                                                               #Modify the lists
    lookingForList = input("What list do you wish to change?: ")
    rewritingTheWholeList = ""
    fileLocation = 0
    #lol so i decided instead of modifying one line ill just store the whole text file in memory
    #I know its not efficient but who the heck cares this is cs101 im not supposed to know what im doing

    with open("ToDoListFile.todo", "r") as file:
        for i, line in enumerate(file):

            if line.rstrip() == lookingForList:
                fileLocation = i+1

            if i == fileLocation:
                print("Items in List: ")
                splitLineList = line.split("|")
                printItem = ""
                for j in splitLineList:
                    if j != "\n":
                        printItem += j + ", "
                print(printItem)

                itemDoneWith = input("What item are you done with?: ")
                itemOption = input("What would you like to do with the item? Mark Done: \'Done\' or Cancel: \'Cancel\': ")

                if itemOption.lower() == "done":
                    splitLineList.remove(itemDoneWith)
                    toRewrite = ""
                    for newItem in splitLineList:
                        toRewrite += newItem + "|"
                    rewritingTheWholeList += toRewrite
                elif itemOption.lower() == "cancel":
                    print("Canceling")
                else:
                    print("Invalid Option")
            else:
                rewritingTheWholeList += line
                #^^^ RIP cloud9 memory

    todoFile = open("ToDoListFile.todo", "w+")
    todoFile.write(rewritingTheWholeList)


def readList():                                                                 #Read items in list
    printItem = ""
    fileLocation = 1000000000
    fileFound = False

    with open("ToDoListFile.todo", "r") as file:
        lookingForList = input("What list are you looking for?: ")

        for i, line in enumerate(file):
            if line.rstrip() == lookingForList:
                fileLocation = i+1
                fileFound = True

            if i == fileLocation:
                splitLineList = line.split("|")
                for j in splitLineList:
                    if j != "\n":
                        printItem += j + ", "
                print(printItem)

    if fileFound == False:
        print("List not found")


def listLists():                                                                #List all lists in file
    i = 0
    print("Lists Created: ")
    with open("ToDoListFile.todo", "r") as file:
        for line in file:
            if i % 2 == 0:
                print(line.rstrip())
            i+=1


def helpFunc():                                                                 #Help function
    print("Commands:\n\'New\': Creates new list\n\'Modify\': Modify a list\n\'Read\': Reads all items in a list\n\'Done\': Exits Program\n\'List\': Lists all lists")


def writeToFile(passedList, listName):                                          #To write lists to file
    todoFile = open("ToDoListFile.todo", "a+")
    todoFile.write(listName+"\n")
    for item in passedList:
        todoFile.write(item + "|")
    todoFile.write("\n")
    todoFile.close()


def newList():                                                                  #To Make a new list
    repeatList = True
    i = 0

    userList = []
    listName = input("List Name: ")
    print("Please input items in list " + listName + ", type \'Done\' when done")

    while repeatList:
        newListItem = input("List Item " + str(i+1) + ": ")
        dueDate = input("Due Date for " + newListItem + ": " )
        i+=1
        if newListItem.lower() == "done":
            repeatList = False
        else:
            userList.append(newListItem + ", " + dueDate)

    writeToFile(userList, listName)
    print("Added to Lists")



while True:
    MainInput = input("INPUT> ")

    if MainInput.lower() == "new":                                              #New
        newList()
    elif MainInput.lower() == "modify":                                         #Modify
        modifyList()
        print("Modified List")
    elif MainInput.lower() == "read":                                           #Read
        readList()
    elif MainInput.lower() == "done":                                           #Done
        print("Have A Nice Day!")
        break
    elif MainInput.lower() == "help":                                           #Help
        helpFunc()
    elif MainInput.lower() == "list":                                           #List
        listLists()
    elif MainInput.lower() == "export":                                         #Export lists to html
        exportLists()
    else:
        print("Not Valid Input, try typing \'help\' if you are unsure of what to do")

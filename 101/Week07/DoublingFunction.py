def double_elements(my_list):
    newList = []
    for i in my_list:
        newList.append(i * 2)
    return newList


print(double_elements([1, 2, 3, 4]))
print(double_elements([7, 14, 21, 28, 35]))
print(double_elements([42, 42, 42]))
print(double_elements([]))

import re

file = open("input.txt", "r").read()


first_numbers = re.findall('\d*-', file)
second_numbers = re.findall('-\d*', file)
letters = re.findall('\w:', file)
passwords = re.findall('\w*,', file)



for i in range(1000):
    letters[i] = letters[i][0:-1]
    passwords[i] = passwords[i][0:-1]
    first_numbers[i] = int(first_numbers[i][0:-1])
    second_numbers[i] = int(second_numbers[i][1:])





def count_letters(password, letter):
    char_count = 0
    for char in password:
        if char == letter:
            char_count  = char_count + 1
    return char_count

def is_valid(password, letter, pos1, pos2):
    
    if password[pos1-1] == letter:
        if password[pos2-1] == letter:
            return False
        else:
            return True
    elif password[pos2-1] == letter:
        return True
    else:
        return False 

valid_passwords = 0
for i in range(1000):
    if is_valid(passwords[i],letters[i],first_numbers[i],second_numbers[i]):
        valid_passwords = valid_passwords + 1







print(first_numbers)
print(len(second_numbers))
print(len(passwords))
print(len(letters))
print(valid_passwords)



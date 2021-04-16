import re

file = open("input.txt", "r").read()


from_numbers = re.findall('\d*-', file)
to_numbers = re.findall('-\d*', file)
letters = re.findall('\w:', file)
passwords = re.findall('\w*,', file)



for i in range(1000):
    letters[i] = letters[i][0:-1]
    passwords[i] = passwords[i][0:-1]
    from_numbers[i] = from_numbers[i][0:-1]
    to_numbers[i] = to_numbers[i][1:]

def count_letters(password, letter):
    char_count = 0
    for char in password:
        if char == letter:
            char_count  = char_count + 1
    return char_count

def is_valid(password, letter, fromN, toN):
    if count_letters(password,letter) >= fromN and count_letters(password,letter) <= toN:
        return True
    else:
        return False

valid_passwords = 0
for i in range(1000):
    if is_valid(passwords[i],letters[i],int(from_numbers[i]),int(to_numbers[i])):
        valid_passwords = valid_passwords + 1







print(from_numbers)
print(len(to_numbers))
print(len(passwords))
print(len(letters))
print(valid_passwords)



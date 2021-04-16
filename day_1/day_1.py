from input import numbers

for x in numbers:
    for y in numbers:
        for z in numbers:
            if x + y + z == 2020:
                num1 = x
                num2 = y
                num3 = z
print(num1 * num2 * num3)




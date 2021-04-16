import re

mainInput = open("input.txt", "r").read()

arr = re.findall('.*\n', mainInput)



for i in range(len(arr)):
    arr[i] = arr[i][:-1]
    arr[i] = arr[i] * 500
    #print(arr[i])
    



def calculate_next_pos(pos_y, pos_x, num_of_trees, slope_y, slope_x):
    #print(f'Position y: {pos_y}')
    #print(f'Position x: {pos_x}')
    if arr[pos_y][pos_x] == '#':
        num_of_trees = num_of_trees + 1
     #   print("entro al if")
    pos_y = pos_y + slope_y
    pos_x = pos_x + slope_x
    return [pos_y, pos_x, num_of_trees]


def run_with_slope(slope_y, slope_x):
    pos_x = 0
    pos_y = 0
    num_of_trees = 0
    while pos_y < len(arr):
        data = calculate_next_pos(pos_y, pos_x, num_of_trees, slope_y, slope_x)
        pos_y = data[0]
        num_of_trees = data[2]
        pos_x = data[1]
    return num_of_trees

print(run_with_slope(1,3) * run_with_slope(1,1) * run_with_slope(1,5) * run_with_slope(1,7) * run_with_slope(2,1))
import re

file = open("input.txt", "r")
data = file.read()
file.close()

data_array = data.split('\n\n')

class Passport:
    def __init__(self, byr, iyr, eyr, hgt, hcl, ecl, pid, cid):
        self.byr = byr
        self.iyr = iyr
        self.eyr = eyr
        self.hgt = hgt
        self.hcl = hcl
        self.ecl = ecl
        self.pid = pid
        self.cid = cid

def stringify(field):
    if len(field) == 0:
        return ""
    else:
        return field[0]

def stringify_passport(passport):
    passport.byr = stringify(passport.byr)
    passport.iyr = stringify(passport.iyr)
    passport.eyr = stringify(passport.eyr)
    passport.hgt = stringify(passport.hgt)
    passport.hcl = stringify(passport.hcl)
    passport.ecl = stringify(passport.ecl)
    passport.pid = stringify(passport.pid)
    passport.cid = stringify(passport.cid)
    return passport

def intify_height(h_string):
    height = re.findall(r'^\d*',h_string)
    if len(height) == 0:
        return -1
    else:
        return int(height[0])


def check_validity(passport):
    passport = stringify_passport(passport)
    if passport.byr != "" and passport.iyr != "" and passport.eyr != "" and passport.hgt != "" and passport.hcl != "" and passport.ecl != "" and passport.pid != "":
        if (re.match(r'^\d{4}$', passport.byr) and int(passport.byr) >= 1920 and int(passport.byr) <= 2002) \
        and (re.match(r'^\d{4}$', passport.iyr) and int(passport.iyr) >= 2010 and int(passport.iyr) <= 2020) \
        and (re.match(r'^\d{4}$', passport.eyr) and int(passport.eyr) >= 2020 and int(passport.eyr) <= 2030) \
        and ((re.match(r'^\d*cm$', passport.hgt) and intify_height(passport.hgt) >= 150 and intify_height(passport.hgt) <= 193 ) or (re.match(r'^\d*in$', passport.hgt) and intify_height(passport.hgt) >= 59 and intify_height(passport.hgt) <= 76))\
        and re.match(r'^#[0-9a-f]{6}$', passport.hcl) \
        and re.match(r'^(amb|blu|brn|gry|grn|hzl|oth)$', passport.ecl) \
        and re.match(r'^\d{9}$', passport.pid):
            return True
        else:
            return False
    else:
        return False

passport_db = []


for passport in data_array:
    passport_db.append( Passport(re.findall(r'(?<=byr:)\S*', passport), re.findall(r'(?<=iyr:)\S*', passport), re.findall(r'(?<=eyr:)\S*', passport), re.findall(r'(?<=hgt:)\S*',passport), re.findall(r'(?<=hcl:)\S*', passport), re.findall(r'(?<=ecl:)\S*', passport), re.findall(r'(?<=pid:)\S*', passport), re.findall(r'(?<=cid:)\S*', passport)))


num_valid = 0
for passport in passport_db:
    if check_validity(passport):
        num_valid = num_valid + 1

print(num_valid)
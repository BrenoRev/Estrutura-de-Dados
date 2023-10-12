def next_palin(number):
    num_str = str(number)
    length = len(num_str)
    
    if number == None or number == 9:
        return 11 
    elif number < 9:
        return number +1

    if length == 2:
        if (int(num_str[1]) <= int(num_str[0])) and not isPalindrome(number):
            return int(num_str[0] + num_str[0])
        else:
            return int(str(int(num_str[0]) + 1) + str(int(num_str[0]) + 1))
        
    # All < 9 cases and nine
    if number < 9:
        return number + 1
    
    # All 9s edge case
    if num_str == "9" * length:
        return int("1" + "0" * (length - 1) + "1")

    half_length = length // 2
    left = num_str[:half_length]
    middle = num_str[half_length:-half_length] if length % 2 else ''

    mirrored = left + middle + left[::-1]
    if int(mirrored) > number:
        return int(mirrored)

    if length % 2:
        left_and_middle = int(left + middle) + 1
        new_left = str(left_and_middle)[:-1]
        new_middle = str(left_and_middle)[-1]
    else:
        left_and_middle = int(left) + 1
        new_left = str(left_and_middle)
        new_middle = ''

    value = int(new_left + new_middle + new_left[::-1])
    return value

def isPalindrome(number):
    return int(str(number)[::-1]) == number
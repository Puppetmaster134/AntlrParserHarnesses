def complex_calculation(a, b):
    result = 0
    if a > 0:
        temp_a = a * 2
        if b > 0:
            temp_b = b * 3
            result = temp_a + temp_b
        else:
            temp_b = b * 4
            result = temp_a - temp_b
    elif a < 0:
        temp_a = a * 3
        if b > 0:
            temp_b = b * 2
            result = temp_a + temp_b
        else:
            temp_b = b * 5
            result = temp_a - temp_b
    else:
        temp_a = a * 4
        if b > 0:
            temp_b = b * 6
            result = temp_a + temp_b
        else:
            temp_b = b * 7
            result = temp_a - temp_b

    return result

def main():
    x = int(input("Enter a value for x: "))
    y = int(input("Enter a value for y: "))

    if x > 0:
        result1 = complex_calculation(x, y)
        print(f"Result 1: {result1}")
    else:
        z = int(input("Enter a value for z: "))
        if z > 0:
            result2 = complex_calculation(y, z)
            print(f"Result 2: {result2}")
        else:
            w = int(input("Enter a value for w: "))
            result3 = complex_calculation(z, w)
            print(f"Result 3: {result3}")

if __name__ == "__main__":
    main()


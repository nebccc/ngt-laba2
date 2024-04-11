N = int(input("Input length: "))
M = int(input("Input width: "))

commands = input("Input all commands: ")

x = y = 0

def fun(commands):
    global x,y

    for command in commands:
        if command == 'L':
            x -= 1
        elif command == 'R':
            x += 1
        elif command == 'D':
            y += 1
        elif command == 'U':
            y -= 1
        else:
            raise Exception("Invalid command - {}".format(command))

        if abs(y) >= N or abs(x) >= M:
            print("No")
            return False

    return True

if fun(commands):
    print("({},{})".format(M - abs(x), N - abs(y)))
